
class Ludoteca {
    private Monitor lydia;
    private Monitor aisha;
    private Pizarra pizarraDelSalon;

    public Ludoteca(){
        lydia = new Monitor("Lydia");
        aisha = new Monitor("Aisha");
        pizarraDelSalon = new Pizarra();
    }

    public void recibirNiño(Niño niño) {
        lydia.recibeNiño(niño);
    }

    public void actualizar() {
        gestionarColas();
        if (aisha.puedeJugar()) {
            aisha.jugar();
        } 
    }

    private void gestionarColas() {
        if (lydia.tieneNiños() && !aisha.estaJugando()) {
            aisha.jugar();
            lydia.entregaNiños(aisha);
        }        
    }

    public void verEstado(){
        lydia.mostrarListaNiños();
        aisha.mostrarListaNiños();
    }
}