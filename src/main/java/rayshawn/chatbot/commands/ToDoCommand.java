package rayshawn.chatbot.commands;

import rayshawn.chatbot.exceptions.ChatBotException;
import rayshawn.chatbot.tasks.Task;
import rayshawn.chatbot.tasks.ToDo;

/**
 * Adds a todo task to the tasklist.
 */
public class ToDoCommand extends Command {
    // Adapted from
    // https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/commands/AddCommand.java
    public static final String COMMAND_WORD = "todo";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a ToDo task to the task list.\n"
            + "Parameters: Description\n"
            + "Example: " + COMMAND_WORD + " homework";
    private static final String MESSAGE_SUCCESS = "Got it. I've added this task: \n %1$s \n";

    public final Task toAdd;

    /**
     * Constructor for ToDoCommand.
     *
     * @param description description of the task
     * @throws ChatBotException if the data is invalid
     */
    public ToDoCommand(String description) throws ChatBotException {
        this.toAdd = new ToDo(description);
    }

    @Override
    public CommandResult execute() {
        assert taskList != null : "Task list should not be null";

        taskList.addTask(toAdd);

        return new CommandResult(String.format(MESSAGE_SUCCESS + getTaskListCount(taskList.getAllTasks()),
                toAdd, taskList.getAllTasks()));
    }
}
