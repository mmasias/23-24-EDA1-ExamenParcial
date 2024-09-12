package parcial;

public class Lydia {
    private List<Niño> cola = new List<>();

    public void recibirNiño(Niño niño) {
        cola.insert(niño, -1);
        System.out.println("Lydia ha recibido al niño " + niño.getNombre());
    }

    public List<Niño> obtenerCola() {
        return cola;
    }
}