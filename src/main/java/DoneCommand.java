import java.io.IOException;

public class DoneCommand extends Command {

    private int taskNumber;

    public DoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task currentTask = tasks.get(taskNumber - 1);
            currentTask.isDone();
            ui.printDoneTaskMessage(currentTask);
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }
}
