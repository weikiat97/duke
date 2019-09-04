package duke.task;

import duke.task.Task;
import java.util.ArrayList;

/**
 * Class that contains the task list that allows users to do operations on the tasks in the list.
 */
public class TaskList {

    private final ArrayList<Task> tasks;

    /**
     * Initialises an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     * @param task Task to be added to task list.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Gets the number of tasks in the task list.
     * @return the number of tasks in the task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Gets the task that user is looking for.
     * @param taskNumber The number of the corresponding task that user is looking for.
     * @return Task that user is looking for.
     * @throws IndexOutOfBoundsException if task number is more than number of items in list or less than 0.
     */
    public Task get(int taskNumber) throws IndexOutOfBoundsException {
        return tasks.get(taskNumber);
    }

    /**
     * Deletes the task that user is looking for
     * @param taskNumber The number of the corresponding task that user is looking for.
     * @return Task that user is looking for.
     * @throws IndexOutOfBoundsException if task number is more than number of items in list or less than 0.
     */
    public Task delete(int taskNumber) throws IndexOutOfBoundsException {
        return tasks.remove(taskNumber);
    }

}
