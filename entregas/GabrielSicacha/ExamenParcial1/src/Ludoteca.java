import java.util.Scanner;

public class Ludoteca {
    public Monitoras lydia;
    public Monitoras aisha;
    private Pizarra pizarron;

    public Ludoteca() {
        lydia = new Monitoras("Lydia");
        aisha = new Monitoras("Aisha");
        pizarron = new Pizarra();

    }

    public void llegaNiño(){
        lydia.recibirNiño();
    }

    public void gestionarFilas(){
        if (lydia.tieneNiños() && !aisha.estaJugando()){
            lydia.pasarNiño(aisha);
        }
    }

    public void actualizar() {
        gestionarFilas();
        if (aisha.puedeJugar()) {
            aisha.juego();
        }
    }
}


