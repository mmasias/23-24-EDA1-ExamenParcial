import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Monitor {
    private Queue<Niño> fila;
    private Pizarra pizarra;
    private Random rand;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Monitor() {
        fila = new LinkedList<>();
        pizarra = new Pizarra();
        rand = new Random();
    }

    public void recibirNiño(Niño niño) {
        fila.add(niño);
        if (fila.size() > 5) {
            iniciarJuego();
        }
    }

    private void iniciarJuego() {
        pizarra.limpiar();
        for (Niño niño : fila) {
            niño.limpiarPizarrin();
        }

        String mensaje = generarMensajeAleatorio();
        Niño primerNiño = fila.peek();
        if (primerNiño != null) {
            primerNiño.recibirMensaje(mensaje);
        }
    }

    public String generarMensajeAleatorio() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = rand.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }
        return sb.toString();
    }


}

