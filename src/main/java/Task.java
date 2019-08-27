/**
 * Class to represent the task in the task list.
 */
public class Task {

    protected String job;
    protected String status;

    /**
     * Constructs a new task.
     * @param job the task to be added to the task list.
     */
    public Task(String job) {
        this.job = job;
        this.status = "[✗]";
    }

    /**
     * Changes the status of the task to done.
     */
    public void isDone() {
        this.status = "[✓]";
    }


    /**
     * Formats the task to be added to the txt file.
     * @return String to be added to the txt file.
     */
    public String outputToFile() {
        return String.format("Task | %d | %s", this.status.equals("[✓]") ? 1 : 0, this.job);
    }

    @Override
    public String toString() {
        return status + " " + job;
    }

}
