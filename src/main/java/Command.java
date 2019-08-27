public abstract class Command {

    protected boolean exit = false;

    public boolean isExit() {
        return this.exit;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

}
