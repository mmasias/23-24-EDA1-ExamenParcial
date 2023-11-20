import java.util.Scanner;

public class PlayRoom {

    private int hoursOpen = 2;
    private int minutesOpen = 60 * hoursOpen;
    private Monitor Lydia;
    private Monitor Aisha;
    private ChalkBoard playRoomChalkBoard;
    private int actualMinute = 1;
    private int minuteCharge = 0;

    public PlayRoom() {
        this.Lydia = new Monitor();
        this.Aisha = new Monitor();
        this.playRoomChalkBoard = new ChalkBoard();
    }

    private int arrivedChilds() {
        int numberOfChilds = 0;
        if (this.actualMinute <= 10) {
            numberOfChilds = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            return numberOfChilds;
        }
        if (this.actualMinute > 10 && this.actualMinute <= 30) {
            this.minuteCharge++;
            if (minuteCharge == 3) {
                minuteCharge = 0;
                if (Math.floor(Math.random()) * 100 <= 50) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private void manageWaitingChildren(int numberOfChilds, Monitor monitor) {
        if (numberOfChilds > 0) {
            int iterator = 1;
            while (iterator <= numberOfChilds) {
                monitor.setNewChild(new Child());
                iterator++;
            }
        }
    }

    public void consoleHandler(int arrivedNumber){
        System.out.print("|Num Of childs Arrived: " + arrivedNumber);
        System.out.println(" | Actual Minute: " + this.actualMinute);
        System.out.print("|Childs waiting: "+  Lydia.childList.size());
        System.out.println(" | Childs playing: " + Aisha.childList.size());
        
        System.out.println(">>Press Enter for Next Minute<<");
        Scanner inputScanner = new Scanner(System.in);
        inputScanner.nextLine();
    }

    private void gameHandler(Monitor monitorPlayer, Monitor monitorChildKeeper){
        int childWaiting = monitorChildKeeper.childList.size();

        if (childWaiting > 5) {
            if (!monitorPlayer.isPlaying()) {
                monitorPlayer.setPlaying(true);
                while (!monitorChildKeeper.isChildListEmpty()) {
                    Child child = monitorChildKeeper.passFirstChild();
    
                    child.setChalkBoard(new ChalkBoard());
    
                    monitorPlayer.setNewChild(child);
                }
            }

            if (monitorPlayer.isPlaying()) {
                if (monitorPlayer.actualChildTurnNode == null) {
                    monitorPlayer.cleanChalkBoard(this.playRoomChalkBoard);
                    monitorPlayer.chalkBoard.setMessage("Hello, World!");
                    monitorPlayer.monitorGame(playRoomChalkBoard);
                }
            }


        }

    }

    public void openPlayRoom() {

        while (this.actualMinute <= this.minutesOpen) {
            int arrivedNumber = arrivedChilds();
            this.manageWaitingChildren(arrivedNumber, Lydia);

            this.gameHandler(Aisha,Lydia);

            this.actualMinute = this.actualMinute + 1;
            this.consoleHandler(arrivedNumber);
        }
    }
}
