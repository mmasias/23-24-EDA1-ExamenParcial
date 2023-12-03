package ludoteca;

import core.utils.Node;

public class Juego {
    Node<Niño> nodoNiñoTurno;
    private boolean enJuego;
    private Cola cola;

    public Juego(Cola cola) {
        this.enJuego = false;
        this.cola = cola;
    }

    public void limpiarPizarrines() {
        Node<Niño> nodoNiño = cola.obtenerNiños().getFirst();
        while (nodoNiño != null) {
            nodoNiño.getData().limpiarPizarra();
            nodoNiño = nodoNiño.getNext();
        }
    }

    public boolean estaEnJuego() {
        return enJuego;
    }

    public void jugar() {
        if (!enJuego) {
            enJuego = true;
            System.out.println("Ha empezado el juego");
            limpiarPizarrines();
            nodoNiñoTurno = cola.obtenerNiños().getFirst();
            nodoNiñoTurno.getData().corregirEscucha("abcdefghi");
        } else {
            Node<Niño> nodoNiño = cola.obtenerNiños().getFirst();

            while (nodoNiño != nodoNiñoTurno) {
                nodoNiño = nodoNiño.getNext();
            }

            if (nodoNiño != null) {
                if (nodoNiño.getNext() == null) {
                    enJuego = false;
                    nodoNiñoTurno = cola.obtenerNiños().getFirst();
                    System.out.println("Se ha terminado el juego");
                    System.out.println("PALABRA FINAL: " + nodoNiño.getData().mostrarPalabra());
                } else {
                    Niño niñoActual = nodoNiño.getData();
                    Niño siguienteNiño = nodoNiño.getNext().getData();
                    siguienteNiño.corregirEscucha(niñoActual.mostrarPalabra());
                    System.out.println("El niño ha pasado la palabra: " + niñoActual.mostrarPalabra());
                    nodoNiñoTurno = nodoNiño.getNext();
                }
            }
        }
    }
}
