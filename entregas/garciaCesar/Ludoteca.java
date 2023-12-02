class Ludoteca {
    private Monitor lydia;
    private Monitor aisha;
    private boolean juegoIniciado;
    private boolean primerTurno;

    public Ludoteca() {
        lydia = new Monitor("Lydia");
        aisha = new Monitor("Aisha");
        juegoIniciado = false;
        primerTurno = false;
    }

    public void recibirNiño(Niño niño) {
        lydia.recibeNiño(niño);
        if (!juegoIniciado && lydia.tieneNiñosEnCola() && lydia.cantidadNiñosEnCola() >= 5) {
            lydia.entregaNiños(aisha);
            aisha.jugar();
            juegoIniciado = true;
            primerTurno = true;
        } else {
            primerTurno = false;
        }
    }

    public void actualizar() {
        if (juegoIniciado && lydia.tieneNiñosEnCola() && !primerTurno) {
            lydia.entregaNiños(aisha);
            aisha.jugar();
        }
    }

    public void verEstado() {
        lydia.mostrarListaNiños();
    }
}