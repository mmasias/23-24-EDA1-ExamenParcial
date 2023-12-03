public class Ludoteca {
    private Monitor lydia;
    private Monitor aisha;
    private Pizarra pizarraMonitor;

    public Ludoteca() {
        lydia = new Monitor("Lydia");
        aisha = new Monitor("Aisha");
        pizarraMonitor = new Pizarra();
    }

    public void entraNiño(Niño unNiño) {
        lydia.ingresaNiño(unNiño);

    }

    public void actualizar() {
        gestionarColas();
        if (aisha.puedeJugar()) {
            aisha.jugar();
        }
    }


    public void listarNiños(){
        lydia.listarNiños();
        aisha.listarNiños();
    }
    private void gestionarColas() {
        if (lydia.tieneNiños() && !aisha.estaJugando()) {
            lydia.entregaNiños(aisha);
        }        
    }
   
    
}
