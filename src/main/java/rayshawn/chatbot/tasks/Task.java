package rayshawn.chatbot.tasks;

public class Task {
    private String description;
    private String type;
    private boolean done = false;

    public Task(String description, String type) {
        this.description = description;
        this.type = type;
    }

    public boolean checkDone() {
        return this.done;
    }
    public void markDone() {
            this.done = true;
    }

    public void unmarkDone() {
        this.done = false;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return String.format("[%s][%s] %s",this.type , done ? "X" : " ", this.description);
    }

}