public class Teacher {
    private String name;
    private Blackboard blackboard;
    private List<Kid> queue = new List<>();
    private int gameSize = 5;
    private String playWord = "the quick brown fox jumps over the lazy dog";
    private boolean isGameRunning = false;

    public Teacher(String name) {
        this.name = name;
        this.blackboard = new Blackboard();
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }

    public void writeOnBlackboard(String message) {
        blackboard.write(message);
    }

    public void addToQueue(Kid kid) {
        queue.insert(kid, -1);
        kid.setOnQueue(true);
        System.out.println("[INFO] " + name + " has added " + kid.getName() + " to the queue.");
    }

    public void playGame(List<Kid> aishaPlayground) {
        if (aishaPlayground.size() >= gameSize && !isGameRunning) {
            isGameRunning = true;
            System.out.println("[INFO] " + name + " is starting a game with " + aishaPlayground.size() + " kids:");
            this.blackboard.write(playWord);

            Kid previousKid = null;
            for (Kid kid : aishaPlayground) {
                kid.playGame(this, previousKid);
                previousKid = kid;
            }

            System.out.println("[INFO] " + name + " has ended the game.\n");
            isGameRunning = false;
        } else if (isGameRunning) {
            System.out.println("[INFO] A game is currently running. Waiting for the next round.");
        } else {
            System.out.println("[INFO] Not enough kids to start.");
        }
    }

    public List<Kid> queue() {
        return queue;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }
}
