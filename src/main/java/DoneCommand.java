import java.io.IOException;

/**
 * Class that represents the done command.
 */
public class DoneCommand extends Command {

    private final int taskNumber;

    /**
     * Constructor to see which task to mark as done from task list.
     * @param taskNumber the index of task that is done from the list.
     */
    public DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Executes the done command.
     * @param tasks TaskList of all the current tasks.
     * @param ui Ui to deal with interactions with the user.
     * @param storage Storage to save tasks in the file after execution.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task currentTask = tasks.get(taskNumber - 1);
            currentTask.isDone();
            ui.printDoneTaskMessage(currentTask);
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }
}
