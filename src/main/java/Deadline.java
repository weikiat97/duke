public class Deadline extends Task {

    protected String by;

    public Deadline(String job, String by) throws DukeException{
        super(job);
        this.by = by;
        if (job.equals("")) {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
        } else if (by.equals("")) {
            throw new DukeException("☹ OOPS!!! The date/time of an event cannot be empty.");
        }
    }

    @Override
    public String outputToFile() {
        return String.format("D | %d | %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job, this.by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
