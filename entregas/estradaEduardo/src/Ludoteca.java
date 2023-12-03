import java.util.Arrays;
import java.util.Random;

public class Ludoteca {
    public static void main(String[] args) {
        Ludoteca salaDeJuegos = new Ludoteca();
        salaDeJuegos.jugar();
    }

    private List<String> ninosEnEspera;
    private List<String> colaJuegoActual;
    private int tiempoTotal;
    private int minutosTranscurridos;

    public Ludoteca() {
        ninosEnEspera = new List<>();
        colaJuegoActual = new List<>();
        tiempoTotal = 120;
        minutosTranscurridos = 0;
    }

    private void jugar() {
        while (minutosTranscurridos < tiempoTotal) {

            llegadaNinos();

            if (colaJuegoActual.isEmpty() && ninosEnEspera.size() > 5) {
                iniciarNuevoJuego();
            }

            if (!colaJuegoActual.isEmpty()) {
                jugarJuegoTelefono();
            }
            minutosTranscurridos++;
            imprimirEstado();
        }
    }

    private void llegadaNinos() {
        Random random = new Random();

        if (minutosTranscurridos < 10) {
            int llegadaInicial = random.nextInt(3);
            for (int i = 0; i < llegadaInicial; i++) {
                ninosEnEspera.addEnd("Nino" + (ninosEnEspera.size() + colaJuegoActual.size() + 1));
            }
        } else if (minutosTranscurridos < 30) {
            int tiempoDesdeUltimaLlegada = minutosTranscurridos - 10;
            if (tiempoDesdeUltimaLlegada % 3 == 0) {
                if (random.nextBoolean()) {
                    ninosEnEspera.addEnd("Nino" + (ninosEnEspera.size() + colaJuegoActual.size() + 1));
                }
            }
        }
    }

    private void iniciarNuevoJuego() {
        while (!ninosEnEspera.isEmpty()) {
            colaJuegoActual.addEnd(ninosEnEspera.remove());
        }
        System.out.println("Iniciando un nuevo juego con " + colaJuegoActual.size() + " ninos.");
        simularPasoDeTiempo(1);
    }

    private void jugarJuegoTelefono() {
        System.out.println("Limpiando la pizarra...");

        String mensajeActual = generarMensaje();
        System.out.println("El mensaje es: " + mensajeActual);
        while (!colaJuegoActual.isEmpty() && minutosTranscurridos < tiempoTotal) {
            String ninoActual = colaJuegoActual.remove();
            ninosEnEspera.addEnd(ninoActual);
            System.out.println(ninoActual + " recibe el mensaje: " + mensajeActual);
            mensajeActual = deformarMensaje(mensajeActual);
            simularPasoDeTiempo(1);
        }
        System.out.println("Ultimo nino corre y escribe en la pizarra: " + mensajeActual);
        simularPasoDeTiempo(1);
    }

    private void simularPasoDeTiempo(int minutos) {
        if (minutosTranscurridos < tiempoTotal) {
            minutosTranscurridos++;
            System.out.println(minutos + " minuto de paso de tiempo...");
            imprimirEstado();
            llegadaNinos();
        }

    }

    private void imprimirEstado() {
        System.out.println("--------------------------------------------------");
        System.out.println("Tiempo: " + minutosTranscurridos + " minutos");
        System.out.println("Ninos en espera: " + Arrays.toString(ninosEnEspera.listAll()));
        System.out.println("Ninos en juego actual: " + Arrays.toString(colaJuegoActual.listAll()));
    }

    private String deformarMensaje(String mensaje) {
        Random random = new Random();
        char[] caracteresMensaje = mensaje.toCharArray();

        for (int i = 0; i < random.nextInt(3); i++) {
            int posicion = random.nextInt(caracteresMensaje.length);
            caracteresMensaje[posicion] = generarLetraAleatoria();
        }

        return new String(caracteresMensaje);
    }

    private char generarLetraAleatoria() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a');
    }

    private String generarMensaje() {
        String[] palabrasComunes = { "abecedario", "bienvenida", "computador", "despertar", "escritorio", "fantasioso",
                "guitarista", "historieta", "jardineria" };

        Random random = new Random();
        return palabrasComunes[random.nextInt(palabrasComunes.length)];
    }
}
