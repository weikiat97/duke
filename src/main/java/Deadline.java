import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    protected Date date;

    public Deadline(String job, String by) throws DukeException {
        super(job);
        try {
            this.date = sdf.parse(by);
            if (job.equals("")) {
                throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
            } else if (by.equals("")) {
                throw new DukeException("☹ OOPS!!! The date/time of a deadline cannot be empty.");
            }
        } catch (ParseException e) {
            throw new DukeException("Error in format! Deadline must be written in \"(deadline name) " +
                    "/at dd/MM/yyyy HHmm\" format");
        }
    }

    @Override
    public String outputToFile() {
        return String.format("D | %d | %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job, sdf.format(date));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + sdf.format(date) + ")";
    }
}
