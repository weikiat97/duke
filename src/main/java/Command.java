/**
 * Abstract class command that represents all the different possible commands.
 */

public abstract class Command {

    /**
     * Executes the command that is given.
     * @param tasks TaskList of all the current tasks.
     * @param ui Ui to deal with interactions with the user.
     * @param storage Storage to save tasks in the file after execution.
     */
    public abstract String execute(TaskList tasks, Ui ui, Storage storage);

}
