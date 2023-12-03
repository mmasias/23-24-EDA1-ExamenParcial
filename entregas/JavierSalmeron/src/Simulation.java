import java.util.Random;
import java.util.Scanner;

public class Simulation {
    Classroom classroom;

    public Simulation(Classroom classroom) {
        this.classroom = classroom;
    }

    public void runSimulation() {
        Teacher Lydia = new Teacher("Lydia");
        Teacher Aisha = new Teacher("Aisha");
        classroom.addTeacher(Lydia);
        classroom.addTeacher(Aisha);

        while (!classroom.isClosed()) {
            System.out.println("[Info] Current Time: " + classroom.getTime() + "\n");

            if (classroom.getTime() < 10) {
                int kidsArriving = new Random().nextInt(3);
                for (int i = 0; i < kidsArriving; i++) {
                    Kid newKid = new Kid(Name.getRandomKidName(), classroom);
                    classroom.addKid(newKid);
                    Lydia.addToQueue(newKid);
                }
            } else if (classroom.getTime() < 30 && classroom.getTime() % 3 == 0) {
                if (new Random().nextDouble() < 0.5) {
                    Kid newKid = new Kid(Name.getRandomKidName(), classroom);
                    classroom.addKid(newKid);
                    Lydia.addToQueue(newKid);
                }
            }

            while (!Lydia.queue().isEmpty() && !Aisha.isGameRunning()) {
                Kid kid = Lydia.queue().getFirst().getData();
                System.out.println("[INFO] " + kid.getName() + " is moved from Lydia to Aisha.");
                Lydia.queue().remove(0);
                Aisha.queue().insert(kid, -1);
            }

            Aisha.playGame(Aisha.queue());

            classroom.timeAdvance();
            new Scanner(System.in).nextLine();
        }

        System.out.println(" ---> Classroom is now closed. <---");
    }
}
