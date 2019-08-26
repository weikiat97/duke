import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Duke {
    public static void main(String[] args) throws DukeException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> lst = new ArrayList<Task>();
        int counter = 0;
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        try {
            while (sc.hasNext()) {
                String input = sc.nextLine();
                String myArray[];
                myArray = input.split(" ");
                String currTask = myArray[0];
                if (currTask.equals("bye")) {
                    System.out.println("Bye. hope to see you again soon!");
                    break;
                } else if (currTask.equals("list")) {
                    for (int i = 1; i < lst.size() + 1; i++) {
                        System.out.println(i + "." + lst.get(i - 1));
                    }
                } else if (currTask.equals("done")) {
                    String numString = myArray[1];
                    int num = Integer.valueOf(numString);
                    Task curr = lst.get(num - 1);
                    curr.isDone();
                    System.out.println(curr.doneJob());
                } else if (currTask.equals("deadline")) {
                    int cutoff = 0;
                    String task = "";
                    String time = "";
                    for (int j = 1; j < myArray.length; j++) {
                        if (myArray[j].charAt(0) == '/') {
                            cutoff = j;
                            break;
                        } else {
                            if (j != 1) {
                                task += " ";
                            }
                            task += myArray[j];
                            cutoff = j;
                        }
                    }
                    for (int k = cutoff + 1; k < myArray.length; k++) {
                        if (k != cutoff + 1) {
                            time += " ";
                        }
                        time += myArray[k];
                    }
                    lst.add(new Deadline(task, time));
                    counter++;
                    System.out.println("Got it. I've added this task:\n  " + lst.get(counter - 1)
                            + "\nNow you have " + counter + " tasks in the list.");
                } else if (currTask.equals("event")) {
                    int cutoff = 0;
                    String task = "";
                    String time = "";
                    for (int j = 1; j < myArray.length; j++) {
                        if (myArray[j].charAt(0) == '/') {
                            cutoff = j;
                            break;
                        } else {
                            if (j != 1) {
                                task += " ";
                            }
                            task += myArray[j];
                            cutoff = j;
                        }
                    }
                    for (int k = cutoff + 1; k < myArray.length; k++) {
                        if (k != cutoff + 1) {
                            time += " ";
                        }
                        time += myArray[k];
                    }
                    lst.add(new Event(task, time));
                    counter++;
                    System.out.println("Got it. I've added this task:\n  " + lst.get(counter - 1)
                            + "\nNow you have " + counter + " tasks in the list.");
                } else if (currTask.equals("todo")) {
                    String task = "";
                    for (int j = 1; j < myArray.length; j++) {
                        if (j != 1) {
                            task += " ";
                        }
                        task += myArray[j];
                    }
                    lst.add(new ToDo(task));
                    counter++;
                    System.out.println("Got it. I've added this task:\n  " + lst.get(counter - 1)
                            + "\nNow you have " + counter + " tasks in the list.");
                } else if (currTask.equals("delete")) {
                    String numString = myArray[1];
                    int num = Integer.valueOf(numString);
                    Task curr = lst.remove(num - 1);
                    counter--;
                    System.out.println("Noted. I've removed this task:\n  " + curr
                            + "\nNow you have " + counter + " tasks in the list.");
                } else {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }
        } catch (DukeException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid item in the list!");
        }
    }
}

class Task {
    protected String job;
    protected String status;

    public Task(String job) {
        this.job = job;
        this.status = "[✗]";
    }

    public void isDone() {
        this.status = "[✓]";
    }

    public String doneJob() {
        return "Nice! I've marked this task as done:\n  " + status + " " + job;
    }

    @Override
    public String toString() {
        return status + " " + job;
    }

}

class ToDo extends Task {

    public ToDo(String job) throws DukeException {
        super(job);
        String check = job;
        if (job.equals("")) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

class Event extends Task {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    protected Date date;

    public Event(String job, String at) throws DukeException {
        super(job);
        try {
            this.date = sdf.parse(at);
            if (job.equals("")) {
                throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
            } else if (at.equals("")) {
                throw new DukeException("☹ OOPS!!! The date/time of an event cannot be empty.");
            }
        } catch (ParseException e) {
            throw new DukeException("Error in format! Event must be written in \"(event name) " +
                    "/at dd/MM/yyyy HHmm\" format");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + sdf.format(date) + ")";
    }
}

class Deadline extends Task {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    protected Date date;

    public Deadline(String job, String by) throws DukeException {
        super(job);
        try {
            this.date = sdf.parse(by);
            if (job.equals("")) {
                throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
            } else if (by.equals("")) {
                throw new DukeException("☹ OOPS!!! The date/time of a deadline cannot be empty.");
            }
        } catch (ParseException e) {
            throw new DukeException("Error in format! Deadline must be written in \"(deadline name) " +
                    "/at dd/MM/yyyy HHmm\" format");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + sdf.format(date) + ")";
    }
}

class DukeException extends Exception {

    public DukeException(String message) {
        super(message);
    }
}