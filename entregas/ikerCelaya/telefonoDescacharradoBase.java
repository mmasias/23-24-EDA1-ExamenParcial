package entregas.ikerCelaya;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class telefonoDescacharradoBase {

    public static void main(String[] args) {
        Queue<String> filaDeNiños = new LinkedList<>();
        Random random = new Random();
        int tiempoLimite = 120;
        String mensajeOriginal = "MENSAJE_10";

        for (int minuto = 0; minuto < tiempoLimite; minuto++) {

            if (minuto < 10) {
                int niñosNuevos = random.nextInt(3); 
                for (int i = 0; i < niñosNuevos; i++) {
                    filaDeNiños.add("Niño " + (filaDeNiños.size() + 1));
                }
            }

            
            if (minuto >= 10 && minuto < 30) {
                if (random.nextDouble() < 0.5) {
                    filaDeNiños.add("Niño " + (filaDeNiños.size() + 1));
                }
            }

            
            if (filaDeNiños.size() > 5) {
                jugar(filaDeNiños, mensajeOriginal);
                filaDeNiños.clear();
            }
        }
    }

    private static void jugar(Queue<String> filaDeNiños, String mensaje) {
        String mensajeActual = mensaje;
        while (!filaDeNiños.isEmpty()) {
            String nino = filaDeNiños.poll();
            
            System.out.println(nino + " recibe y pasa el mensaje: " + mensajeActual);
            
        }
        
        System.out.println("El último niño escribe en la pizarra: " + mensajeActual);
    }
}