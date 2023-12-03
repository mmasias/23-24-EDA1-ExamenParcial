import java.util.Random;

public class Ludoteca {
    private List niños;
    private Pizarra pizarra;
    private Random rand;
    private Monitor monitor;

    public Ludoteca() {
        niños = new List();
        pizarra = new Pizarra();
        rand = new Random();
        monitor = new Monitor();
    }

    public void iniciarJuego(int duracion) {
        for (int i = 0; i < duracion; i++) {
            if (i < 10) {
                int kids = rand.nextInt(3);
                for (int j = 0; j < kids; j++) {
                    niños.insert(new Niño("Kid " + (i * 3 + j + 1)));
                }
            } else if (i >= 10 && i < 30 && i % 3 == 0 && rand.nextBoolean()) {
                niños.insert(new Niño("Kid " + (i + 1)));
            }

            if (!niños.isEmpty() && niños.size() > 5) {
                jugar();
            }
        }
    }

    private void jugar() {
        System.out.println("Aisha comienza a jugar porque hay más de 5 niños en la fila.");
        pizarra.setMensaje(monitor.generarMensajeAleatorio());
        pizarra.mostrarMensaje();

        Node currentNode = niños.getHead();
        while (currentNode != null) {
            Niño niñoActual = (Niño) currentNode.getValue();
            String message = niñoActual.modificarMensaje(pizarra.getMensaje());
            pizarra.setMensaje(message);

            System.out.println("El niño " + niñoActual.getNombre() + " escribe y muestra el mensaje al siguiente niño: " + message);

            if (currentNode.getNext() == null) {
                System.out.println("El último niño corre y escribe en la pizarra del salón: " + message);
            }

            currentNode = currentNode.getNext();
        }

        niños.removeHead();
    }
}
