import java.util.Random;

public class AishaMonitor {
    private ChildrenRow childrenRowInAisha;
    private boolean aishaIsPlaying;
    private Blackboard blackboardToAisha;
    private String word;
    public AishaMonitor(Blackboard blackboard){
        this.childrenRowInAisha = new ChildrenRow();
        this.aishaIsPlaying = false;
        this.blackboardToAisha = blackboard;
    }

    public void addChildrenInRowAisha(ChildNode child){
        childrenRowInAisha.addChildrenToQueue(child);
    }

    public int childrenInRowAisha(){
        return childrenRowInAisha.size();
    }

    public boolean isAishaPlaying(){
        return this.aishaIsPlaying;
    }

    private String generateMessage() {
        Random random = new Random();
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char letter = (char) (random.nextInt(26) + 'A');
            message.append(letter);
        }
        this.word = message.toString();
        return this.word;
    }

    public void setAishaIsPlaying(boolean isPlaying){
        this.aishaIsPlaying = isPlaying;
    }

    public void clearPlayroomBlackboard(){
        this.blackboardToAisha.clearBlackboard();
    }

    public void aishaGivesBlackboardToChild(Blackboard childBlackboard){
        childrenRowInAisha.giveBlackboardToChild(childBlackboard);
    }


    public void clearBlackboardChild(){
        childrenRowInAisha.clearChildBlackboard();
    }

    public void writesOnBlackboard(){
        generateMessage();

        this.blackboardToAisha.writeOnTheBoard(word);
    }

    public String getWord(){
        return this.word;
    }

    public void givesMessageToFirstChild(){
        this.childrenRowInAisha.firstChildWritesOnBlackboard(word);
    }

    public String mensajePrimerNino(){
        return this.childrenRowInAisha.getMessageFromFirstChild();
    }

    public String nombreDelPrimerNino(){
        return this.childrenRowInAisha.nombrePrimerNino();
    }

    public void childrenPassTheMessage(){
        this.childrenRowInAisha.passMessageToNextChild();
    }
}