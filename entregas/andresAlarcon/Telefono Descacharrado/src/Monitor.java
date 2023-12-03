import java.util.Random;

public class Monitor {
    private String name;
    private Queue childrenQueue;
    private boolean isPlaying;
    Node<Child> currentChild;

    private static final String[] RANDOM_WORDS = {
        "apple", "banana", "orange", "elephant", "computer",
        "giraffe", "sunflower", "mountain", "ocean", "rainbow",
        "zebra", "television", "umbrella", "xylophone", "dragon",
        "firefly", "jupiter", "kangaroo", "quasar", "butterfly",
        "paradox", "waterfall", "monolith", "whisper", "festival",
        "velvet", "harmony", "octopus", "jazz", "meteor",
        "nebula", "quokka", "rhapsody", "cascade", "labyrinth",
        "serendipity", "whimsical", "infinity", "ethereal", "surreal",
        "majestic", "benevolent", "captivating", "enigmatic", "effervescent",
        "serenity", "tranquil", "euphoria", "cynosure", "resplendent"
    };

    public Monitor(String name) {
        this.name = name;
        this.childrenQueue = new Queue();
        isPlaying = false;
    }

    public void receiveChild(Child child) {
        childrenQueue.addChild(child);
    }

    public boolean hasChildren() {
        return childrenQueue.hasChildren();
    }

    public boolean canPlay() {
        return childrenQueue.size() >= 5;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void showChildrenList() {
        System.out.print("> " + this.name + " --> ");
        childrenQueue.listChildren();
        System.out.println();
    }

    private void receiveChild(Child child, Blackboard board) {
        child.receiveBoard(board);
        childrenQueue.addChild(child);
    }

    public void deliverChildren(Monitor anotherMonitor) {
        while (childrenQueue.hasChildren()) {
            System.out.println(" >  " + this.name + " DELIVERS CHILD");
            Child aChild = childrenQueue.removeChild();
            anotherMonitor.receiveChild(aChild, new Blackboard());
        }
    }

    private void clearBoards() {
        Node<Child> child = childrenQueue.getChildren().getFirst();
        while (child != null) {
            child.getData().clearBoard();
            child = child.getNext();
        }
    }

    private String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(RANDOM_WORDS.length);
        return RANDOM_WORDS[index];
    }

    public void play() {
        if (!isPlaying) {
            isPlaying = true;
            clearBoards();
            currentChild = childrenQueue.getChildren().getFirst();
            currentChild.getData().receiveMessage(getRandomWord());
        } else {
            Node<Child> child = childrenQueue.getChildren().getFirst();
            while (child != currentChild) {
                child = child.getNext();
            }
            if (child.getNext() == null) {
                isPlaying = false;
                currentChild = childrenQueue.getChildren().getFirst();
            } else {
                Child currentChild = child.getData();
                Child nextChild = child.getNext().getData();
                nextChild.receiveMessage(getRandomWord());
                this.currentChild = child.getNext();
            }
        }
    }
}
