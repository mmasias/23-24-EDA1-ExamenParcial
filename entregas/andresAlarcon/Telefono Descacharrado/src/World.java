import java.util.Scanner;

class World {
    private Playroom playroom;
    private int totalTime;

    public World(Playroom aPlayroom, int openingTime) {
        playroom = aPlayroom;
        totalTime = openingTime;
    }

    public void startSimulation() {
        for (int currentMinute = 0; currentMinute < totalTime; currentMinute++) {
            System.out.println("=".repeat(30));
            System.out.println("Minute " + currentMinute);
            if (childArrives()) {
                Child child = generateChild();
                playroom.receiveChild(child);
            }
            playroom.update();
            playroom.viewState();
            new Scanner(System.in).nextLine();
        }
    }

    private boolean childArrives() {
        return Math.random() > 0.5;
    }

    private Child generateChild() {
        String aName = inventName();
        System.out.println("Arrives " + aName);
        return new Child(aName);
    }

    private String inventName() {
        String names[] = { "Liam", "Olivia", "Noah", "Emma", "Aiden", "Sophia", "Lucas", "Ava", "Caden", "Isabella", "Elijah", "Mia", "Mason", "Layla", "Logan", "Olivia", "Jackson", "Amelia", "Ethan", "Harper", "Avery", "Benjamin", "Abigail", "Carter", "Ella", "Samuel", "Scarlett", "Leo", "Lily", "Wyatt", "Chloe", "Henry", "Grace", "Jack", "Aria", "Ella", "Zoe", "Alexander", "Lillian", "Owen", "Sofia", "James", "Madison", "Sebastian", "Aubrey", "Isaac", "Charlotte", "Gabriel", "Luna", "Harper" };
        return names[(int)(Math.random() * names.length)];
    }

    public static void main(String[] args) {
        Playroom aPlayroom = new Playroom();
        World theWorld = new World(aPlayroom, 120);
        theWorld.startSimulation();
    }
}