import java.util.Random;
import java.util.Scanner;

public class Ludoteca {
    int horaInicio = 8;
    int horaCierre = 10;
    int cantidadNiñosMinimoDelJuego = 5;
    int cantidadLetrasEnMensaje = 10;

    private final Scanner scanner = new Scanner(System.in);

    public void inicioLudoteca() {
        ColaNiños cola = new ColaNiños();
        ColaNiños listaParalela = new ColaNiños();
        Pizarra pizarra = new Pizarra();
        Tiempo reloj = new Tiempo(horaInicio, 0);
        System.out.println("La ludoteca está abierta");

        boolean juegoEnCurso = true;

        while (reloj.estaAbierto(horaInicio, horaCierre) && juegoEnCurso) {
            System.out.println("Hora " + reloj.toString());
            llegadaNiños(cola, reloj);
            if (cola.getNiñosEnCola() >= cantidadNiñosMinimoDelJuego) {
                System.out.println("Empieza a jugar");
                new Monitor(cantidadLetrasEnMensaje, cola, pizarra).comenzarJuego();
                juegoEnCurso = false;
            } else {
                Lydia(cola, listaParalela, reloj);
            }
            reloj.subeTiempo();
        }
    }

    public void Lydia(ColaNiños cola, ColaNiños listaParalela, Tiempo reloj) {
        llegadaNiños(cola, reloj);

        if (cola.getNiñosEnCola() < 5) {
            Niño niño = new Niño();
            cola.addNiño(niño);
            System.out.println("Hay un nuevo niño");
        } else {
            Niño niño = new Niño();
            listaParalela.addNiño(niño);
            System.out.println("Se ha añadido a una lista paralela");
        }
    }

    public void llegadaNiños(ColaNiños cola, Tiempo reloj) {
        if (reloj.getMinuto() <= 10) {
            int cantidadLlegada = new Random().nextInt(3);
            for (int i = 0; i < cantidadLlegada; i++) {
                Niño niño = new Niño();
                cola.addNiño(niño);
                System.out.println("Llegó un nuevo niño a la cola");
            }
        } else if (reloj.getMinuto() <= 30) {
            int probabilidadLlegada = new Random().nextInt(2);
            if (probabilidadLlegada == 0) {
                Niño niño = new Niño();
                cola.addNiño(niño);
                System.out.println("Llegó un nuevo niño a la cola");
            }
        }
    }

    public static void main(String args[]) {
        new Ludoteca().inicioLudoteca();
    }
}