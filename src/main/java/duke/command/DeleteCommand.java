package duke.command;

import duke.task.TaskList;
import duke.task.Task;
import duke.Storage;
import java.io.IOException;

/**
 * Class that represents the delete command.
 */
public class DeleteCommand extends Command {

    private final int taskNumber;

    /**
     * Constructor to see which task to delete from task list.
     * @param taskNumber the index of task to be deleted from the list.
     */
    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Executes the delete command.
     * @param tasks TaskList of all the current tasks.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        try {
            Task currentTask = tasks.delete(taskNumber - 1);
            String deleteMessage = "     Noted. I've removed this task:\n       " + currentTask;
            String numberOfTaskMessage = String.format("Now you have %d %s in the list.", tasks.size(),
                    tasks.size() > 1 ? "tasks" : "task");
            storage.writeFile(tasks);
            return deleteMessage + "\n" + numberOfTaskMessage;
        } catch (IOException e) {
            return "Error writing tasks to file!";
        } catch (IndexOutOfBoundsException e) {
            return "Error! Index must be between 1 and " + tasks.size() + "!";
        }
    }
}