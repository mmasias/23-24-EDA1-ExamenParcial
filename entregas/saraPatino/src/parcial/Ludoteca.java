package parcial;

import java.util.Random;

class Ludoteca {
    private static final int TOTAL_TIEMPO_MINUTOS = 120;
    private static final int PRIMEROS_10_MINUTOS = 10;
    private static final int SIGUIENTES_20_MINUTOS = 20;

    private Lydia lydia = new Lydia();
    private Random random = new Random();

    public void openLudoteca() {
        int tiempo = 0;
        while (tiempo < TOTAL_TIEMPO_MINUTOS) {
            if (tiempo < PRIMEROS_10_MINUTOS || (tiempo >= PRIMEROS_10_MINUTOS
                    && tiempo < PRIMEROS_10_MINUTOS + SIGUIENTES_20_MINUTOS && random.nextBoolean())) {
                int niñosLlegan = random.nextInt(3);
                for (int i = 0; i < niñosLlegan; i++) {
                    Niño niño = new Niño("Niño " + (lydia.obtenerCola().size() + 1));
                    lydia.recibirNiño(niño);
                }
            }

            if (!lydia.obtenerCola().isEmpty()) {
                play();
            }

            tiempo++;
        }
    }

    private void play() {
        Aisha aisha = new Aisha();
        List <Niño> niñosEnCola = lydia.obtenerCola();

        aisha.inicializer(niñosEnCola);
    }
}