public class Playground {
    private Monitor lidia;
    private Monitor aisha;
    private Blackboard mainBlackboard;

    public Playground() {
        lidia = new Monitor("Lidia");
        aisha = new Monitor("Aisha");
        mainBlackboard = new Blackboard();
    }

    public void welcomeChild(Child child) {
        lidia.receiveChild(child, new Blackboard());
    }


    public void updatePlayroom() {
        manageQueues();
        if (aisha.canStartGame()) {
            aisha.startGame();
        }
    }

    private void manageQueues() {
        if (lidia.hasChildren() && !aisha.isGaming()) {
            lidia.transferChildren(aisha);
        }
    }

    public void showCurrentState() {
        lidia.displayChildList();
        aisha.displayChildList();
    }
}