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
        if (lydia.tieneNiños() && !aisha.estaJugando()) {
            lydia.entregaNiños(aisha);
        }
    }

    public void actualizar() {
        if (aisha.puedeJugar()) {
            aisha.jugar();
        } 
    }

    public void verEstado(){
        lydia.mostrarListaNiños();
        aisha.mostrarListaNiños();
    }
}