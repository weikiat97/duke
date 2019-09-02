import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to represent the Event tasks.
 */
public class Event extends Task {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    private final SimpleDateFormat sdfEndTime = new SimpleDateFormat("HHmm");
    private Date dateAndStartTime;
    private Date dateAndEndTime;

    /**
     * Constructs a new Event task.
     * @param job the Event task to be added to the task list.
     * @param startTime the date and start time of the event.
     * @param endTime the end time of the event.
     * @throws DukeException if the description or the date and time of the event is empty.
     */
    public Event(String job, String startTime, String endTime) throws DukeException {
        super(job);
        try {
            this.dateAndStartTime = sdf.parse(startTime);
            this.dateAndEndTime = sdfEndTime.parse(endTime);
            if (job.equals("")) {
                throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
            } else if (startTime.equals("") || endTime.equals("")) {
                throw new DukeException("☹ OOPS!!! The date/time of an event cannot be empty.");
            }
        } catch (ParseException e) {
            throw new DukeException("Error in format! Event must be written in \"(event name) " +
                    "/at dd/MM/yyyy HHmm to HHmm\" format");
        }
    }

    /**
     * Formats the Event task to be added to the txt file.
     * @return String to be added to the txt file.
     */
    @Override
    public String outputToFile() {
        return String.format("E | %d | %s | %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job,
                sdf.format(dateAndStartTime), sdfEndTime.format(dateAndEndTime));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + sdf.format(dateAndStartTime) + " to " +
                sdfEndTime.format(dateAndEndTime) + ")";
    }
}
