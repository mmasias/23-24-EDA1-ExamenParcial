
public class Niño implements Jugador{
    private String id;
    private String pizarrin;

    public Niño(String id) {
        this.id = id;
        pizarrin="";
    }

    public String getId() {
        return id;
    }

    public String getPizarrin() {
        return pizarrin;
    }

    public void setPizarrin(String pizarrin) {
        this.pizarrin = pizarrin;
    }

    @Override
    public String conseguirtPizarrin() {
        return getPizarrin();
    }

    @Override
    public void actualizarPizarrin(String texto) {
        setPizarrin(texto);
    }

    @Override
    public String mostrarValores() {
        return "Niño{" + "id=" + id + ", pizarrin=" + pizarrin + '}';
    }

   

    

    
    
}