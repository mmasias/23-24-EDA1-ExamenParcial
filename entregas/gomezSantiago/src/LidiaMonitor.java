public class LidiaMonitor {
    private ChildRow lidiaChildrenRow;

    private AishaMonitor aishaMonitor;

    public LidiaMonitor(AishaMonitor aishaMonitor){
        this.lidiaChildrenRow = new ChildRow();
        this.aishaMonitor = aishaMonitor;
    }

    public void addChildrenInQueue(){
        if (!aishaMonitor.isAishaPlaying()){
            aishaMonitor.addChildrenInQueueAisha();
        } else {
            lidiaChildrenRow.addChildToQueue();
        }
    }

    public int childrenInQueueLidia(){
        return lidiaChildrenRow.size();
    }
}
