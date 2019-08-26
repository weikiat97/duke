import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    protected Date date;

    public Event(String job, String at) throws DukeException {
        super(job);
        try {
            this.date = sdf.parse(at);
            if (job.equals("")) {
                throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
            } else if (at.equals("")) {
                throw new DukeException("☹ OOPS!!! The date/time of an event cannot be empty.");
            }
        } catch (ParseException e) {
            throw new DukeException("Error in format! Event must be written in \"(event name) " +
                    "/at dd/MM/yyyy HHmm\" format");
        }
    }

    @Override
    public String outputToFile() {
        return String.format("E | %d | %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job, sdf.format(date));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + sdf.format(date) + ")";
    }
}