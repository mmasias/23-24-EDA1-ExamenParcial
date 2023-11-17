public class Blackboard {
    private String message;
    public void clearBlackboard(){
        this.message = "";
    }
    public void writeOnTheBoard(String message){
        this.message = message;
    }
    public String writtenMessage(){
        return this.message;
    }
}