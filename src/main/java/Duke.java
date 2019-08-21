import java.util.Scanner;
import java.util.ArrayList;


public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        ArrayList<Task> lst = new ArrayList<Task>();
        int counter = 1;
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String myArray[];
            myArray = input.split(" ");
            if (input.equals("bye")) {
                System.out.println("Bye. hope to see you again soon!");
                break;
            } else if (input.equals("list")) {
                for (int i = 0; i < lst.size(); i++) {
                    System.out.println(lst.get(i));
                }
            } else if (myArray[0].equals("done")){
                String numString = myArray[1];
                int num = Integer.valueOf(numString);
                Task curr = lst.get(num - 1);
                curr.isDone();
                System.out.println(curr.doneJob());
            } else {
                System.out.println("added: " + input);
                Task task = new Task(counter, input);
                lst.add(task);
                counter++;
            }
        }
    }
}

class Task {
    protected int num;
    protected String job;
    protected String status;

    public Task(int num, String job) {
        this.num = num;
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
        return num + "." + status + " " + job;
    }

}