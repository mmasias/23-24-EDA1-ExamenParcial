import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new List();
        Random random = new Random();

        int jugadoresIniciales = 5;
        int tiempoSimulacion = 2 * 60;
        int minute = 0;
        int probFalloLin = 10;
        boolean sistemaAutomaticoPalabras = true;
        String input = "";
        String[] palabras = {
                "abecedario", "multicolor", "acantilado", "programado", "defectuoso",
                "accionista", "desarrollo", "entrenador", "financiero", "interrogar",
                "matematico", "decorativo"
        };

        // Inicializar jugadores iniciales
        for (int i = 0; i < jugadoresIniciales; i++) {
            list.insertEnd(new Pizarra(""));
        }

        // Manejar entrada manual de palabras
        if (!sistemaAutomaticoPalabras) {
            System.out.println("Introduce una palabra de 10 letras:");
            input = scanner.nextLine();
            if (input.length() != 10) {
                System.out.println("La palabra debe tener exactamente 10 letras.");
                scanner.close();
                return;
            }
        }

        // Simulación
        Pizarra pizarraCentral = new Pizarra("");
        while (minute < tiempoSimulacion) {
            if (sistemaAutomaticoPalabras) {
                input = palabras[random.nextInt(palabras.length)];
            }

            pizarraCentral.setPalabra(input);

            // Añadir nuevos jugadores
            manejarNuevosJugadores(minute, list, random);

            // Jugar ronda
            System.out.println("\n- Inicia nueva ronda con " + list.size() + " jugadores.");
            for (int i = 0; i < list.size(); i++) {
                minute++;
                if (minute >= tiempoSimulacion) {
                    System.out.println("La ludoteca ha cerrado.");
                    break;
                }
                Jugador jugadorActual = list.getNodeAt(i);
                jugadorActual.jugar(pizarraCentral.getPalabra(), probFalloLin * (i + 1));
                String modifiedWord = pizarraCentral.getPalabra();
                System.out.println("Minuto " + minute + " - Palabra en posición " + i + ": " + modifiedWord);
            }
        }

        scanner.close();
    }

    private static void manejarNuevosJugadores(int minute, List list, Random random) {
        if (minute > 0 && minute < 10) {
            int newPeople = random.nextInt(3);
            for (int i = 0; i < newPeople; i++) {
                list.insertEnd(new Pizarra(""));
                System.out.println("> Otro niño se une al juego.");
            }
        } else if (minute >= 10 && minute < 30 && minute % 3 == 0 && random.nextBoolean()) {
            list.insertEnd(new Pizarra(""));
            System.out.println("> Otro niño se une al juego.");
        }
    }
}
