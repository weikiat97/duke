/**
 * Class that represents the list command.
 */
public class ListCommand extends Command {

    /**
     * Empty constructor.
     */
    public ListCommand() {
    }

    /**
     * Executes the list command.
     * @param tasks TaskList of all the current tasks.
     * @param ui Ui to deal with interactions with the user.
     * @param storage Storage to save tasks in the file after execution.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printTaskListMessage(tasks);
    }
}
