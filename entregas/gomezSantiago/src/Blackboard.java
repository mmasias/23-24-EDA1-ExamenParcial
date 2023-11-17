public class Blackboard {
    private String message;

    public void clearBlackboard(){
        this.message = "";
    }

    public void writeOnBoard(String message){
        this.message = message;
    }


}
