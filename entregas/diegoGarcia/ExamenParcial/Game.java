package entregas.diegoGarcia.ExamenParcial;

import java.util.Random;

public class Game {
    private GenericList<Child> lidia;
    private GenericList<Child> aisha;
    private boolean isPlaying = false;
    private int totalTime = 120;
    private String message;
    private int n = 0;

    public Game() {
        this.lidia = new GenericList<Child>();
        this.aisha = new GenericList<Child>();
        message = null;
        n = 0;
    }

    public void start() {
        printLine();
        Random r = new Random();
        for (int minute = 0; minute < totalTime; minute++) {
            if (minute <= 10) {
                int childrenNumber = r.nextInt(3);
                for (int i = 0; i < childrenNumber; i++) {
                    goWaitingQueue(new Child(String.valueOf(n)));
                    System.out.println( "Minute " + minute + " - Child " + n + " arrived" );
                    System.out.println("-".repeat(42));
                    n++;
                }

            } else if (minute <= 30) {
                if ((minute - 10) % 3 == 0) {
                    if (r.nextInt(100) < 50) {
                        goWaitingQueue(new Child(String.valueOf(n)));
                        n++;
                    }
                }

            }

            lidiaSendThemIn();
            if (isPlaying) {
                play(minute);
            }

            printLine();

        }

    }

    public void goWaitingQueue(Child nino) {
        this.lidia.insertEnd(nino);
    }

    public void lidiaSendThemIn() {
        if (!isPlaying && (this.lidia.size() >= 5 || this.aisha.size() > 0)) {
            while (!this.lidia.isEmpty()) {
                Child nino = this.lidia.deleteFront();
                System.out.println( "Child " + nino.getId() + " is now playing" );
                this.aisha.insertEnd(nino);
            }
            isPlaying = true;
            printLine();
            System.out.println("----  New game starts  ----");
            printLine();
        }
    }

    public void printLine(){
        System.out.println("=".repeat(42));
    }

    public void play(int minute) {
        if (this.message == null) {
            this.message = Text.createRandomString(10);
        }

        if (this.aisha.sendMessage(this.message, minute)) {
            System.out.println( "Game Finished:");
            this.aisha.list();
            this.message = null;
            this.aisha.reset();
            isPlaying = false;
        }
    }
}
