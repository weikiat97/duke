package duke;

import duke.command.Command;
import duke.command.ExitCommand;
import duke.command.DoneCommand;
import duke.command.ListCommand;
import duke.command.DeleteCommand;
import duke.command.AddCommand;
import duke.command.FindCommand;
import duke.task.Event;
import duke.task.Deadline;
import duke.task.ToDo;
import java.util.ArrayList;


/**
 * Class to parse the input by the user into a command.
 */
public class Parser {

    /**
     * Takes in the full string and processes the string into a command.
     * @param fullCommand input by the user.
     * @return Command to be executed later.
     * @throws DukeException if the command is unknown.
     */
    public static Command parse(String fullCommand) throws DukeException {
        String[] myArray = fullCommand.split(" ");
        String command = myArray[0];
        ArrayList<String> returnCommand;
        switch (command) {
        case "bye":
            return new ExitCommand();
        case "done":
            int taskNumber = Integer.parseInt(myArray[1]);
            return new DoneCommand(taskNumber);
        case "list":
            return new ListCommand();
        case "delete":
            int taskNumber2 = Integer.parseInt(myArray[1]);
            return new DeleteCommand(taskNumber2);
        case "event":
            returnCommand = getTask(myArray, "/at", false);
            return new AddCommand(new Event(returnCommand.get(0), returnCommand.get(1), returnCommand.get(2)));
        case "deadline":
            returnCommand = getTask(myArray, "/by", false );
            return new AddCommand(new Deadline(returnCommand.get(0), returnCommand.get(1)));
        case "todo":
            returnCommand = getTask(myArray, "any word", true);
            return new AddCommand(new ToDo(returnCommand.get(0)));
        case "find":
            try {
                String keyword = myArray[1];
                return new FindCommand(keyword);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("The keyword must not be empty! Try again!");
            }
        default:
            throw new DukeException("Invalid command! Please use one of the following commands:\n" +
                    "list, delete, find, todo, deadline, event, bye");
        }
    }

    /**
     * Handles the parsing for tasks.
     * @param inputCommand commands from the user in String[] format.
     * @param stopAt either '/at' or '/by' depending on which event.
     * @return an array list of the instructions in task, start time, end time format.
     */
    private static ArrayList<String> getTask(String[] inputCommand, String stopAt, boolean isToDo) {
        ArrayList<String> returnCommand = new ArrayList<String>();
        StringBuilder task = new StringBuilder();
        StringBuilder startTime = new StringBuilder();
        StringBuilder endTime = new StringBuilder();
        int cutoff = 0;
        for (int j = 1; j < inputCommand.length; j++) {
            if (!isToDo && inputCommand[j].equals(stopAt)) {
                cutoff = j;
                break;
            } else {
                if (j != 1) {
                    task.append(" ");
                }
                task.append(inputCommand[j]);
                cutoff = j;
            }
        }
        for (int k = cutoff + 1; k < inputCommand.length; k++) {
            if (inputCommand[k].equals("to")) {
                endTime.append(inputCommand[k + 1]);
                break;
            } else if (k != cutoff + 1) {
                startTime.append(" ");
            }
            startTime.append(inputCommand[k]);
        }
        returnCommand.add(task.toString());
        returnCommand.add(startTime.toString());
        returnCommand.add(endTime.toString());
        return returnCommand;
    }
}
