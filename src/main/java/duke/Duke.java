package duke;

import duke.task.TaskList;
import duke.command.Command;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class duke to start the programme.
 */
public class Duke extends Application {

    private final Storage storage;
    private TaskList tasks;

    /**
     * Duke with empty constructor.
     */

    public Duke() {
        storage = new Storage("./bunnie.txt");
        try {
            tasks = storage.readFile();
        } catch (DukeException | IOException e) {
            tasks = new TaskList();
        }
    }

    /**
     * Gets response from the user.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, storage);
        } catch (DukeException e) {
            return e.getMessage();
        }
    }

    @Override
    public void start(Stage start) {

    }
}

