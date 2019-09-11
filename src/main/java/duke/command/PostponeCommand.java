package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.task.Task;
import duke.task.TaskList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that represents the postpone command.
 */
public class PostponeCommand extends Command {

    private final int taskNumber;
    private ArrayList<String> returnCommand;

    /**
     * Constructor to see which task to postpone from task list.
     * @param taskNumber the index of task to be postponed from the list.
     */
    public PostponeCommand(int taskNumber, ArrayList<String> returnCommand) {
        this.taskNumber = taskNumber;
        this.returnCommand = returnCommand;
    }

    /**
     * Executes the postpone command.
     * @param tasks TaskList of all the current tasks.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        try {
            Task currentTask = tasks.get(taskNumber - 1);
            if (currentTask.getType().equals("ToDo")) {
                return ("Current job is ToDo, there is no date to postpone!");
            } else if (currentTask.getType().equals("Deadline")) {
                currentTask.snooze(returnCommand.get(0));
            } else if (currentTask.getType().equals("Event")) {
                currentTask.snooze(returnCommand.get(0), returnCommand.get(1));
            }
            storage.writeFile(tasks);
            return "Alright! I've postponed the timings for this task:\n       " + currentTask;
        } catch (IOException e) {
            return "Error writing tasks to file!";
        } catch (IndexOutOfBoundsException e) {
            return "Error! Index must be between 1 and " + tasks.size() + "!";
        } catch (DukeException e) {
            return "Error! Format should be postpone (index) (dd/mm/yyyy hhmm)! ";
        }
    }


}
