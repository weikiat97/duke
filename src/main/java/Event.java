public class Event extends Task {

    protected String at;

    public Event(String job, String at) throws DukeException {
        super(job);
        this.at = at;
        if (job.equals("")) {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
        } else if (at.equals("")) {
            throw new DukeException("☹ OOPS!!! The date/time of an event cannot be empty.");
        }
    }

    @Override
    public String outputToFile() {
        return String.format("E | %d | %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job, this.at);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
