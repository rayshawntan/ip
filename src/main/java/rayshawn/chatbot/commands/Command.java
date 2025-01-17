package rayshawn.chatbot.commands;

import static rayshawn.chatbot.messages.Messages.LIST_COUNT_MESSAGE;

import java.util.List;

import rayshawn.chatbot.tasks.Task;
import rayshawn.chatbot.tasks.TaskList;

/**
 * Represents an executable command.
 */
public class Command {
    // Adapted from https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/commands/Command.java
    protected TaskList taskList;
    private int targetIndex = -1;

    /**
     * Constructor for Command.
     *
     * @param targetIndex takes in a target task index
     */
    public Command(int targetIndex) {
        assert targetIndex >= 0 : "Target index should be non-negative";
        this.setTargetIndex(targetIndex);
    }

    /**
     * Empty Constructor
     */
    protected Command() {
    }

    /**
     * Executes the command and returns the result.
     *
     * @return the result of the command
     */
    public CommandResult execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

    public void setTaskList(TaskList taskList) {
        assert taskList != null : "Task list should not be null";
        this.taskList = taskList;
    }

    protected Task getTask(int index) {
        return taskList.getTask(index);
    }

    public void setTargetIndex(int targetIndex) {
        this.targetIndex = targetIndex;
    }

    /**
     * Retrieve the index of the target task.
     *
     * @return index of target task
     */
    public int getIndex() {
        return targetIndex;
    }

    /**
     * Get the number of tasks present in the tasklist and output it as a String.
     *
     * @return String representation of the number of tasks
     */
    public String getTaskListCount(List<? extends Task> list) {
        return String.format(LIST_COUNT_MESSAGE, list.size());
    }
}
