package duke;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/CuteKid.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/Bunnie.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setDuke(Duke d) {
        duke = d;
        printWelcomeMessage();
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
        if (input.equals("bye")) {
            Timer timer = new Timer();
            TimerTask exitGui = new TimerTask() {
                public void run() {
                    System.exit(0);
                }
            };
            timer.schedule(exitGui, 1000);
        }
    }

    private void printWelcomeMessage() {
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog("Welcome! I am Bunnie, your personal assistant!\n"
                        + "You can use the following commands to help you add tasks to your tasklist:\n"
                        + "hello, list, delete, find, done, todo, deadline, event, postpone, bye\n"
                        + "Data will be stored in bunnie.txt file in the same folder! ^.^", dukeImage)
        );
    }
}