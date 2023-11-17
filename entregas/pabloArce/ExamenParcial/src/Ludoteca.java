import static Utils.Utils.SysOut;

public class Ludoteca {
    private Integer timeLimit;
    private Integer currentTime;
    private boolean isPlaying;
    private Lidia lidia;
    private Aisha aisha;

    public Ludoteca(){
        this.timeLimit = 120;
        this.currentTime = 0;
        isPlaying = false;
        this.aisha = new Aisha();
        this.lidia = new Lidia(this.aisha);
    }

    public void startSession(){
        spacing();
        int turn = 0;

        while(!isTimeUp()){
            this.displayCurrentTime();
            this.isChildrenComing(this.currentTime);
            if (!isPlaying){
                this.lidia.incorporateChildrenToGame();
            }
            this.canWeStartPlaying();
            if (isPlaying){
                if (turn == 0){
                    SysOut("Aisha comienza a jugar!\n");
                    SysOut("Aisha tiene " + aisha.numberOfKidsPlaying() + " niño/s jugando\n");
                }
                this.aisha.play(turn);
                if (this.aisha.numberOfKidsPlaying() == turn + 1){
                    SysOut("Aisha termina de jugar!\n");
                    this.isPlaying = false;
                    turn = -1;
                }
                turn++;
            }
            spacing();
        }
    }
    private boolean isTimeUp(){
        return this.currentTime > this.timeLimit;
    }

    private void isChildrenComing(int currentTime) {
        int numChildren = 0;
        if (currentTime < 10) {
            numChildren = (int) (Math.random() * 3);
        } else if (currentTime < 30) {
            if ((currentTime - 10) % 3 == 0 && Math.random() < 0.5) {
                numChildren++;
            }
        }
        for (int i = 0; i < numChildren; i++) {
            this.lidia.handleChildren(this.isPlaying, new Children());
        }
        SysOut("Entran " + numChildren + " niños\n");
    }

    private void canWeStartPlaying(){
        if (this.isPlaying) return;
        if (this.aisha.getChildrenList().size() >= 5){
            this.isPlaying = true;
        }
    }

    private void displayCurrentTime(){
        SysOut("Time: ");
        this.currentTimeToString();
        SysOut("\n");
        this.currentTime++;
    }
    private void spacing(){
        SysOut("= ".repeat(20));
        SysOut("\n");
    }
    private void currentTimeToString() {
        int hours = (this.currentTime / 60 + 16) % 24; // 16:00 empiezan a jugar
        int minutes = this.currentTime % 60;

        String formattedTime = String.format("%02d:%02d", hours, minutes);

        System.out.println(formattedTime);
    }

    
    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();
        ludoteca.startSession();
    }
}
