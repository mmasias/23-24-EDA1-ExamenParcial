package propuestaFinal;

public class Fila {
    Nodo inicio;
    Nodo fin;

    public Fila() {
        this.inicio = null;
        this.fin = null;
    }

    public void enfilar(Niño niño) {
        Nodo nuevoNodo = new Nodo(niño);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    public Niño desenfilar() {
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