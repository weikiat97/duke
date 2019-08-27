/**
 * Class to represent the ToDo tasks.
 */
public class ToDo extends Task {

    /**
     * Constructs a new ToDo task.
     * @param job the ToDo to be added to the task list.
     * @throws DukeException if the description of the ToDo task is empty.
     */
    public ToDo(String job) throws DukeException {
        super(job);
        String check = job;
        if (job.equals("")) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    /**
     * Formats the ToDo task to be added to the txt file.
     * @return String to be added to the txt file.
     */
    @Override
    public String outputToFile() {
        return String.format("T | %d | %s", this.status.equals("[✓]") ? 1 : 0, this.job);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
