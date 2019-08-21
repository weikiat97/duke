import java.util.Scanner;
import java.util.ArrayList;


public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        ArrayList<Task> lst = new ArrayList<Task>();
        int counter = 0;
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String myArray[];
            myArray = input.split(" ");
            if (input.equals("bye")) {
                System.out.println("Bye. hope to see you again soon!");
                break;
            } else if (input.equals("list")) {
                for (int i = 1; i < lst.size() + 1; i++) {
                    System.out.println(i + "." + lst.get(i - 1));
                }
            } else if (myArray[0].equals("done")){
                String numString = myArray[1];
                int num = Integer.valueOf(numString);
                Task curr = lst.get(num - 1);
                curr.isDone();
                System.out.println(curr.doneJob());
            } else if (myArray[0].equals("deadline")){
                int cutoff = 0;
                String task = "";
                String time = "";
                for (int j = 1; j < myArray.length; j++) {
                    if (myArray[j].charAt(0) == '/') {
                        cutoff = j;
                        break;
                    } else {
                        task += " ";
                        task += myArray[j];
                    }
                }
                for (int k = cutoff + 1; k < myArray.length; k++) {
                    time += " ";
                    time += myArray[k];
                }
                lst.add(new Deadline(task, time));
                counter++;
                System.out.println("Got it. I've added this task:\n  " + lst.get(counter - 1)
                        + "\nNow you have " + counter + " tasks in the list.");
            } else if (myArray[0].equals("event")){
                int cutoff = 0;
                String task = "";
                String time = "";
                for (int j = 1; j < myArray.length; j++) {
                    if (myArray[j].charAt(0) == '/') {
                        cutoff = j;
                        break;
                    } else {
                        task += " ";
                        task += myArray[j];
                    }
                }
                for (int k = cutoff + 1; k < myArray.length; k++) {
                    time += " ";
                    time += myArray[k];
                }
                lst.add(new Event(task, time));
                counter++;
                System.out.println("Got it. I've added this task:\n  " + lst.get(counter - 1)
                        + "\nNow you have " + counter + " tasks in the list.");
            } else if (myArray[0].equals("todo")){
                String task = "";
                for (int j = 1; j < myArray.length; j++) {
                    task += " ";
                    task += myArray[j];
                }
                lst.add(new ToDo(task));
                counter++;
                System.out.println("Got it. I've added this task:\n  " + lst.get(counter - 1)
                        + "\nNow you have " + counter + " tasks in the list.");
            }
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
        return status + job;
    }

}

class ToDo extends Task {

    public ToDo(String job) {
        super(job);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

class Event extends Task {

    protected String at;

    public Event(String job, String at) {
        super(job);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at:" + at + ")";
    }
}

class Deadline extends Task {

    protected String by;

    public Deadline(String job, String by) {
        super(job);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + by + ")";
    }
}
