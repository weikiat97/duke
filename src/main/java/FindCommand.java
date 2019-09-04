import java.io.IOException;

/**
 * Class to represent find command.
 */
public class FindCommand extends Command {

    private final String keyword;

    /**
     * Constructor to find keyword.
     * @param keyword keyword to find.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command.
     * @param tasks TaskList of all the current tasks.
     * @param storage Storage to save tasks in the file after execution.
     */
    public String execute(TaskList tasks, Storage storage) {
        try {
            int counter = 1;
            String findMessage = "Here are the matching tasks in your list:";
            for (int i = 0; i < tasks.size(); i++) {
                Task currentTask = tasks.get(i);
                String currentJob = currentTask.getJob();
                String[] findingKeyword = currentJob.split(" ");
                for (String s : findingKeyword) {
                    if (s.equals(keyword)) {
                        findMessage += "\n     " + counter + "." + currentTask;
                        counter++;
                        break;
                    }
                }
            }
            storage.writeFile(tasks);
            return findMessage;
        } catch (IOException e) {
            return "Error writing tasks to file!";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error! Index must be between 1 and " + tasks.size() + "!";
        }
    }
}
