
import java.util.LinkedList;
import java.util.Queue;

public class Ludoteca {
    private Queue<String> colaDeNinos = new LinkedList<>();
    private static final int TIEMPO_TOTAL = 120; 
    private static final String MENSAJE_INICIAL = "ABCDEFGHIJ"; 

    public void iniciarJuego() {
        int tiempoTranscurrido = 0;
        while (tiempoTranscurrido < TIEMPO_TOTAL) {
            
            if (tiempoTranscurrido < 10) {
                int ninosNuevos = (int) (Math.random() * 3);
                for (int i = 0; i < ninosNuevos; i++) {
                    colaDeNinos.add(MENSAJE_INICIAL);
                }
            } else if (tiempoTranscurrido < 30) {
                if (Math.random() < 0.5) {
                    colaDeNinos.add(MENSAJE_INICIAL);
                }
            }

           
            if (colaDeNinos.size() > 5) {
                String mensaje = colaDeNinos.poll();
                
                int indice = (int) (Math.random() * mensaje.length());
                char letraAleatoria = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
                mensaje = mensaje.substring(0, indice) + letraAleatoria + mensaje.substring(indice + 1);
                System.out.println("Mensaje final: " + mensaje);
            }

            tiempoTranscurrido++;
        }
    }

    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();
        ludoteca.iniciarJuego();
    }
}
