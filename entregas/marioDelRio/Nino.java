public class Nino {

    private String ID;
    private String pizarrin;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getPizarrin() {
        return pizarrin;
    }

    public void setPizarrin(String pizarrin) {
        this.pizarrin = pizarrin;
    }

    public Nino(String iD) {
        ID = iD;
        pizarrin = "";
    }
}
