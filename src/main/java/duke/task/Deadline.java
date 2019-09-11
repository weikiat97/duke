package duke.task;

import duke.DukeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to represent the Deadline tasks.
 */
public class Deadline extends Task {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    private Date date;
    private String weekly;
    private boolean isEveryWeek;

    /**
     * Constructs a new Deadline task.
     * @param job the Deadline task to be added to the task list.
     * @param by the time of the deadline.
     * @throws DukeException if there is an error in formatting.
     */
    public Deadline(String job, String by) throws DukeException {
        super(job);
        checkFormat(by);
        changeType("Deadline");
    }

    @Override
    public void snooze(String newBy) throws DukeException {
        checkFormat(newBy);
    }

    private void checkFormat(String by) throws DukeException {
        try {
            String[] splitBy = by.split(" ");
            if (job.equals("")) {
                throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
            } else if (by.equals("")) {
                throw new DukeException("☹ OOPS!!! The date/time of a deadline cannot be empty.");
            } else if (splitBy[0].equals("every")) {
                isEveryWeek = true;
                StringBuilder output = new StringBuilder();
                for (int i = 1; i < splitBy.length; i++) {
                    if (i != 1) {
                        output.append(" ");
                    }
                    output.append(splitBy[i]);
                }
                this.weekly = output.toString();
            } else {
                this.date = sdf.parse(by);
            }
        } catch (ParseException e) {
            if (isEveryWeek) {
                throw new DukeException("Error in format! Recurring deadline must be written in \"(deadline name) " +
                        "/by every (recurring day)\" format");
            } else {
                throw new DukeException("Error in format! Deadline must be written in \"(deadline name) " +
                        "/by dd/MM/yyyy HHmm\" format");
            }
        }
    }

    /**
     * Formats the Deadline task to be added to the txt file.
     * @return String to be added to the txt file.
     */
    @Override
    public String outputToFile() {
        if (!isEveryWeek) {
            return String.format("D | %d | %s | %s", this.status.equals("[✓]") ? 1 : 0, this.job, sdf.format(date));
        } else {
            return String.format("D | %d | %s | every %s", this.status.equals("[✓]") ? 1 : 0, this.job, weekly);
        }
    }

    @Override
    public String toString() {
        if (!isEveryWeek) {
            return String.format("[D]%s (by: every %s)", super.toString(), sdf.format(date));
        } else {
            return String.format("[D]%s (by: every %s)", super.toString(), weekly);
        }
    }
}
