class Lista {
    private Nodo inicio;

    public void agregarAlFinal(Niño nuevoNiño) {
        Nodo nuevoNodo = new Nodo(nuevoNiño);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public Nodo getInicio() {
        return inicio;
    }
}