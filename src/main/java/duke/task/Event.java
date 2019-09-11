package duke.task;

import duke.DukeException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to represent the Event tasks.
 */
public class Event extends Task {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    private final SimpleDateFormat sdfTime = new SimpleDateFormat("HHmm");
    private String weekly;
    private Date weeklyStartTime;
    private Date weeklyEndTime;
    private Date dateAndStartTime;
    private Date dateAndEndTime;
    private boolean isEveryWeek;

    /**
     * Constructs a new Event task.
     * @param job the Event task to be added to the task list.
     * @param startTime the date and start time of the event.
     * @param endTime the end time of the event.
     * @throws DukeException if the description or the date and time of the event is empty.
     */
    public Event(String job, String startTime, String endTime) throws DukeException {
        super(job);
        checkFormat(startTime, endTime);
        changeType("Event");
    }

    @Override
    public void snooze(String newStartTime, String newEndTime) throws DukeException {
        checkFormat(newStartTime, newEndTime);
    }

    private void checkFormat(String startTime, String endTime) throws DukeException {
        try {
            String[] splitBy = startTime.split(" ");
            if (job.equals("")) {
                throw new DukeException("The description of an event cannot be empty! Please try again.");
            } else if (startTime.equals("") || endTime.equals("")) {
                throw new DukeException("The date/time of an event cannot be empty! Please try again.");
            } else if (splitBy[0].equals("every")) {
                isEveryWeek = true;
                StringBuilder output = new StringBuilder();
                for (int i = 1; i < splitBy.length - 1; i++) {
                    if (i != 1) {
                        output.append(" ");
                    }
                    output.append(splitBy[i]);
                    if (i == splitBy.length - 2) {
                        this.weeklyStartTime = sdfTime.parse(splitBy[splitBy.length - 1]);
                        break;
                    }
                }
                this.weekly = output.toString();
                this.weeklyEndTime = sdfTime.parse(endTime);
            } else {
                this.dateAndStartTime = sdf.parse(startTime);
                this.dateAndEndTime = sdfTime.parse(endTime);
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
        if (!isEveryWeek) {
            return String.format("E | %d | %s | %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job,
                    sdf.format(dateAndStartTime), sdfTime.format(dateAndEndTime));
        } else {
            return String.format("E | %d | %s | every %s %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job,
                    this.weekly, sdfTime.format(weeklyStartTime), sdfTime.format(weeklyEndTime));
        }
    }

    @Override
    public String toString() {
        if (!isEveryWeek) {
            return String.format("[E]%s (at: %s to %s)", super.toString(), sdf.format(dateAndStartTime),
                    sdfTime.format(dateAndEndTime));
        } else {
            return String.format("[E]%s (at: every %s %s to %s)", super.toString(), weekly,
                    sdfTime.format(weeklyStartTime), sdfTime.format(weeklyEndTime));
        }
    }
}
