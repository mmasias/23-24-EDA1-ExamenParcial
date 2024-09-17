public class Ludoteca {
    private Monitor lydia;
    private Monitor aisha;
    

    public Ludoteca(){
        lydia = new Monitor("Lydia");
        aisha = new Monitor("Aisha");
        
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
            lydia.entregaNiños(aisha);
        }        
    }

    public void verEstado(){
        lydia.mostrarListaNiños();
        aisha.mostrarListaNiños();
    }
}
