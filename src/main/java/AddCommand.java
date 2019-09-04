import java.io.IOException;

/**
 * Class that represents the add command.
 */
public class AddCommand extends Command {

    private final Task task;

    /**
     * Constructor to set the task to be added.
     * @param task task to be added.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * executes the add command.
     * @param tasks TaskList of all the current tasks.
     * @param ui Ui to deal with interactions with the user.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.add(task);
            String eventMessage = "     Got it. I've added this task:\n       " + task;
            String numberOfTaskMessage = "     Now you have " + tasks.size() + " tasks in the list.";
            storage.writeFile(tasks);
            return eventMessage + "\n" + numberOfTaskMessage;
        } catch (IOException e) {
            return "Error writing tasks to file!";
        }
    }
}
