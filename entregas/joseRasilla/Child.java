package entregas.joseRasilla;

public class Child {
    public String word;
    public Child nexChild;
    //Ludoteca

    public Child(String wordGet){
        word = modifiedWord(wordGet);
    }

    public String modifiedWord(String originalWord){
        return originalWord;
    }

    public String getWord(){
        return word;
    }

    public Child getNextChild(){
        return nexChild;
    }

    public void setChild(Child nextChild){
        this.nexChild = nextChild;
    }


    //JUEGO
        //Niño recibe palabra y la guarda
            //Modificada la palabra
        //Se lo enseña al siguiente niño
        //Si es ultimo niño lo escribe en Ludoteca Pizarra

    public void runToBoard(Board board){
        board.writeBoard(getWord());
    }



}
