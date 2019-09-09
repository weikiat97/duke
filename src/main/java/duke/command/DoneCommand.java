package duke.command;

import duke.task.TaskList;
import duke.task.Task;
import duke.Storage;
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
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        try {
            Task currentTask = tasks.get(taskNumber - 1);
            currentTask.isDone();
            storage.writeFile(tasks);
            return "Nice! I've marked this task as done:\n       " + currentTask;
        } catch (IOException e) {
            return "Error writing tasks to file!";
        } catch (IndexOutOfBoundsException e) {
            return "Error! Index must be between 1 and " + tasks.size() + "!";
        }
    }
}
