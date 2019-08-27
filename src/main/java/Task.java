public class Task {

    protected String job;
    protected String status;

    public Task(String job) {
        this.job = job;
        this.status = "[✗]";
    }

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

    public String outputToFile() {
        return String.format("Task | %d | %s", this.status.equals("[✓]") ? 1 : 0, this.job);
    }

    @Override
    public String toString() {
        return status + " " + job;
    }

}
