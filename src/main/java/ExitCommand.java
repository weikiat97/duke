public class ExitCommand extends Command {

    public ExitCommand() {
        exit = true;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printByeMessage();
    }
}