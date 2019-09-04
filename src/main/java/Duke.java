import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class duke to start the programme.
 */
public class Duke extends Application {

    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    /**
     * Duke with empty constructor.
     */

    public Duke() {
        ui = new Ui();
        storage = new Storage("./src/main/java/data/duke.txt");
        try {
            tasks = storage.readFile();
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        return "Duke heard: " + input;
    }

    /**
     * Runs the programme.
     */
    public void run() {
        ui.printWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    @Override
    public void start (Stage start) {}
}

