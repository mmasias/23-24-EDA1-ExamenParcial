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

    public void startGame(){
        while(!isTimeUp()){
            this.displayCurrentTime();
            this.isChildrenComing(this.currentTime);
            this.canWeStartPlaying();
            if (isPlaying){
                SysOut("Aisha comienza a jugar!\n");
                aisha.kidsPlaying();
                this.aisha.play();
            } else {
                SysOut("Lidia añade a los niños esperando!\n");
                this.lidia.incorporateChildrenToGame();
            }
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
    private void currentTimeToString(){
        Integer minutes = this.currentTime / 60;
        Integer seconds = this.currentTime % 60;
        SysOut(minutes + ":" + seconds);
    }
    
    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();
        ludoteca.startGame();
    }
}
