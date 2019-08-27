public class Parser {

    public static Command parse(String fullCommand) throws DukeException {
        String myArray[] = fullCommand.split(" ");
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
            int taskNumber2 = Integer.valueOf(myArray[1]);
            return new DeleteCommand(taskNumber2);
        case "event":
            int cutoff = 0;
            String task = "";
            String time = "";
            for (int j = 1; j < myArray.length; j++) {
                if (myArray[j].charAt(0) == '/') {
                    cutoff = j;
                    break;
                } else {
                    if (j != 1) {
                        task += " ";
                    }
                    task += myArray[j];
                    cutoff = j;
                }
            }
            for (int k = cutoff + 1; k < myArray.length; k++) {
                if (k != cutoff + 1) {
                    time += " ";
                }
                time += myArray[k];
            }
            return new AddCommand(new Event(task, time));
        case "deadline":
            int cutoff2 = 0;
            String task2 = "";
            String time2 = "";
            for (int j = 1; j < myArray.length; j++) {
                if (myArray[j].charAt(0) == '/') {
                    cutoff2 = j;
                    break;
                } else {
                    if (j != 1) {
                        task2 += " ";
                    }
                    task2 += myArray[j];
                    cutoff2 = j;
                }
            }
            for (int k = cutoff2 + 1; k < myArray.length; k++) {
                if (k != cutoff2 + 1) {
                    time2 += " ";
                }
                time2 += myArray[k];
            }
            return new AddCommand(new Deadline(task2, time2));
        case "todo":
            String task3 = "";
            for (int j = 1; j < myArray.length; j++) {
                if (j != 1) {
                    task3 += " ";
                }
                task3 += myArray[j];
            }
            return new AddCommand(new ToDo(task3));
        default:
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
