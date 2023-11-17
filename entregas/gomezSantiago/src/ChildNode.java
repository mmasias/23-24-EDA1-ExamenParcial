public class ChildNode {
    private ChildNode next;
    private Blackboard childBlackboard;
    private String childName;
    public ChildNode(String childName){
        this.childName = childName;
    }

    public String getChildName(){
        return this.childName;
    }

    public ChildNode getNextChild() {
        return next;
    }

    public void setNextChild(ChildNode next) {
        this.next = next;
    }

    public String getWrittenMessage(){
        return this.childBlackboard.writtenMessage();
    }

    public void addChildBlackboard(Blackboard childBlackboard){
        this.childBlackboard = childBlackboard;
    }

    public void clearChildBlackboard(){
        childBlackboard.clearBlackboard();
    }

    public void childWritesOnBlackboard (String message){
        if (Math.random() < 0.3){
            System.out.println("Se ha deformado el mensaje");
            String newDeformedMessage = deformMessage(message);
            childBlackboard.writeOnTheBoard(newDeformedMessage);
        } else {
            childBlackboard.writeOnTheBoard(message);
        }
    }

    private String deformMessage(String originalMessage) {
        char[] messageArray = originalMessage.toCharArray();
        int length = messageArray.length;

        for (int i = 0; i < 2; i++) {
            int indexToChange = (int) (Math.random() * length);
            char newChar = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
            messageArray[indexToChange] = newChar;
        }

        return new String(messageArray);
    }

}