import java.util.Scanner;

/**
 * Class that outputs all the messages to the user on the interface.
 */

public class Ui {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * All the methods in this class will be just for printing and receiving commands.
     * Empty constructor.
     */
    public Ui() {
    }

    /**
     * Prints the welcome message on startup.
     */
    public void printWelcomeMessage () {
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
    }

    /**
     * Prints all the tasks in the list currently when users input "list".
     * @param list list of all the tasks.
     */
    public void printTaskListMessage(TaskList list) {
        for (int i = 1; i < list.size() + 1; i++) {
            System.out.println(i + "." + list.get(i - 1));
        }
    }

    /**
     * Prints the delete task message and displays number of tasks in the list.
     * @param current the current task to be deleted.
     */
    public void printDeleteTaskMessage(Task current) {
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + current);
    }

    /**
     * Prints the add task message and displays number of tasks in the list.
     * @param current the current task to be added.
     */
    public void printAddEventMessage(Task current) {
        System.out.println("     Got it. I've added this task:");
        System.out.println("       " + current);
    }

    /**
     * Prints the done task message.
     * @param current the current task that is done.
     */
    public void printDoneTaskMessage(Task current) {
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("       " + current);
    }

    /**
     * Prints the number of tasks in task list.
     * @param tasks task list to find number of tasks from.
     */
    public void printNumberOfTasksMessage(TaskList tasks) {
        System.out.println("     Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Shows loading error when Duke is unable to find the file.
     */
    public void showLoadingError() {
        System.out.println("File not found! Starting from a new list now...");
    }

    /**
     * Shows error message.
     * @param message error message.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Prints the message before showing the matching tasks.
     */
    public void printFindMessage() {
        System.out.println("     Here are the matching tasks in your list:");
    }

    /**
     * Prints the task with the found keyword.
     * @param counter index of the found keyword.
     * @param task task with the found keyword.
     */
    public void printFoundMessage(int counter, Task task) {
        System.out.println("     " + counter + "." + task);
    }
}
