package duke.command;

import duke.Storage;
import duke.task.TaskList;

/**
 * Class to output all the errors that was caught in parsing.
 */
public class ErrorCommand extends Command {
    private final String errorMessage;

    /**
     * Constructor to set the error message.
     * @param errorMessage task to be added.
     */
    public ErrorCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * executes the add command.
     * @param tasks TaskList of all the current tasks.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        return this.errorMessage;
    }
}
