package Ludoteca;

public class Aula {

    private Monitor lydia;
    private Monitor aisha;

    public Aula() {
        lydia = new Monitor("Lydia");
        aisha = new Monitor("Aisha");
    }

   
    private void verificarYPasarNiños() {
        if (lydia.tieneNiños() && !aisha.enJuego()) {
            lydia.pasaNiño(aisha);
        }
    }

    
    public void recibeNiño(Niño niño) {
        lydia.recibeNiño(niño);
        if (!aisha.enJuego()) {
            verificarYPasarNiños();
        }
    }


    public void comprobar() {
        verificarYPasarNiños();
        if (aisha.estadoCola()) {
            aisha.jugar();
        }
    }

    public void estado() {
        lydia.niñosEnCola();
        aisha.niñosEnCola();
    }
}
