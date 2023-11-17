public class PlayRoom {

    private int hoursOpen = 2;
    private int minutesOpen = 60 * hoursOpen;
    private Monitor Lydia;
    private Monitor Aisha;
    private ChalkBoard chalkBoard;
    private int actualMinute = 1;
    private int minuteCharge = 0;

    public PlayRoom() {
        this.Lydia = new Monitor();
        this.Aisha = new Monitor();
        this.chalkBoard = new ChalkBoard();
    }

    private int arrivedChilds(){
        int numberOfChilds = 0;
        if(this.actualMinute <= 10){
            numberOfChilds = (int)Math.floor(Math.random() * (2 - 0 + 1) + 0);
        }
        if(this.actualMinute > 10 && this.actualMinute <= 30){
            this.minuteCharge++;
            if(minuteCharge == 3){
                minuteCharge = 0;
                numberOfChilds = (int) ;
                if () {
                    
                }
            }
        }
    }

}
