# Bunnie - User Guide

Bunnie is a personal chatbot that will help to keep track of the user's todo, event and deadline tasks.
When users enter their commands, the tasks will be automatically saved in a txt file immediately, hence saving users the trouble of having to manually save and insert the tasks.

## Features 
- Simple to use.
- Supports todo, event and deadline tasks.
- Supports finding, postponing and adding recurring tasks.
- Supports auto-saving after each command.

## Commands

### Hello
Shows the welcome message with all the commands that users can use.

Format: 'hello'

---------------

### Todo
Allows user to add todo tasks into the task list. Bunnie will send a confirmation if the task is successfully added, or show an error with the correct formatting if it is not.

Format: 'todo [description]'
Example: 'todo buy dinner'

---------------

### Deadline
Allows user to add deadline tasks into the task list. Bunnie will send a confirmation if the task is successfully added, or show an error with the correct formatting if it is not.

Format 1: 'deadline [description] /by [dd/MM/yyyy HHmm]'
Format 2: 'deadline [description] /by every [recurring day]'

Example 1: deadline CS2100 Assignment /by 20/09/2019 2359
Example 2: deadline GES Assignment /by every Tuesday evening

Users are able to input either a one-time deadline or a recurring deadline as shown above. 
Time must be inputed in the dd/MM/yyyy HHmm format, or an error will be thrown to the user.

---------------

### Event
Allows user to add event tasks into the task list. Bunnie will send a confirmation if the task is successfully added, or show an error with the correct formatting if it is not.

Format 1: 'event [description] /at [dd/MM/yyyy HHmm] to [HHmm]'
Format 2: 'event [description] /at every [recurring day]'

Example 1: event CFG Workshop /at 16/09/2019 1800 to 2000
Example 2: event Football Training /at every Tuesday evening

Users are able to input either a one-time deadline or a recurring deadline as shown above. 
Time must be inputed in the dd/MM/yyyy HHmm format, or an error will be thrown to the user.

---------------

### List
Allows user to see all the tasks in the task list, and whether the tasks are done. If there is no task in the task list, Bunnie will prompt a message to let the user know as well.

Format: 'list'

---------------

### Delete
Allows user to delete any of the tasks in the task list.

Format: 'delete [integer]'
Example: 'delete 4'

Bunnie will delete the corresponding task on the task list. The integer that is inputted must be from 1 to [size of the task list]. If an invalid integer (out of the given range), or a non-integer is inputted, an error will be thrown to the user.

---------------

### Done
Allows user to mark any of the tasks in the task list as done.

Format: 'done [integer]'
Example: 'done 4'

Bunnie will mark the corresponding task on the task list as done. The integer that is inputted must be from 1 to [size of the task list]. If an invalid integer (out of the given range), or a non-integer is inputted, an error will be thrown to the user.

---------------

### Find
Allows user to find tasks that have the the keyword that they wish to search for.

Format: 'find [keyword]'
Example: 'find CS2103'

Bunnie will search through all the descriptions of the tasks to search for any matching results. If there is no task with the keyword, Bunnie will prompt a message to let the user know as well.

---------------

### Postpone
Allow user to postpone any of the deadline and event task.

Format (deadline): 'postpone [integer] [dd/MM/yyyy HHmm]'
Format (event): 'postpone [integer] [dd/MM/yyyy HHmm] to [HHmm]'

Bunnie will postpone the tasks that are indicated by the user to the new dates. If a todo task is chosen, Bunnie will prompt a message to let the user know that there are no dates for todo tasks.
Time must be inputed in the dd/MM/yyyy HHmm format, or an error will be thrown to the user.

---------------

### Bye
Bunnie will say goodbye to the user.

Format: 'bye'



