package entregas.joseSalceda;

import java.util.List;
import java.util.Random;

public class JuegoTelefonoEscacharrado {
    private static final int MIN_NIÑOS_PARA_JUGAR = 5;
    private static boolean juegoEnCurso = false;

    public static boolean puedeJugar(List<Niño> niñosConPizarrin) {
        return !juegoEnCurso && niñosConPizarrin.size() >= MIN_NIÑOS_PARA_JUGAR;
    }

    public static void jugar(List<Niño> niñosConPizarrin, int tiempo) {
        System.out.println("¡Comienza el juego de teléfono escacharrado!");
        juegoEnCurso = true;

        String palabra = generarPalabra();

        System.out.println("Palabra a comunicar: " + palabra);

        for (Niño niño : niñosConPizarrin) {
            jugarConNiño(niño, palabra, tiempo);
        }

        System.out.println("¡Fin del juego de teléfono escacharrado!");
        juegoEnCurso = false;
    }

    private static String generarPalabra() {
        Random random = new Random();
        StringBuilder palabra = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            palabra.append(letra);
        }
        return palabra.toString();
    }

    private static void jugarConNiño(Niño niño, String palabra, int tiempo) {
        System.out.println(niño.getNombre() + " empieza a escribir la palabra...");

        // Simular el tiempo que tarda el niño en escribir la palabra (1 minuto)
        esperar(60);

        System.out.println(niño.getNombre() + " ha escrito: " + palabra);

        if (tiempo % 2 == 0) {  
            System.out.println(niño.getNombre() + " se une a Aisha.");
        }
    }

    private static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
