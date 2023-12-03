import estructuraDatos.Node;

public class Juego {
    private boolean estaJugando;
    private Node<Niño> niñoTurno;
    private Cola colaNiños;
    private int tiempoJuego = 1;

    MonitorEntrada monitorEntrada = new MonitorEntrada("Lydia");
    public Juego(Cola colaNiños) {
        this.estaJugando = false;
        this.colaNiños = colaNiños;
    }

    public boolean estaJugando() {
        return estaJugando;
    }

    public void jugar(int tiempoActual) {
        MonitorJuego monitorJuego = new MonitorJuego("Aisha");

        if (!estaJugando) {
            estaJugando = true;
            limpiarPizarras();
            Node<Niño> niñoActual = colaNiños.getNiños().getFirst();

            if (niñoActual != null) {
                niñoActual.getData().recibirMensaje(monitorJuego.getMensajeInicial());
            }

            for (; niñoActual != null; niñoActual = niñoActual.getNext()) {
                if (niñoActual.getNext() != null) {
                    Niño siguienteNiño = niñoActual.getNext().getData();
                    siguienteNiño.recibirMensaje(niñoActual.getData().mostrarMensaje());
                }
                tiempoJuego = tiempoActual++;
            }



            if (monitorEntrada.getColaDeNiños().hayNiños()) {
                agregarNiñosDeLydia();
                System.out.println(" > Se añadieron nuevos niños al juego!");
            }

            estaJugando = false;
        }
    }

    private void agregarNiñosDeLydia() {
        if (!estaJugando) {
            while (monitorEntrada.getColaDeNiños().size() > 0) {
                Niño niño = monitorEntrada.getColaDeNiños().removeFirstNiño();
                colaNiños.addNiño(niño);
            }
        }
    }


    private void limpiarPizarras() {
        Node<Niño> niño = colaNiños.getNiños().getFirst();
        while (niño != null) {
            niño.getData().limpiarPizarra();
            niño = niño.getNext();
        }
    }

    public int getTiempoJuego() {
        return tiempoJuego;
    }
    public int setSubeTiempoJuego() {
        tiempoJuego++;
        return tiempoJuego;
    }
}
