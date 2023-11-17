package entregas.joseRasilla;

public class Board {
    private String word ="";

    public void writeBoard(String toWrite){
        word = toWrite;
        work();
    }

    public void work(){
        System.out.println("Last Child writed " + word + " on the board");
    }
}
