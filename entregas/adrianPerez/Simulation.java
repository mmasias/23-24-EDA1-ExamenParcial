import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TimerTask;

public class Simulation {


    int timer = 120;

    List<Kid> queue = new ArrayList<Kid>();

    Kid kid = new Kid();


    public void addKid(Kid kid) {

        boolean disableAdding = false;
        int turns = 0;



        if (disableAdding) {
            turns--;
            return;
        }

        if (turns == 0) {
            disableAdding = false;
        }

        // Add between 0 and 2 kids every 10 minutes
        if (timer > 110 && !disableAdding) {
            double rand = Math.random();
            if (rand < 0.33) {
                queue.add(kid);
                System.out.println("A llegado un niño.");
                disableAdding = true;
            } else if (rand < 0.66) {
                queue.add(kid);
                queue.add(kid);
                System.out.println("Han llegado dos niños.");
                disableAdding = true;
            }
        } 
        else {
            double rand = Math.random();
            if (rand > 0.50) {
                queue.add(kid);
                System.out.println("A llegado un niño.");
            }
        }
    }

    public void queue() {
        if (queue.size() > 4 && !kid.playing) {
            // Remove 5 kids
            for (int i = 0; i < 5; i++) {
                queue.remove(0);
                kid.playing = true;
            }
            System.out.println("Empiezan a jugar!");
        }
        else {
            addKid(new Kid());
        }
    }


    public void simulation() {
        System.out.println("Abre la ludoteca!");
        while (timer > 0) {
            queue();
            kid.play();
            timer--;
        }
        System.out.println("Es hora de irse a casa! Cierra la ludoteca.\nEspero que se hayan divertido :)");
    }
}
