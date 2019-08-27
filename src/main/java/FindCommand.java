import java.io.IOException;

/**
 * Class to represent find command.
 */
public class FindCommand extends Command {

    private String keyword;

    /**
     * Constructor to find keyword.
     * @param keyword keyword to find.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            int counter = 1;
            ui.printFindMessage();
            for (int i = 0; i < tasks.size(); i++) {
                Task currentTask = tasks.get(i);
                String currentJob = currentTask.getJob();
                String[] findingKeyword = currentJob.split(" ");
                for (int j = 0; j < findingKeyword.length; j++) {
                    if (findingKeyword[j].equals(keyword)) {
                        ui.printFoundMessage(counter, currentTask);
                        counter++;
                        break;
                    }
                }
            }
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }
}
