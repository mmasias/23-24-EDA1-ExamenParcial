class NodoNino {
    private Nino niño;
    private NodoNino siguiente;

    NodoNino(Nino niño) {
        this.niño = niño;
        siguiente = null;
    }

    Nino getNiño() {
        return niño;
    }

    NodoNino getSiguiente() {
        return siguiente;
    }

    void setSiguiente(NodoNino siguiente) {
        this.siguiente = siguiente;
    }
}
