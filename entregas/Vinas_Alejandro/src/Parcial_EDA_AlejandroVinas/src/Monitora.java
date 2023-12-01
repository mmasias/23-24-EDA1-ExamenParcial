import java.util.ArrayList;
import java.util.List;
public class Monitora {
    List <Nino> ninos = null;
    String nombre = "";

    public Monitora(String nombr) {
        this.nombre = nombr;
        this.ninos = new ArrayList<Nino>();
    }

    public void setNinos(List<Nino> ninos) {
        this.ninos = ninos;
    }

    public List<Nino> getNinos() {
        return ninos;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void entraNino(Nino nin) {
        ninos.add(nin);
    }
    public String dameLista() {
        String resul = "";
        for(Nino nin:this.ninos) {
            resul = resul +","+nin.nombre;
        }
        return resul;
    }
}
