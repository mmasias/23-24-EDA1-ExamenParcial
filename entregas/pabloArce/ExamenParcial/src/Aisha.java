import Utils.Queue;

import java.util.Random;

import static Utils.Utils.SysOut;

public class Aisha {
    private Queue<Children> childrenPlaying;
    private String blackboard;
    private static final String[] WORDS = {
            "aberrante", "caminante", "diferente", "elegancia", "felicidad",
            "ganadores", "historias", "importantes", "jardinero", "kilometro",
            "laberinto", "magnificos", "numeracion", "optimistas", "problemas",
            "quemadura", "resplande", "sebastian", "television", "universidad",
            "vibracion", "washington", "xenofobia", "yacimiento", "zarcillos"
    };

    public Aisha(){
        this.childrenPlaying = new Queue<Children>();
    }

    public Queue<Children> getChildrenList(){
        return this.childrenPlaying;
    }

    public int numberOfKidsPlaying(){
        return this.childrenPlaying.size();
    }

    public void play(int turn){
        Children actualChildren = this.childrenPlaying.getNodeData(turn);
        if (turn == 0){
            cleanBlackboard();
            writeOnBlackboard();
            SysOut("Como empezo la palabra: " + blackboard + "\n");
            actualChildren.listenWord(this.readBlackboard());
        }
        else if (turn + 1 == this.numberOfKidsPlaying()){
            this.writeOnBlackboard(actualChildren.readWord());
            SysOut("Como acabo la palabra: " + blackboard + "\n");
        } else {
            Children lastChildren = this.childrenPlaying.getNodeData(turn-1);
            actualChildren.listenWord(lastChildren.readWord());
            SysOut("Los niños estan jugando\n");
        }
    }

    private void writeOnBlackboard(){
        Random random = new Random();
        int randomIndex = random.nextInt(WORDS.length);
        String word = WORDS[randomIndex];
        writeOnBlackboard(word);
    }
    private void writeOnBlackboard(String word) {
        this.blackboard = word;
    }

        private String readBlackboard(){
        return this.blackboard;
    }

    private void cleanBlackboard(){
        this.blackboard = "";
    }
}
