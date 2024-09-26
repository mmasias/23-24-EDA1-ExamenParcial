public class Blackboard {
    private String message;

    public Blackboard() {
        this.message = "";
    }

    public void write(String message) {
        this.message = message;
    }

    public String read() {
        return message;
    }

}
