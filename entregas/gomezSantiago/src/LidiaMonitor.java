public class LidiaMonitor {
    private ChildrenRow childrenRowInLidia;
    private AishaMonitor aishaMonitor;

    public LidiaMonitor(AishaMonitor aishaMonitor){
        this.childrenRowInLidia = new ChildrenRow();
        this.aishaMonitor = aishaMonitor;
    }

    public void addChildrenInQueueLidia(ChildNode child){
        if(!aishaMonitor.isAishaPlaying()){
            aishaMonitor.addChildrenInRowAisha(child);
        } else {
            childrenRowInLidia.addChildrenToQueue(child);
        }
    }

    public int childrenInQueueLidia(){
        return childrenRowInLidia.size();
    }
}