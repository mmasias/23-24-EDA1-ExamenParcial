package entregas;

import java.util.Random;

public class Ludoteca implements Monitora {
    private ListaEnlazada<Niño> fila = new ListaEnlazada<>();
    private Pizarra pizarra;
    private Monitora lydia;
    private Monitora aisha;

    public Ludoteca() {
        lydia = new Lydia();
        aisha = new Aisha();
        ((Lydia) lydia).setSiguienteMonitora(aisha);
    }

    @Override
    public void recibirNiño(Niño niño) {
        lydia.recibirNiño(niño);
    }

    @Override
    public void empezarJuego() {
        if (fila.size() > 5) {
            pizarra = new Pizarra("ABCDEFGHIJ");
            System.out.println("Aisha muestra el mensaje inicial en la pizarra: " + pizarra.getMensaje());
            jugar();
        }
    }

    private void jugar() {
        Nodo<Niño> actual = fila.cabeza;
        while (actual != null) {
            System.out.println("Niño " + actual.dato.getNombre() + " recibe el mensaje: " + pizarra.getMensaje());
            actual.dato.recibirMensaje(pizarra);
            actual = actual.siguiente;
        }

        System.out.println("El último niño corre a la pizarra y escribe el mensaje final: " + pizarra.getMensaje());

        fila = new ListaEnlazada<>();
    }

    public void startGames() {
        Random random = new Random();
        int tiempoTotal = 0;

        while (tiempoTotal < 120) {
            System.out.println("Minuto " + tiempoTotal);

            // Verificar si hay llegada de niños
            int niñosLlegados = 0;

            if (tiempoTotal < 10) {
                niñosLlegados = random.nextInt(3) + 1; // Entre 1 y 3 niños por minuto
            } else if (tiempoTotal < 30) {
                int probabilidadLlegada = random.nextInt(100); // Probabilidad de llegada del 50%
                if (probabilidadLlegada < 50) {
                    niñosLlegados = 1;
                }
            } else {
                niñosLlegados = random.nextInt(2) + 1; // Ajustamos para que lleguen entre 1 y 2 niños después del minuto 29
            }

            // Recibir a los niños y pasarlos a la fila
            for (int i = 0; i < niñosLlegados; i++) {
                Niño nuevoNiño = new Niño("Niño " + ((tiempoTotal * 3) + i + 1)); // Ajustamos la generación del nombre
                recibirNiño(nuevoNiño); // Utilizamos el método recibirNiño de Ludoteca
            }

            // Comenzar juego si la fila es lo suficientemente grande
            aisha.empezarJuego();  // Cambiado aisha en lugar de lydia
            tiempoTotal++;
        }
    }
}