class Monitor {
    private String nombre;
    private Cola colaNiños;
    private boolean estaJugando;
    Node<Niño> niñoTurno;

    public Monitor(String nombre) {
        this.nombre = nombre;
        this.colaNiños = new Cola();
        estaJugando = false;
    }

    public void recibeNiño(Niño niño) {
        colaNiños.addNiño(niño);
    }

    public boolean tieneNiños() {
        return colaNiños.hayNiños();
    }

    public boolean puedeJugar() {
        return colaNiños.size() >= 5;
    }

    public boolean estaJugando() {
        return estaJugando;
    }

    public void mostrarListaNiños() {
        System.out.print("> " + this.nombre + " --> ");
        colaNiños.listaNiños();
        System.out.println();
    }

    private void recibeNiño(Niño niño, Pizarra pizarrin) {
        niño.recibirPizarrin(pizarrin);
        colaNiños.addNiño(niño);
    }

    public void entregaNiños(Monitor otroMonitor) {
        while (colaNiños.hayNiños()) {
            System.out.println(" >  " + this.nombre + " ENTREGA NIÑO");
            Niño unNiño = colaNiños.removeNiño();
            otroMonitor.recibeNiño(unNiño, new Pizarra());
        }
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
                siguienteNiño.recibirMensaje(niñoActual.mostrarMensaje());
                niñoTurno = niño.getNext();
            }
        }
    }

    private void limpiarPizarrines() {
        Node<Niño> niño = colaNiños.getNiños().getFirst();
        while (niño != null) {
            niño.getData().limpiarPizarrin();
            niño = niño.getNext();
        }
    }
}
