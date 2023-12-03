import java.util.Random;

public class Crio {
    private int id;
    private  String frase;

    public Crio(int name) {
        this.id = name;
        this.frase ="";
    }



    public int getName() {
        return id;
    }

    public void setId(int name) {
        this.id = name;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }


}
