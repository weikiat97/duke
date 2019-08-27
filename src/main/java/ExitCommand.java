/**
 * Class that represents the exit command.
 */
public class ExitCommand extends Command {

    /**
     * Constructor that sets the boolean exit to be true. Stops the programme after this.
     */
    public ExitCommand() {
        exit = true;
    }

    /**
     * Executes the exit command.
     * @param tasks TaskList of all the current tasks.
     * @param ui Ui to deal with interactions with the user.
     * @param storage Storage to save tasks in the file after execution.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printByeMessage();
    }
}