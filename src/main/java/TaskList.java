import java.util.ArrayList;

/**
 * Class that contains the task list that allows users to do operations on the tasks in the list.
 */
public class TaskList {

    private ArrayList<Task> tasks;

    /**
     * Initialises an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public int size() {
        return tasks.size();
    }

    public Task get(int taskNumber) throws IndexOutOfBoundsException {
        return tasks.get(taskNumber);
    }

    public Task delete(int taskNumber) throws IndexOutOfBoundsException {
        return tasks.remove(taskNumber);
    }

}
