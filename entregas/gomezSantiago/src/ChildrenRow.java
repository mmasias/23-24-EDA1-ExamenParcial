public class ChildrenRow {
    private int size = 0;
    private ChildNode first = null;

    public int size(){
        return this.size;
    }

    public void addChildrenToQueue(ChildNode child){
        if (this.first == null) {
            this.first = child;
        } else {
            ChildNode iterator = this.first;
            while (iterator.getNextChild() != null) {
                iterator = iterator.getNextChild();
            }
            iterator.setNextChild(child);
        }
        this.size++;
    }
    public void firstChildWritesOnBlackboard(String message){
        if(this.first != null){
            this.first.childWritesOnBlackboard(message);
            //passMessageToNextChild();
        }
    }

    public String nombrePrimerNino(){
        if (this.first != null){
            return this.first.getChildName();
        }
        return null;
    }
    public void removeChildFromQueue(){
        if(this.first != null){
            this.first = this.first.getNextChild();
            System.out.println("Se fue: " + this.first.getChildName());
            this.size--;
        }
    }
    public void giveBlackboardToChild (Blackboard childBlackboard){
        ChildNode iterator = this.first;
        while (iterator != null) {
            iterator.addChildBlackboard(childBlackboard);
            iterator = iterator.getNextChild();
        }
    }

    public void clearChildBlackboard() {
        ChildNode iterator = this.first;
        while (iterator != null) {
            iterator.clearChildBlackboard();
            iterator = iterator.getNextChild();
        }
    }

    public String getMessageFromFirstChild(){
        if(this.first != null){
            return this.first.getWrittenMessage();
        }
        return null;
    }

    public void passMessageToNextChild() {
        ChildNode iterator = this.first;

        while (iterator != null) {
            String childMessage = iterator.getWrittenMessage();
            System.out.println(iterator.getChildName() + " le pasa el mensaje al siguiente niño");

            iterator = iterator.getNextChild();

            if (iterator != null) {
                iterator.childWritesOnBlackboard(childMessage);
                System.out.println(iterator.getChildName() + " ha escrito " + iterator.getWrittenMessage());
            }
            else {
                System.out.println("Se ha llegado al ultimo niño");
            }
            this.size--;
        }
    }




}