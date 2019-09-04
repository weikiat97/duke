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
        switch (command) {
        case "bye":
            return new ExitCommand();
        case "done":
            int taskNumber = Integer.valueOf(myArray[1]);
            return new DoneCommand(taskNumber);
        case "list":
            return new ListCommand();
        case "delete":
            try {
                int taskNumber2 = Integer.valueOf(myArray[1]);
                return new DeleteCommand(taskNumber2);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("The task to delete must not be empty! Try again!");
            }
        case "event":
            int cutoff = 0;
            StringBuilder task = new StringBuilder();
            StringBuilder startTime = new StringBuilder();
            String endTime = "";
            for (int j = 1; j < myArray.length; j++) {
                if (myArray[j].charAt(0) == '/') {
                    cutoff = j;
                    break;
                } else {
                    if (j != 1) {
                        task.append(" ");
                    }
                    task.append(myArray[j]);
                    cutoff = j;
                }
            }
            for (int k = cutoff + 1; k < myArray.length; k++) {
                if (myArray[k].equals("to")) {
                    endTime += myArray[k + 1];
                    break;
                } else if (k != cutoff + 1) {
                    startTime.append(" ");
                }
                    startTime.append(myArray[k]);
            }
            return new AddCommand(new Event(task.toString(), startTime.toString(), endTime));
        case "deadline":
            int cutoff2 = 0;
            StringBuilder task2 = new StringBuilder();
            StringBuilder time2 = new StringBuilder();
            for (int j = 1; j < myArray.length; j++) {
                if (myArray[j].charAt(0) == '/') {
                    cutoff2 = j;
                    break;
                } else {
                    if (j != 1) {
                        task2.append(" ");
                    }
                    task2.append(myArray[j]);
                    cutoff2 = j;
                }
            }
            for (int k = cutoff2 + 1; k < myArray.length; k++) {
                if (k != cutoff2 + 1) {
                    time2.append(" ");
                }
                time2.append(myArray[k]);
            }
            return new AddCommand(new Deadline(task2.toString(), time2.toString()));
        case "todo":
            StringBuilder task3 = new StringBuilder();
            for (int j = 1; j < myArray.length; j++) {
                if (j != 1) {
                    task3.append(" ");
                }
                task3.append(myArray[j]);
            }

            return new AddCommand(new ToDo(task3.toString()));
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
}
