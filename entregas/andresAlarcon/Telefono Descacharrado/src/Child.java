import java.util.Random;

class Child {
    private String name;
    private Blackboard board;

    public Child(String name) {
        this.name = name;
    }

    public void receiveBoard(Blackboard classroom) {
        this.board = classroom;
    }

    public String getName() {
        return name;
    }

    public void receiveMessage(String message) {
        board.writeMessage(modifyMessage(message));
        System.out.println("[" + name + "] receives [" + message + "] and has written [" + board.readMessage() + "]");
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

    public String displayMessage() {
        return board.readMessage();
    }

    public void clearBoard() {
        board.clear();
    }
}