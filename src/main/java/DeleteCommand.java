import java.io.IOException;

/**
 * Class that represents the delete command.
 */
public class DeleteCommand extends Command {

    private final int taskNumber;

    /**
     * Constructor to see which task to delete from task list.
     * @param taskNumber the index of task to be deleted from the list.
     */
    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Executes the delete command.
     * @param tasks TaskList of all the current tasks.
     * @param ui Ui to deal with interactions with the user.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task currentTask = tasks.delete(taskNumber - 1);
            String deleteMessage = "     Noted. I've removed this task:\n       " + currentTask;
            String numberOfTaskMessage = "     Now you have " + tasks.size() + " tasks in the list.";
            storage.writeFile(tasks);
            return deleteMessage + "\n" + numberOfTaskMessage;
        } catch (IOException e) {
            return "Error writing tasks to file!";
        } catch (IndexOutOfBoundsException e) {
            return "Index must be between 1 and " + tasks.size();
        }
    }
}