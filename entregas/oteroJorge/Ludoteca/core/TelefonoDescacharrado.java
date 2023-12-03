package core;
import core.utils.Node;

public class TelefonoDescacharrado {
    private boolean estaEnJuego;
    private Cola cola;
    Node<Niño> niñoTurno;

    public TelefonoDescacharrado(Cola cola) {
        this.cola = cola;
        estaEnJuego = false;
    }

    public void jugar(){
        if(!estaEnJuego){
            estaEnJuego = true;
            System.out.println("Ha empezado el juego");
            limpiarPizarrines();
            niñoTurno = cola.getNiños().getFirst();
            niñoTurno.getData().errorDeEscucha("abcdefghi");
        } else {
            Node<Niño> niño = cola.getNiños().getFirst();

            while (niño != niñoTurno) {
                niño = niño.getNext();
            }
            
            if (niño != null) {
                if (niño.getNext() == null) {
                    estaEnJuego = false;
                    niñoTurno = cola.getNiños().getFirst();
                    System.out.println("Se ha terminado el juego");
                    System.out.println("PALABRA FINAL: " + niño.getData().mostrarPalabra());
                } else {
                    Niño niñoActual = niño.getData();
                    Niño siguienteNiño = niño.getNext().getData();
                    siguienteNiño.errorDeEscucha(niñoActual.mostrarPalabra());
                    System.out.println("El niño ha pasado la palabra: " + niñoActual.mostrarPalabra());
                    niñoTurno = niño.getNext();
                }
            }
        }
    }

    public void limpiarPizarrines(){
        Node<Niño> niño = cola.getNiños().getFirst();
        while (niño != null) {
            niño.getData().limpiarPizarra();
            niño = niño.getNext();
        }
    }

    public boolean enJuego(){
        return estaEnJuego;
    }
}
