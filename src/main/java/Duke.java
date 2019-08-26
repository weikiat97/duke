import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class Duke {
    public static void main(String[] args) throws DukeException {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage("./duke/src/main/java/data/duke.txt");
        ArrayList<Task> lst = storage.readFile();
        int counter = lst.size();
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
            storage.writeFile(lst);
        } catch (DukeException e) {
                System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid item in the list!");
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
