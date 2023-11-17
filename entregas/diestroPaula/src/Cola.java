class Cola {
    private Nodo inicio;
    private Nodo fin;

    Cola() {
        this.inicio = null;
        this.fin = null;
    }

    void encolar(Niño niño) {
        Nodo nuevoNodo = new Nodo(niño);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    Niño desencolar() {
        if (inicio == null) {
            return null;
        } else {
            Nodo nodoDesencolado = inicio;
            inicio = inicio.getSiguiente();
            if (inicio == null) {
                fin = null;
            }
            return nodoDesencolado.getNiño();
        }
    }

    boolean estaVacia() {
        return inicio == null;
    }

    Niño getUltimoNiño() {
        return fin != null ? fin.getNiño() : null;
    }
}