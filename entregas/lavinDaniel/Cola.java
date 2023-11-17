package src;

class Cola {
    Nodo inicio;
    Nodo fin;

    public Cola() {
        this.inicio = null;
        this.fin = null;
    }

    public void encolar(Niño niño) {
        Nodo nuevoNodo = new Nodo(niño);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    public Niño desencolar() {
        if (inicio == null) {
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
}
