package RetoTelefono;

public class Monitor {
    private String nombre;

    public Monitor(String nombre) {
        this.nombre = nombre;
    }

    public void recibirNiño(Niño niño) {
        System.out.println(nombre + " recibe al niño " + niño.getNombre());
        Pizarra pizarra = new Pizarra();
        niño.setPizarra(pizarra);
    }

    public void formarFila(Fila fila, Niño niño) {
        fila.agregarNiño(niño);
    }

    // En la clase Monitor
    public void limpiarPizarrines(Fila fila) {
        Node<Niño> current = fila.getPrimero();
        while (current != null) {
            current.getData().limpiarPizarra();
            current = current.getNext();
        }
    }

}
