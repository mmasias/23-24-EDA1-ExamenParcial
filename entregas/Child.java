public class Child {

    private ChalkBoard chalkBoard;
    boolean isPlaying;

    public Child() {
        
    }

    public void writeInPlayRoomChalkBoard(ChalkBoard playRoomChalkBoard,String message){
        playRoomChalkBoard.setMessage(message);
    }

    public void writeInChalkBoard(String message){
        this.chalkBoard.setMessage(message);
    }

    public ChalkBoard getChalkBoard() {
        return chalkBoard;
    }

    public void setChalkBoard(ChalkBoard chalkBoard) {
        this.chalkBoard = chalkBoard;
    }

}
