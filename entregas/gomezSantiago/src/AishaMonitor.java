public class AishaMonitor {
    private ChildRow childrenInRowAisha;
    private boolean aishaIsPlaying = false;

    public AishaMonitor(){
        this.childrenInRowAisha = new ChildRow();
    }

    public void addChildrenInQueueAisha(){
        childrenInRowAisha.addChildToRow();
    }

    public int childrenInRowAisha(){
        return childrenInRowAisha.size();
    }

    public boolean isAishaPlaying() {
        return aishaIsPlaying;
    }

    public void startGame(Blackboard playRoomBlackboard){
        this.aishaIsPlaying = true;
        playRoomBlackboard.clearBlackboard();
    }
}
