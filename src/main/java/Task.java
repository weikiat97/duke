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

    public String doneJob() {
        return "Nice! I've marked this task as done:\n  " + status + " " + job;
    }

    public String outputToFile() {
        return String.format("Task | %d | %s", this.status.equals("[✓]") ? 1 : 0, this.job);
    }

    @Override
    public String toString() {
        return status + " " + job;
    }

}
