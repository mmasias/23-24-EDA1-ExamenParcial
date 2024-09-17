class ListaNiños {
    private NodoNino primero;
    private NodoNino ultimo;
    private int cantidadNiños;

    ListaNiños() {
        primero = null;
        ultimo = null;
        cantidadNiños = 0;
    }

    void agregarNiño(Nino niño) {
        NodoNino nuevoNodo = new NodoNino(niño);
        if (primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        cantidadNiños++;
    }

    int obtenerCantidadNiños() {
        return cantidadNiños;
    }

    NodoNino getPrimero() {
        return primero;
    }

    NodoNino getUltimo() {
        return ultimo;
    }

    void limpiarLista() {
        primero = null;
        ultimo = null;
        cantidadNiños = 0;
    }

    Nino removerPrimero() {
        if (primero != null) {
            Nino niño = primero.getNiño();
            primero = primero.getSiguiente();
            cantidadNiños--;
            return niño;
        }
        return null;
    }
}
