public class ToDo extends Task {

    public ToDo(String job) throws DukeException {
        super(job);
        if (job.equals("")) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    @Override
    public String outputToFile() {
        return String.format("T | %d | %s", this.status.equals("[✓]") ? 1 : 0, this.job);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}
