import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Storage {

    private String path;
    private File f;
    private Scanner s;

    public Storage(String path) {
        this.path = path;
    }

    public ArrayList<Task> readFile() throws DukeException {
        ArrayList<Task> currentList = new ArrayList<Task>();
        try {
            System.out.println(path);
            f = new File(path);
            s = new Scanner(f);
            while (s.hasNext()) {
                String[] input = s.nextLine().split(" \\| ");
                switch (input[0]) {
                case "T":
                    ToDo toDo = new ToDo(input[2]);
                    if (Integer.valueOf(input[1]) == 1) {
                        toDo.isDone();
                    }
                    currentList.add(toDo);
                    break;
                case "D":
                    Deadline deadline = new Deadline(input[2], input[3]);
                    if (Integer.valueOf(input[1]) == 1) {
                        deadline.isDone();
                    }
                    currentList.add(deadline);
                    break;
                case "E":
                    Event event = new Event(input[2], input[3]);
                    if (Integer.valueOf(input[1]) == 1) {
                        event.isDone();
                    }
                    currentList.add(event);
                    break;
                default:
                    throw new DukeException("Error reading task type.");
                }
            }
            return currentList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Making new list now.");
            return currentList;
        }
    }

    public void writeFile(ArrayList<Task> list) throws IOException {
        try {
            FileWriter fw = new FileWriter(path);
            for (Task task : list) {
                fw.write(task.outputToFile() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
