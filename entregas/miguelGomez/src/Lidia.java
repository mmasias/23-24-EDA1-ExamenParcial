import java.util.ArrayList;
import java.util.List;

public class Lidia {
    public List<Nino> recibirNinos(List<Nino> ninos) {
        List<Nino> ninosRecibidos = new ArrayList<>();
        for (Nino nino : ninos) {
            System.out.println("Lydia recibe a un niño.");
            ninosRecibidos.add(nino);
        }
        return ninosRecibidos;
    }
}

