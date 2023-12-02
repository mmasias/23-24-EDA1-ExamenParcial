public class Monitor {
    private String name;
    private Queue childQueue;
    private boolean isPlaying;
    Node<Child> currentChild;

    public Monitor(String name) {
        this.name = name;
        this.childQueue = new Queue();
        isPlaying = false;
    }

    public void receiveChild(Child child, Blackboard blackboard) {
        enqueueChild(child);
        child.receiveChalkboard(blackboard);
    }


    public boolean hasChildren() {
        return childQueue.hasChildren();
    }

    public boolean canStartGame() {
        return childQueue.size() >= 5;
    }

    public boolean isGaming() {
        return isPlaying;
    }

    public void displayChildList() {
        System.out.print("| " + this.name + " |--| ");
        childQueue.listChildren();
        System.out.println();
    }

    public void startGame() {
        if (!isPlaying) {
            isPlaying = true;
            clearChalkboards();
            currentChild = childQueue.getChildren().getHead();
            currentChild.getElement().receiveMessage("ABCDEFGHIJKLM");
        } else {
            progressGame();
        }
    }

    private void progressGame() {
        Node<Child> child = childQueue.getChildren().getHead();
        while (child != currentChild) {
            child = child.getNextNode();
        }
        if (child.getNextNode() == null) {
            isPlaying = false;
            currentChild = childQueue.getChildren().getHead();
        } else {
            Child currentChildObject = child.getElement();
            Child nextChildObject = child.getNextNode().getElement();
            nextChildObject.receiveMessage(currentChildObject.showMessage());
            currentChild = child.getNextNode();
        }
    }

    public void transferChildren(Monitor anotherMonitor) {
        while (childQueue.hasChildren()) {
            System.out.println(" *  " + this.name + " pasa un niño");
            Child aChild = childQueue.dequeueChild();
            anotherMonitor.receiveChild(aChild, new Blackboard());
        }
    }


    private void clearChalkboards() {
        Node<Child> child = childQueue.getChildren().getHead();
        while (child != null) {
            child.getElement().clearChalkboard();
            child = child.getNextNode();
        }
    }

    private void enqueueChild(Child child) {
        childQueue.enqueueChild(child);
    }
}
