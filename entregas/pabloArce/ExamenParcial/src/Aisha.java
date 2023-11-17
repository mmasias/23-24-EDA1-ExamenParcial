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

    public void kidsPlaying(){
        SysOut("Aisha tiene " + this.childrenPlaying.size() + " niños jugando\n");
    }

    public void play(){
        cleanBlackboard();
        writeOnBlackboard();
        SysOut("Como empezo la palabra: " + blackboard + "\n");
        Queue<Children> gameQueueStarted = childrenPlaying;
        Children lastChildren = null;
        for (int i= 0; i < this.childrenPlaying.size(); i++){
            if (lastChildren == null){
                lastChildren = gameQueueStarted.peek(1);
                lastChildren.writeWord(readBlackboard());
            } else {
                gameQueueStarted.peek(1).writeWord(lastChildren.readWord());
                lastChildren = gameQueueStarted.peek(1);
            }
            lastChildren.editGivenWord();
            if (!(gameQueueStarted.size() == 1)){
                gameQueueStarted.dequeue();
            }
        }
        blackboard = lastChildren.readWord();
        SysOut("Como acabo la palabra: " + blackboard + "\n");
    }

    private void writeOnBlackboard(){
        Random random = new Random();
        int randomIndex = random.nextInt(WORDS.length);
        this.blackboard = WORDS[randomIndex];
    }

    private String readBlackboard(){
        return this.blackboard;
    }

    private void cleanBlackboard(){
        this.blackboard = "";
    }
}
