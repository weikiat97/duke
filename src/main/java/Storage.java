package duke;

import duke.task.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Storage class to deal with loading tasks from the file and saving tasks in the file.
 */
public class Storage {

    private final String path;

    /**
     * Constructor to make a new storage with the txt file.
     * @param path file path to access from.
     */
    public Storage(String path) {
        this.path = path;
        assert this.path != null : "The address path must not be empty!";
    }

    /**
     * Reads the txt file for previously saved list.
     * @return TaskList which has all the task.
     * @throws DukeException if the task type is different from the expected commands.
     */
    public TaskList readFile() throws DukeException, IOException {
        TaskList currentList = new TaskList();
        File f;
        Scanner s;
        try {
            f = new File(path);
            s = new Scanner(f);
            assert f.canRead();
            assert f.canWrite();

            while (s.hasNext()) {
                String[] input = s.nextLine().split(" \\| ");
                assert input.length >= 3 : "Inputs from file has an error!";
                assert Integer.valueOf(input[1]) == 1 ||
                        Integer.valueOf(input[1]) == 0 : "Inputs from file has an error!";
                switch (input[0]) {
                case "T":
                    ToDo toDo = new ToDo(input[2]);
                    markIfDone(toDo, input[1]);
                    currentList.add(toDo);
                    break;
                case "D":
                    Deadline deadline = new Deadline(input[2], input[3]);
                    markIfDone(deadline, input[1]);
                    currentList.add(deadline);
                    break;
                case "E":
                    Event event = new Event(input[2], input[3], input[4]);
                    markIfDone(event, input[1]);
                    currentList.add(event);
                    break;
                default:
                    throw new DukeException("Error reading task type.");
                }
            }
            return currentList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Making new list now.");
            f = new File(path);
            f.createNewFile();
            return currentList;
        }
    }

    /**
     * Checks if the task from the txt file is completed or not. Marks as done if they are.
     * @param task Task to check if it is done.
     * @param input Input 0 means undone, input 1 means done.
     */
    private void markIfDone(Task task, String input) {
        if (Integer.parseInt(input) == 1) {
            task.isDone();
        }
    }

    /**
     * Writes new items to the txt file and saves it.
     * @param list TaskList to write each task into the txt file.
     * @throws IOException if there is an error with input or output.
     */
    public void writeFile(TaskList list) throws IOException {
        try {
            FileWriter fw = new FileWriter(path);
            for (int i = 0; i < list.size(); i++) {
                fw.write(list.get(i).outputToFile() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
