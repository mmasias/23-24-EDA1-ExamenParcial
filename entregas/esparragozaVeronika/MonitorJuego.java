
import monitor.Monitor;

import java.util.Scanner;

public class MonitorJuego extends Monitor {
    private Cola colaDeNiños;
    private Juego juego;
    private final int maximoLetras = 10;
    private final String mensajeInicialDefault = "ABCDEFGHIJ";

    public MonitorJuego(String nombre) {
        super(nombre);
        colaDeNiños = new Cola();
        juego = new Juego(colaDeNiños);
    }

    public void recibeNiño(Niño niño) {
        colaDeNiños.addNiño(niño);
    }

    public Cola getColaDeNiños() {
        return colaDeNiños;
    }

    @Override
    public void mostrarCola(String nombre) {
        System.out.println(Color.ANSI_BLUE + "Cola de " + nombre + ": " + Color.ANSI_RESET);
        colaDeNiños.listaNiños();
    }
    public String getMensajeInicial() {
    Scanner scanner = new Scanner(System.in);
    String mensaje;
        do {
            System.out.println("Ingrese el mensaje inicial: ");
            mensaje = scanner.nextLine();

            if (mensaje.length() == 0) {
                System.out.println("Se colocará el mensaje por defecto: " + mensajeInicialDefault);
                mensaje = mensajeInicialDefault;
            } else if (mensaje.length() > maximoLetras) {
                System.out.println("El mensaje no puede tener más de " + maximoLetras + " letras");
            }

        } while (mensaje.length() > maximoLetras);

        return mensaje;
    }
}