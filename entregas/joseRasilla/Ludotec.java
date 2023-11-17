package entregas.joseRasilla;

public class Ludotec {
    //Reloj de la ludoteca
    public int clock = 0;
    public int childCount = 0;
    public int childPlaying = 0;
    public Child firstChild;
    public Child currentChild;

    public String initialWord = "Ludoteca";
    public Board board = new Board();

    //Recibe un niño y lo pone en la fila
    public void newChild(){
        if (childPlaying==0) {
            firstChild = new Child(initialWord);
            currentChild = firstChild;
            childCount++;
            childPlaying++;
        }else if (childPlaying<5 && childPlaying>=1) {
            currentChild.setChild(new Child(currentChild.getWord()));
            currentChild = currentChild.getNextChild();
            childCount++;
            childPlaying++; 
        } else if(childPlaying == 5){
            startGame(currentChild);
            childCount++;
        } else childCount++;
    }

    //Cuando niños es 5 empieza juego

    //JUEGO
        //Hay una pizzarra
        //Hay una palabra inicial
        //Niño 0 recibe palabra

    public void startGame(Child currentChild){
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("+-+-+-+ GAME JUST STARTED +-+-+-+");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        currentChild.runToBoard(board);
        endGame();
    }

    public void endGame(){
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("+-+-+-+-+- GAME  ENDED +--+-+-+-+");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        childPlaying = 0;
        childCount = childCount - 5;
        while(childCount>0 && childPlaying<5) {
            if (childPlaying==0) {
                firstChild = new Child(initialWord);
                currentChild = firstChild;
                childPlaying++;
                childCount--;
            }
            if (childPlaying<5) {
                currentChild.setChild(new Child(currentChild.getWord()));
                currentChild = currentChild.getNextChild();
                childPlaying++; 
                childCount--;
            } else if(childPlaying == 5){
            startGame(currentChild);
            }
        }
    }


    //Recepcion de mensaje en pizarra

    public void openLudotec(){
        System.out.println("################################");
        System.out.println("##### LUDOTEC IS NOW OPEN ######");
        System.out.println("################################");
    }
    public void closeLudotec(){
        System.out.println("################################");
        System.out.println("#### LUDOTEC IS NOW CLOSED #####");
        System.out.println("################################");
    }

    public void passMinute(){
        if (childCount<0) {
            childCount = 0;
        }
        System.out.println("There are " + childCount + " children waiting");
        System.out.println("There are " + childPlaying + " children on the line");

        clock++;

        System.out.println("Min " + clock + " ended");
        System.out.println("################################");
    }



}
