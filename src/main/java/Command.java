/**
 * Abstract class command that represents all the different possible commands.
 */

public abstract class Command {

    protected boolean exit = false;

    /**
     * Checks whether the programme should exit.
     * @return boolean of whether the programme should exit.
     */
    public boolean isExit() {
        return this.exit;
    }

    /**
     * Executes the command that is given.
     * @param tasks TaskList of all the current tasks.
     * @param ui Ui to deal with interactions with the user.
     * @param storage Storage to save tasks in the file after execution.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

}
