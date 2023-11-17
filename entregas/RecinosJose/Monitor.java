import java.util.Random;

public class Monitor {
    private ColaNiños colaNiños;

    public Monitor() {
        this.colaNiños = new ColaNiños();
    }

    public ColaNiños getColaNiños() {
        return colaNiños;
    }

    public void recibirNiño(Niño niño) {
        colaNiños.agregarNiño(niño);
        System.out.println("Ha llegado un niño a la ludoteca.");
        if (colaNiños.getSize() >= 5) {
            iniciarJuego(0); // Inicia el juego con tiempoTranscurrido 0
        }
    }

    public void iniciarJuego(int tiempoTranscurrido) {
        System.out.println("\nComienza el juego de teléfono descacharrado.");
        int duracionJuego = 5; // Duración del juego en minutos
        for (int minuto = tiempoTranscurrido; minuto < tiempoTranscurrido + duracionJuego; minuto++) {
            System.out.println("Minuto " + (minuto) + ":");
            while (!colaNiños.isEmpty()) {
                Niño primerNiño = colaNiños.obtenerSiguienteNiño();
                String mensaje = generarMensaje();
                primerNiño.getPizarra().setMensaje(mensaje);
                System.out.println("El primer niño ha recibido el mensaje: " + mensaje);

                Niño niñoActual = primerNiño;
                while (!colaNiños.isEmpty()) {
                    Niño siguienteNiño = colaNiños.obtenerSiguienteNiño();
                    if (siguienteNiño != null) {
                        niñoActual.mostrarMensaje(siguienteNiño);
                        System.out.println("El niño actual mostró el mensaje al siguiente niño: "
                                + siguienteNiño.getPizarra().getMensaje());
                    } else {
                        System.out.println("No hay más niños para continuar el juego.");
                    }
                    niñoActual = siguienteNiño;
                }

                System.out.println("El último niño corre a la pizarra para escribir el mensaje: "
                        + niñoActual.getPizarra().getMensaje());
            }
            System.out.println("Fin del juego de teléfono descacharrado.");
        }
    }

    private String generarMensaje() {
        StringBuilder mensaje = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            mensaje.append(letra);
        }
        return mensaje.toString();
    }
}