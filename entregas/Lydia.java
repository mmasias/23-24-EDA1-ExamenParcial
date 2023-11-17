package entregas;

public class Lydia implements Monitora {
    private Monitora siguienteMonitora;

    public void setSiguienteMonitora(Monitora monitora) {
        this.siguienteMonitora = monitora;
    }

    @Override
    public void recibirNiño(Niño niño) {
        System.out.println("Lydia recibe a " + niño.getNombre());
        siguienteMonitora.recibirNiño(niño);
    }

    @Override
    public void empezarJuego() {
        System.out.println("Lydia comienza un nuevo juego.");
    }
}
