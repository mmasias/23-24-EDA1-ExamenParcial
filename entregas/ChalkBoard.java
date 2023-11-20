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

    public void cleanChalkBoard(){
        this.message = "";
    }

    public boolean isChalkBoardClean(){
        return (this.message.length() == 0);
    }

    
}
