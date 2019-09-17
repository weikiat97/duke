package duke.command;

import duke.task.TaskList;
import duke.Storage;

/**
 * Class that represents the hello command.
 */
public class HelloCommand extends Command {

    /**
     * Constructor that introduces the command.
     */
    public HelloCommand() {
    }

    /**
     * Executes the hello command.
     * @param tasks TaskList of all the current tasks.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        return "Hello boss! I am Bunnie, your personal assistant! Use any of my following commands:\n"
                + "hello, list, delete, find, done, todo, deadline, event, postpone, bye";
    }
}