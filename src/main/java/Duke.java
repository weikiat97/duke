import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        ArrayList lst = new ArrayList<String>();
        int counter = 1;
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println("Bye. hope to see you again soon!");
                break;
            } else if (input.equals("list")) {
                for (int i = 0; i < lst.size(); i++) {
                    System.out.println(lst.get(i));
                }
            } else {
                System.out.println("added: " + input);
                lst.add(counter + ". " + input);
                counter++;
            }
        }
    }
}

