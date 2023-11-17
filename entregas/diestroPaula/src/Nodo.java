class Nodo {
    Niño niño;
    Nodo siguiente;

    Nodo(Niño niño) {
        this.niño = niño;
        this.siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo nuevoNodo) {
        this.siguiente = nuevoNodo;
    }

    public Niño getNiño() {
        return niño;
    }
}