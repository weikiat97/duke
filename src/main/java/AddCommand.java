import java.io.IOException;

public class AddCommand extends Command {

    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.add(task);
            ui.printAddEventMessage(task);
            ui.printNumberOfTasksMessage(tasks);
            storage.writeFile(tasks);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }
}
