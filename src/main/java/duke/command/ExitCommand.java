package duke.command;

import duke.task.TaskList;
import duke.Storage;

/**
 * Class that represents the exit command.
 */
public class ExitCommand extends Command {

    /**
     * Constructor that sets the boolean exit to be true. Stops the programme after this.
     */
    public ExitCommand() {
    }

    /**
     * Executes the exit command.
     * @param tasks TaskList of all the current tasks.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        return "Bye! Hope to see you again soon!";
    }
}