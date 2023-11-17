import java.util.Scanner;

public class ToyLibrary {
    private int minute = 1;
    private int openingTime = 9 * 60;
    private int closingTime = 11 * 60;
    private int childNumber = 1;
    public boolean withinTheSchedule(){
        int minutesNight = closingTime - openingTime;

        return this.minute <= minutesNight;
    }

    public void startToyLibrary() {

        Blackboard playroomBlackboard = new Blackboard();
        Blackboard childrenBlackboard = new Blackboard();

        AishaMonitor aishaMonitor = new AishaMonitor(playroomBlackboard);
        LidiaMonitor lidiaMonitor = new LidiaMonitor(aishaMonitor);

        Scanner scanner = new Scanner(System.in);

        while (withinTheSchedule()){
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.print("Minuto " + minute + " - ");

            double childArrivalProbability = Math.random() * 100;
            if (childArrivalProbability <= 60) {
                ChildNode child = new ChildNode("Niño " + childNumber);
                lidiaMonitor.addChildrenInQueueLidia(child);
                childNumber++;
                System.out.println("Llega 1 niño - ");
            } else {
                System.out.println("No llega nadie - ");
            }

            if(aishaMonitor.childrenInRowAisha() > 5){
                aishaMonitor.setAishaIsPlaying(false);


                System.out.println("Aisha limpia la pizarra del salón");
                aishaMonitor.clearPlayroomBlackboard();

                System.out.println("Aisha le da las pizarras a los niños");
                aishaMonitor.aishaGivesBlackboardToChild(childrenBlackboard);


                System.out.println("Aisha le dice a los niños que limpien su pizarra");
                aishaMonitor.clearBlackboardChild();

                System.out.println("Aisha escribe una palabra en su pizarra");
                aishaMonitor.writesOnBlackboard();

                System.out.println("Aisha ha escrio en su pizarra: " + aishaMonitor.getWord());
                aishaMonitor.givesMessageToFirstChild();

                System.out.print(aishaMonitor.nombreDelPrimerNino());
                System.out.println(" ha escrito: " + aishaMonitor.mensajePrimerNino());

                System.out.println("Aisha le dice al niño que pase el mensaje");
                aishaMonitor.childrenPassTheMessage();

                System.out.println("Juego con aisha termina");
                aishaMonitor.setAishaIsPlaying(false);
            }

            System.out.println("Niños en cola con lidia: " + lidiaMonitor.childrenInQueueLidia());
            System.out.println("Niños con aisha: " + aishaMonitor.childrenInRowAisha());


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