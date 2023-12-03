public class Playroom {
    private Monitor lydia;
    private Monitor aisha;
    private Blackboard classroomBoard;

    public Playroom() {
        lydia = new Monitor("Lydia");
        aisha = new Monitor("Aisha");
        classroomBoard = new Blackboard();
    }

    public void receiveChild(Child child) {
        lydia.receiveChild(child);
    }

    public void update() {
        manageQueues();
        if (aisha.canPlay()) {
            aisha.play();
        }
    }

    private void manageQueues() {
        if (lydia.hasChildren() && !aisha.isPlaying()) {
            lydia.deliverChildren(aisha);
        }
    }

    public void viewState() {
        lydia.showChildrenList();
        aisha.showChildrenList();
    }
}