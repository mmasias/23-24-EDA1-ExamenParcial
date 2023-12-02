public class Blackboard {
    private String message;

    public Blackboard() {
        this.message = "";
    }

    public void writeMessage(String message) {
        this.message = message;
    }

    public String readMessage() {
        return this.message;
    }

    public void clear() {
        this.message = "";
    }

    public boolean isClean() {
        return message.length() <= 0;
    }
}
