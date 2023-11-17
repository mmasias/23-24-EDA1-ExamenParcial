package entregas.joseSalceda;

import java.util.List;

public class Monitora {
    private String nombre;

    public Monitora(String nombre) {
        this.nombre = nombre;
    }

    public void recibirNiño(Niño niño, List<Niño> fila) {
        System.out.println(nombre + " recibe a " + niño.getNombre());
        fila.add(niño);
    }

    public void darPizarrin(Niño niño) {
        System.out.println(nombre + " da un pizarrín a " + niño.getNombre());
    }

    public void recibirNiños(List<Niño> niños) {
        System.out.println(nombre + " recibe a los niños");
        // Lógica para recibir a los niños
    }
}
