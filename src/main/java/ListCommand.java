/**
 * Class that represents the list command.
 */
public class ListCommand extends Command {

    /**
     * Empty constructor.
     */
    public ListCommand() {
    }

    /**
     * Executes the list command.
     * @param tasks TaskList of all the current tasks.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        StringBuilder output = new StringBuilder("");
        for (int i = 1; i < tasks.size() + 1; i++) {
            output.append(i + "." + tasks.get(i - 1));
            if (i != tasks.size()) {
                output.append("\n");
            }
        }
        return output.toString();
    }
}
