package entregas.diegoGarcia.ExamenParcial;

public class Child implements IDataStructure{
    private String id;
    private String blackBoard;

    public Child(String id) {
        this.id = id;
        blackBoard="";
    }

    public String getId() {
        return id;
    }

    public String getBlackBoard() {
        return blackBoard;
    }

    public void setBlackBoard(String blackBopard) {
        this.blackBoard = blackBopard;
    }

    @Override
    public String takeBlackboard() {
        return getBlackBoard();
    }

    @Override
    public void updateBlackboard(String message) {
        setBlackBoard(message);
    }

    @Override
    public String showValues() {
        return " - Child " + id + " Writes: '" + blackBoard +"'";
    }
}
