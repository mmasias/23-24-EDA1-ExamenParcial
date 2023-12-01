import java.util.Random;
import java.util.Scanner;

public class Monitor {
    private ColaNinos cola;
    private Pizarra pizarra;
    private int cantidadLetrasEnMensaje;
    private Scanner scanner = new Scanner(System.in);

    public Monitor(int cantidadLetrasEnMensaje, ColaNinos cola, Pizarra pizarra) {
        this.cola = cola;
        this.pizarra = pizarra;
        this.cantidadLetrasEnMensaje = cantidadLetrasEnMensaje;
    }

    public void comenzarJuego() {
        System.out.println("Escribe el primer mensaje para comenzar con el juego");
        String primerMensaje = scanner.nextLine();
        if(primerMensaje.length() > cantidadLetrasEnMensaje){
            System.out.println("El mensaje debe tener " + cantidadLetrasEnMensaje + " letras.");
        } else {

            pizarra.setNuevoMensaje(primerMensaje);

            while (cola.getNinosEnCola() > 0) {
                Nino ninoActual = cola.getPrimerNino();
                String mensajeConErrores = pizarra != null ? pizarra.getNuevoMensaje() : "";
                System.out.println("Nino recibe el mensaje: " + mensajeConErrores);
                escribirMensajeConErrores(ninoActual, mensajeConErrores);
                cola.pasarMensaje();
            }

            if (cola.getNinosEnCola() == 0) {
                System.out.println("Ya no quedan ninos en la cola, se acaba el juego.");
            }
        }
    }

    private void escribirMensajeConErrores(Nino nino, String mensajeConErrores) {
        System.out.println("Nino escribe el mensaje: ");

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