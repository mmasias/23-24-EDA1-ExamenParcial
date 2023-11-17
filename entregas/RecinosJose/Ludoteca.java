import java.util.Random;

public class Ludoteca {
    private Monitor monitor;
    private int tiempoTranscurrido;

    public Ludoteca() {
        this.monitor = new Monitor();
        this.tiempoTranscurrido = 0;
    }

    public void simularDosHoras() {
        Random random = new Random();
        boolean juegoIniciado = false;

        int tiempoActual; // Mueve la declaración aquí

        for (tiempoActual = 1; tiempoActual <= 120; tiempoActual++) {
            System.out.println("\nMinuto " + tiempoActual + ":");

            boolean llegaNiñoEnMinuto = false;

            if (tiempoActual <= 10) {
                llegaNiñoEnMinuto = random.nextDouble() < 0.5;
            } else if (tiempoActual <= 30) {
                llegaNiñoEnMinuto = tiempoActual % 3 == 1 && random.nextDouble() < 0.5;
            }

            if (tiempoActual <= 30) {
                if (llegaNiñoEnMinuto) {
                    monitor.recibirNiño(new Niño());
                } else {
                    System.out.println("No llega ningún niño.");
                }
            }
    
            // Si hay al menos 5 niños, inicia el juego
            if (!juegoIniciado && monitor.getColaNiños().getSize() >= 5) {
                tiempoTranscurrido = tiempoActual; // Actualiza tiempoTranscurrido
                monitor.iniciarJuego(tiempoTranscurrido);
                juegoIniciado = true;
            }
    
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();
        ludoteca.simularDosHoras();
    }
}