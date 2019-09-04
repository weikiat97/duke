import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to represent the Deadline tasks.
 */
public class Deadline extends Task {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    private Date date;

    /**
     * Constructs a new Deadline task.
     * @param job the Deadline task to be added to the task list.
     * @param by the time of the deadline.
     * @throws DukeException if there is an error in formatting.
     */
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

    /**
     * Formats the Deadline task to be added to the txt file.
     * @return String to be added to the txt file.
     */
    @Override
    public String outputToFile() {
        return String.format("D | %d | %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job, sdf.format(date));
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + sdf.format(date) + ")";
    }
}
