package entregas;

public class Aisha implements Monitora {
    private ListaEnlazada<Niño> fila = new ListaEnlazada<>();

    @Override
    public void recibirNiño(Niño niño) {
        System.out.println("Aisha recibe a " + niño.getNombre() + " y le da un pizarrín.");
        fila.agregarAlFinal(niño);
    }

    @Override
    public void empezarJuego() {

    }
}
