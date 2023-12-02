
import java.util.Random;

public class Child {
    private String name;
    private Blackboard chalkboard;

    public Child(String name) {
        this.name = name;
    }

    public void receiveChalkboard(Blackboard chalkboard) {
        this.chalkboard = chalkboard;
    }

    public String getName() {
        return name;
    }

    public void receiveMessage(String message) {
        chalkboard.writeMessage(modifyMessage(message));
        System.out.println("[" + name + "] recibe [" + message + "] y ha escrito [" + chalkboard.readMessage() + "]");
    }

    private String modifyMessage(String message) {
        Random random = new Random();
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 2; i++) {
            int randomIndex = random.nextInt(message.length());
            char randomLetter = ALPHABET.charAt(random.nextInt(ALPHABET.length()));

            message = message.substring(0, randomIndex) + randomLetter + message.substring(randomIndex + 1);
        }
        return message;
    }

    public String showMessage() {
        return chalkboard.readMessage();
    }

    public void clearChalkboard() {
        chalkboard.clear();
    }
}