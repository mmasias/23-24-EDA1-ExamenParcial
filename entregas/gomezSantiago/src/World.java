import java.util.Scanner;

public class World {
    private Playground playroom;
    private int totalMinutes;

    public World(Playground playroom, int openingTime) {
        this.playroom = playroom;
        this.totalMinutes = openingTime;
    }

    public void startSimulation() {
        for (int currentMinute = 0; currentMinute < totalMinutes; currentMinute++) {
            System.out.println("-".repeat(50));
            System.out.println("Minuto " + currentMinute);
            if (childArrives()) {
                Child child = generateChild();
                playroom.welcomeChild(child);
            }
            playroom.updatePlayroom();
            playroom.showCurrentState();
            new Scanner(System.in).nextLine();
        }
    }

    private boolean childArrives() {
        return Math.random() > 0.5;
    }

    private Child generateChild() {
        String name = inventName();
        System.out.println("Llegó: " + name);
        return new Child(name);
    }

    private String inventName() {
        String[] names = {
                "Sofía", "Mateo", "Valentina", "Sebastián", "Isabella", "Dylan", "Camila", "Matías", "Mia", "Lucas",
                "Emma", "Samuel", "Victoria", "Daniel", "Emilia", "Leonardo", "Sara", "Benjamín", "Martina", "Alexander",
                "Antonella", "Nicholas", "Valeria", "Santiago", "Gabriela", "Juan", "Emily", "Joaquín", "Juliana", "Adrian",
                "Zoe", "Nicolás", "Rene", "Andrés", "Alma", "Lorena", "Alessandra", "Diego", "Lucía", "Javier",
                "María José", "Fernando", "Ana Sofía", "Miguel", "Isabel", "Emiliano", "Olivia", "Eduardo", "Julia"
        };
        return names[(int)(Math.random() * names.length)];
    }


    public static void main(String[] args) {
        Playground playroom = new Playground();
        World theWorld = new World(playroom, 120);
        theWorld.startSimulation();
    }
}
