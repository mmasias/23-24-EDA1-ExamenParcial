package RetoTelefono;

// Clase Fila
public class Fila {
    private List<Niño> niños;
    private Node<Niño> primero;
    private Node<Niño> ultimo;

    public Fila() {
        this.niños = new List<>();
    }

    public void agregarNiño(Niño niño) {
        niños.insert(niño, -1);
    }

    public Niño removerNiño() {
        if (niños.getFirst() != null) {
            Niño niño = niños.getFirst().getData();
            niños.removeFirst();
            return niño;
        } else {
            return null;
        }
    }

    public int tamaño() {
        Node<Niño> current = niños.getFirst();
        int count = 0;

        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    public Node<Niño> getPrimero() {
        return primero;
    }

    public Node<Niño> getUltimo() {
        return ultimo;
    }
}
