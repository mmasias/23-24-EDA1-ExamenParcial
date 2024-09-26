package entregas.ikerCelaya;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class telefonoDescacharrado {

    public static void main(String[] args) {
        Queue<String> filaDeNiños = new LinkedList<>();
        Random random = new Random();
        int tiempoLimite = 120;
        String mensajeOriginal = "MENSAJE_10";

        for (int minuto = 0; minuto < tiempoLimite; minuto++) {
            if (minuto < 10) {
                int ninosNuevos = random.nextInt(3);
                for (int i = 0; i < ninosNuevos; i++) {
                    filaDeNiños.add("Niño " + (filaDeNiños.size() + 1));
                }
            }

            if (minuto >= 10 && minuto < 30) {
                if (random.nextDouble() < 0.5) {
                    filaDeNiños.add("Niño " + (filaDeNiños.size() + 1));
                }
            }

            if (filaDeNiños.size() > 5) {
                jugar(filaDeNiños, mensajeOriginal, random);
                filaDeNiños.clear();
            }
        }
    }

    private static void jugar(Queue<String> filaDeNiños, String mensaje, Random random) {
        String mensajeActual = mensaje;
        while (!filaDeNiños.isEmpty()) {
            String niño = filaDeNiños.poll();
            mensajeActual = alterarMensaje(mensajeActual, random);
            System.out.println(niño + " recibe y pasa el mensaje: " + mensajeActual);
        }
        System.out.println("El último niño escribe en la pizarra: " + mensajeActual);
    }

    private static String alterarMensaje(String mensaje, Random random) {
        char[] caracteres = mensaje.toCharArray();
        int cambios = random.nextInt(3);

        for (int i = 0; i < cambios; i++) {
            int indiceParaCambiar = random.nextInt(mensaje.length());
            char nuevoCaracter = (char) ('A' + random.nextInt(26));
            caracteres[indiceParaCambiar] = nuevoCaracter;
        }

        return new String(caracteres);
    }
}