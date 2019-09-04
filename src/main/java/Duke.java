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
        ui.printWelcomeMessage();
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
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            return "Unknown command! Please try again.";
        }
    }

    @Override
    public void start (Stage start) {}
}

