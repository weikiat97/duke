import java.io.IOException;

public class DeleteCommand extends Command {

    private int taskNumber;

    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task currentTask = tasks.delete(taskNumber - 1);
            ui.printDeleteTaskMessage(currentTask);
            ui.printNumberOfTasksMessage(tasks);
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }
}