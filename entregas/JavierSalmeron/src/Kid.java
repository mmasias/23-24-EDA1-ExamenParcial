import java.util.Random;

public class Kid {
    private Classroom classroom;
    private String name;
    private Blackboard blackboard;
    private boolean onQueue;

    public Kid(String name, Classroom classroom) {
        this.classroom = classroom;
        this.name = name;
        this.blackboard = new Blackboard();
        this.onQueue = false;
    }

    public String getName() {
        return this.name;
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }

    public void copyFromBlackboard(Blackboard source) {
        classroom.timeAdvance();
        String sourceMessage = source.read();
        StringBuilder copiedMessage = new StringBuilder();
        Random random = new Random();

        for (char c : sourceMessage.toCharArray()) {
            if (random.nextDouble() < 0.05) {
                copiedMessage.append((char) ('a' + random.nextInt(26)));
            } else {
                copiedMessage.append(c);
            }
        }
        blackboard.write(copiedMessage.toString());
    }

    public void playGame(Teacher aisha, Kid previousKid) {
        if (previousKid == null) {
            this.copyFromBlackboard(aisha.getBlackboard());
            System.out.println("[GAME] " + this.name + " copied the word '" + this.blackboard.read() + "' from Aisha");
        } else {
            this.copyFromBlackboard(previousKid.getBlackboard());
            System.out.println("[GAME] " + this.name + " copied the word '" + this.blackboard.read() + "' from " + previousKid.getName());
        }
        classroom.timeAdvance();
    }

    public boolean isOnQueue() {
        return onQueue;
    }

    public void setOnQueue(boolean onQueue) {
        this.onQueue = onQueue;
    }
}
