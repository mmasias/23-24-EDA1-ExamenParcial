public class Ludoteca {
    private Monitor lydia;
    private Monitor aisha;

    public Ludoteca(){
        lydia = new Monitor("Lydia");
        aisha = new Monitor("Aisha");
    }

    public void recibirNiño(Niño niño) {
        lydia.recibirNiño(niño);
        if (lydia.tieneNiños() && !aisha.estaJugando()) {
            lydia.transferirNiños(aisha);
        }
    }

    public void actualizarEstado() {
        if (!aisha.estaJugando() && aisha.tieneNiños()) {
            aisha.iniciarJuego();
        } else {
            aisha.jugar();
        }
    }

    public void mostrarEstadoActual() {
        lydia.mostrarNiños();
        aisha.mostrarNiños();
    }
}