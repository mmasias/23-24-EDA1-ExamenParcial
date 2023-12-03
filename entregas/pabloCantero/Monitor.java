public class Monitor {
    private String nombre;
    private Cola colaNiños;
    private boolean estaJugando;
    Node<Niño> niñoTurno;
    public Monitor(String nombre) {
        this.nombre = nombre;
        colaNiños = new Cola();
        estaJugando = false;
    }
    public void entrarNiño( Niño niño) {
        colaNiños.agregarNiño(niño);
    }
    public boolean tieneNiños() {
        return !colaNiños.estaVacia();
    }
    public boolean puedeJugar() {
        return !estaJugando && colaNiños.size() >= 5;
    }
    public boolean estaJugando() {
        return estaJugando;
    }
    public void listarNiños(){
        System.out.print("> " + this.nombre + " --> ");
        colaNiños.listarNiños();
        System.out.println();
    }
    public void ingresaNiño(Niño niño) {
        colaNiños.agregarNiño(niño);
    }
    public void entregaNiños(Monitor otroMonitor) {
        while (colaNiños.size() > 0) {
            System.out.println(" >  " + this.nombre + " ENTREGA NIÑO");
            Niño unNiño = colaNiños.removeNiño();
            otroMonitor.entraNiño(unNiño, new Pizarra());
        }
    }
    private void entraNiño(Niño niño, Pizarra pizarra) {
        niño.setPizarra(pizarra);
        colaNiños.agregarNiño(niño);
    }
    public void jugar() {
        if (!estaJugando) {
            estaJugando = true;
            limpiarPizarrines();
            niñoTurno = colaNiños.getNiños().getFirst();
            niñoTurno.getData().recibirMensaje("ABCDEFGHIJKLM");
        } else {
            Node<Niño> niño = colaNiños.getNiños().getFirst();
            while (niño != niñoTurno) {
                niño = niño.getNext();
            }
            if (niño.getNext() == null) {
                estaJugando = false;
                niñoTurno = colaNiños.getNiños().getFirst();
            } else {
                Niño niñoActual = niño.getData();
                Niño siguienteNiño = niño.getNext().getData();
                siguienteNiño.recibirMensaje(niñoActual.mostrarPizarraPequeña());
                niñoTurno = niño.getNext();
            }
        }
    }

    private void limpiarPizarrines() {
        Node<Niño> niño = colaNiños.getNiños().getFirst();
        while (niño != null) {
            niño.getData().borrarPizarraPequeña();
            niño = niño.getNext();
        }
    }
}


