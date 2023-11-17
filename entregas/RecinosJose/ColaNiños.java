public class ColaNiños {
    private Nodo inicio;
    private Nodo fin;

    private class Nodo {
        Niño niño;
        Nodo siguiente;

        public Nodo(Niño niño) {
            this.niño = niño;
            this.siguiente = null;
        }
    }

    public ColaNiños() {
        this.inicio = null;
        this.fin = null;
    }

    public void agregarNiño(Niño niño) {
        Nodo nuevoNodo = new Nodo(niño);
        if (isEmpty()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    public Niño obtenerSiguienteNiño() {
        if (isEmpty()) {
            return null;
        }
        Niño niño = inicio.niño;
        inicio = inicio.siguiente;
        if (inicio == null) {
            fin = null;
        }
        return niño;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public int getSize() {
        int size = 0;
        Nodo actual = inicio;
        while (actual != null) {
            size++;
            actual = actual.siguiente;
        }
        return size;
    }
}