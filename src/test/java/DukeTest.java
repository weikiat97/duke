package duke;

import duke.command.Command;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.ToDo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {

    @Test
    public void testToDo() throws DukeException {
        ToDo todo = new ToDo("CS2103 Tutorial");
        assertEquals("[T][✗] CS2103 Tutorial", todo.toString());
    }

    @Test
    public void testDeadline() throws DukeException {
        Deadline deadline = new Deadline("CS2103 TP Submission", "05/09/2019 2359");
        assertEquals("[D][✗] CS2103 TP Submission (by: 05/09/2019 2359)", deadline.toString());
    }

    @Test
    public void testEvent() throws DukeException {
        Event event = new Event("CS2103 Examination", "05/09/2019 1800", "2000");
        assertEquals("[E][✗] CS2103 Examination (at: 05/09/2019 1800 to 2000)", event.toString());
    }

    @Test
    public void testEmptyEvent() {
        try {
            Event event = new Event("", "", "");
        } catch (DukeException e) {
            assertEquals("Error in format! Event must be written in \"(event name) "
                    + "/at dd/MM/yyyy HHmm to HHmm\" format", e.getMessage());
        }
    }

    @Test
    public void testUnkonwnParser() {
        try {
            Command c = Parser.parse("hello");
        } catch (DukeException e) {
            assertEquals("Invalid command! Please use one of the following commands:\n"
                    + "list, delete, find, todo, deadline, event, bye", e.getMessage());
        }
    }



}

