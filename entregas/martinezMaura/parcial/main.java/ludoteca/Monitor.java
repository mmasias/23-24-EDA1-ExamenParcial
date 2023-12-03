package ludoteca;
import ludoteca.utils.Node;

public class Monitor {

    private String nombre;
    private Cola cola;
    private Node<Niño> niño;
    private Juego telefono;

    public Monitor(String nombre) {
        this.nombre = nombre;
        this.cola = new Cola();
        this.telefono = new Juego (cola);
    }

    public void recibeNiño(Niño niño) {
        cola.addNiño(niño);
    }

    public boolean tieneNiños() {
        return cola.tieneNiños();
    }

    public void niñosEnCola() {
        System.out.println(this.nombre + " tiene " + cola.tamañoDeCola() + " niños en cola");
    }

    public void pasaNiño(Monitor monitor) {
        while (cola.tieneNiños()) {
            System.out.println("El niño pasa a " + monitor.nombre);
            Niño niño = cola.removeNiño();
            monitor.recibeNiño(niño);
        }
    }

    public boolean enJuego() {
        return telefono.enJuego();
    }

    public boolean estadoCola() {
        return cola.tamañoDeCola() >= 5;
    }

    public void jugar() {
        telefono.jugar();
    }
}
