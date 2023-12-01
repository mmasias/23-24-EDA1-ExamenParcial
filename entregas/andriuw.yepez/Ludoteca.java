import java.util.Random;
import java.util.Scanner;

public class Ludoteca {
    int horaInicio = 8;
    int horaCierre = 10;
    int cantidadNinosMinimoDelJuego = 5;
    int cantidadLetrasEnMensaje = 10;

    private final Scanner scanner = new Scanner(System.in);

    public void inicioLudoteca() {
        ColaNinos cola = new ColaNinos();
        ColaNinos listaParalela = new ColaNinos();
        Pizarra pizarra = new Pizarra();
        Tiempo reloj = new Tiempo(horaInicio, 0);
        System.out.println("La ludoteca esta abierta");

        boolean juegoEnCurso = true;

        while (reloj.estaAbierto(horaInicio, horaCierre) && juegoEnCurso) {
            System.out.println("Hora " + reloj.toString());
            llegadaNinos(cola, reloj);
            if (cola.getNinosEnCola() >= cantidadNinosMinimoDelJuego) {
                System.out.println("La cola de ninos esta llena");
                new Monitor(cantidadLetrasEnMensaje, cola, pizarra).comenzarJuego();
                juegoEnCurso = false;
            } else {
                Lydia(cola, listaParalela, reloj);
            }
            reloj.subeTiempo();
        }
    }

    public void Lydia(ColaNinos cola, ColaNinos listaParalela, Tiempo reloj) {
        llegadaNinos(cola, reloj);

        if (cola.getNinosEnCola() < 5) {
            Nino nino = new Nino();
            cola.addNino(nino);
            System.out.println("Hay un nuevo nino");
        } else {
            Nino nino = new Nino();
            listaParalela.addNino(nino);
            System.out.println("Se ha anadido a una lista paralela");
        }
    }

    public void llegadaNinos(ColaNinos cola, Tiempo reloj) {
        if (reloj.getMinuto() <= 10) {
            int cantidadLlegada = new Random().nextInt(3);
            for (int i = 0; i < cantidadLlegada; i++) {
                Nino nino = new Nino();
                cola.addNino(nino);
                System.out.println("Llego un nuevo nino a la cola");
            }
        } else if (reloj.getMinuto() <= 30) {
            int probabilidadLlegada = new Random().nextInt(2);
            if (probabilidadLlegada == 0) {
                Nino nino = new Nino();
                cola.addNino(nino);
                System.out.println("Llego un nuevo nino a la cola");
            }
        }
    }

    public static void main(String args[]) {
        new Ludoteca().inicioLudoteca();
    }
}