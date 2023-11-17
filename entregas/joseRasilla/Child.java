package entregas.joseRasilla;

import java.util.Random;

public class Child {
    public String word;
    public Child nexChild;
    //Ludoteca

    public Child(String wordGet){
        word = modifiedWord(wordGet);
    }

    public String modifiedWord(String originalWord){
        char[] newword = originalWord.toCharArray();
        Random r = new Random();
        int randomIndex = r.nextInt((5 - 0) + 1);
        int range = r.nextInt(26);
        char charleatory = (char) (range + 'A');
        newword[randomIndex] = charleatory;

        return new String(newword);
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
