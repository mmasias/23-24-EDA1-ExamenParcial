import java.util.Random;
import java.util.Scanner;

public class Monitor {
    private ColaNiños cola;
    private Pizarra pizarra;
    private int cantidadLetrasEnMensaje;
    private Scanner scanner = new Scanner(System.in);

    public Monitor(int cantidadLetrasEnMensaje, ColaNiños cola, Pizarra pizarra) {
        this.cola = cola;
        this.pizarra = pizarra;
        this.cantidadLetrasEnMensaje = cantidadLetrasEnMensaje;
    }

    public void comenzarJuego() {
        System.out.println("Ingresa el primer mensaje:");
        String primerMensaje = scanner.nextLine();
        if(primerMensaje.length() > cantidadLetrasEnMensaje){
            System.out.println("El mensaje debe tener " + cantidadLetrasEnMensaje + " letras.");
        } else {
            System.out.println("Este fue tu mensaje: " + primerMensaje);

            pizarra.setNuevoMensaje(primerMensaje);

            while (cola.getNiñosEnCola() > 0) {
                Niño niñoActual = cola.getPrimerNiño();
                String mensajeConErrores = pizarra != null ? pizarra.getNuevoMensaje() : "";
                System.out.println("Niño recibió el mensaje con errores: " + mensajeConErrores);
                escribirMensajeConErrores(niñoActual, mensajeConErrores);
                cola.pasarMensaje();
            }

            if (cola.getNiñosEnCola() == 0) {
                System.out.println("Se han agotado los niños en la cola. Fin del juego.");
            }
        }
    }

    private void escribirMensajeConErrores(Niño niño, String mensajeConErrores) {
        System.out.println("Niño escribió su propio mensaje con errores:");

        if (mensajeConErrores == null || mensajeConErrores.isEmpty()) {
            System.out.println("No hay mensaje con errores disponible.");
            return;
        }

        String nuevoMensajeConErrores = generarMensajeConErrores(mensajeConErrores);
        System.out.println(nuevoMensajeConErrores);
        if (pizarra != null) {
            pizarra.setNuevoMensaje(nuevoMensajeConErrores);
        }
    }

    private String generarMensajeConErrores(String mensaje) {
        char[] mensajeConErrores = mensaje.toCharArray();

        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int indiceError = random.nextInt(mensaje.length());
            char letraError = generarLetraAleatoria();
            mensajeConErrores[indiceError] = letraError;
        }

        return new String(mensajeConErrores);
    }

    private char generarLetraAleatoria() {
        Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'a');
        return letra;
    }

}
