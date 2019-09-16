package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.Storage;
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
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        try {
            tasks.add(task);
            String eventMessage = "Yes boss. I've added this task:\n       " + task;
            String numberOfTaskMessage = String.format("Now you have %d %s in the list.", tasks.size(),
                    tasks.size() > 1 ? "tasks" : "task");
            storage.writeFile(tasks);
            return eventMessage + "\n" + numberOfTaskMessage;
        } catch (IOException e) {
            return "Oops! There was an error writing tasks to file! :(";
        }
    }
}
