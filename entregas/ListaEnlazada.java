package entregas;

public class ListaEnlazada<T> {
    Nodo<T> cabeza;

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public T eliminarPrimero() {
        if (cabeza == null) {
            return null;
        }

        T datoEliminado = cabeza.dato;
        cabeza = cabeza.siguiente;
        return datoEliminado;
    }

    public int size() {
        int count = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }
}