import java.util.Scanner;

public class ToyLibrary {
    private int minute = 1;
    private int openingTime = 9 * 60;
    private int closingTime = 11 * 60;

    public boolean withinTheSchedule(){
        int minutesNight = closingTime - openingTime;
        return this.minute <= minutesNight;
    }

    public void startToyLibrary() {
        Blackboard playRoomBlackboard = new Blackboard();
        AishaMonitor aishaMonitor = new AishaMonitor();
        LidiaMonitor lidiaMonitor = new LidiaMonitor(aishaMonitor);

        Scanner scanner = new Scanner(System.in);


        while (withinTheSchedule()){

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Minuto " + minute + " - ");

            double childArrivalProbability = Math.random() * 100;
            if (childArrivalProbability <= 60) {
                lidiaMonitor.addChildrenInQueue();
                System.out.print("Llega 1 niño - ");
            } else {
                System.out.print("No llega nadie - ");
            }

            if (aishaMonitor.childrenInRowAisha() > 5){
                aishaMonitor.startGame(playRoomBlackboard);
                System.out.println("Empieza el juego con Aisha");
            }


            System.out.println("Niños con Lidia: " + lidiaMonitor.childrenInQueueLidia());
            System.out.println("Niños con Aisha: " + aishaMonitor.childrenInRowAisha());

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Enter para siguiente minuto, 'q' para salir:");

            String input = scanner.nextLine();
            if ("q".equalsIgnoreCase(input)){
                break;
            }
            minute++;

        }
    }
}
