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
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.add(task);
            ui.printAddEventMessage(task);
            ui.printNumberOfTasksMessage(tasks);
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }
}
