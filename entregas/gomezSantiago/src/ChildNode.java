public class ChildNode {
    private ChildNode next;
    private Blackboard childBlackboard;

    public ChildNode(){
    }

    public ChildNode getNextChild(){
        return next;
    }

    public void setNextChild(ChildNode next) {
        this.next = next;
    }

    public void addChildBlackboard(Blackboard blackboard) {this.childBlackboard = childBlackboard;}

}
