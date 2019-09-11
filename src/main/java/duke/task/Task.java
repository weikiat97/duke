package duke.task;


import duke.DukeException;

/**
 * Class to represent the task in the task list.
 */
public class Task {

    protected String job;
    protected String status;
    protected String taskType;

    /**
     * Constructs a new task.
     * @param job the task to be added to the task list.
     */
    public Task(String job) {
        this.job = job;
        this.status = "[✗]";
        taskType = "";
    }

    protected void changeType(String taskType) {
        this.taskType = taskType;
    }

    public String getType() {
        return this.taskType;
    }

    public void snooze(String date) throws DukeException {};

    public void snooze(String startTime, String endTime) throws DukeException {};

    /**
     * Changes the status of the task to done.
     */
    public void isDone() {
        this.status = "[✓]";
    }

    /**
     * Find the job of the task.
     * @return the task's job.
     */
    public String getJob() {
        return this.job;
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
