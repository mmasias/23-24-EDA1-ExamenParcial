public class ChalkBoard {

    private String message;
    
    public ChalkBoard(){
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean chalkBoardClean(){
        return (this.message.length() == 0);
    }

    
}
