package propuestaFinal;

import java.util.Random;

public class Ludoteca {
    Fila cola;
    String mensaje;
    Random random;

    public Ludoteca() {
        this.cola = new Fila();
        this.random = new Random();
        this.mensaje = generarMensaje();
    }

    private String generarMensaje() {
        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char letra = (char) (random.nextInt(26) + 'a');
            mensaje.append(letra);
        }
        return mensaje.toString();
    }

    public void simular() {
        int tiempo = 0;
        while (tiempo < 121) {
            int llegadaNiños = (tiempo <= 10) ? random.nextInt(3) : (random.nextInt(2) == 0) ? 0 : 1;

            for (int i = 0; i < llegadaNiños; i++) {
                Niño niño = new Niño();
                cola.enfilar(niño);
                System.out.println("Llega " + niño.nombre);
            }

            if (!cola.isEmpty()) {
                System.out.println("==============================");
                System.out.println("Minuto " + tiempo);
                System.out.println("Comienza el juego");

                // Agregamos la impresión del estado de Lydia y Aisha
                System.out.println("> Lydia --> " + imprimirEstadoLydia());
                System.out.println("> Aisha --> " + imprimirEstadoAisha());

                jugar();
                deformarMensaje();
            }

            tiempo++;
        }
    }

    // Función para imprimir el estado de Lydia
    private String imprimirEstadoLydia() {
        StringBuilder estado = new StringBuilder();
        Nodo actual = cola.inicio;

        while (actual != null) {
            estado.append(actual.niño.nombre).append(" / ");
            actual = actual.siguiente;
        }

        return estado.toString();
    }

    // Función para imprimir el estado de Aisha
    private String imprimirEstadoAisha() {
        StringBuilder estado = new StringBuilder();

        Nodo actual = cola.inicio;

        while (actual != null) {
            estado.append(actual.niño.nombre).append(" / ");
            actual = actual.siguiente;
        }

        return estado.toString();
    }

    private void jugar() {
        Niño niñoActual = null;
        while (!cola.isEmpty()) {
            niñoActual = cola.desenfilar();
            niñoActual.recibirMensaje(mensaje);
            System.out.println("[" + niñoActual.nombre + "] recibe [" + mensaje + "] y ha escrito [" + niñoActual.pizarra + "]");

            if (!cola.isEmpty()) {
                cola.inicio.niño.recibirMensaje(niñoActual.pizarra);
                System.out.println("[" + cola.inicio.niño.nombre + "] pasa mensaje: [" + cola.inicio.niño.pizarra + "]");
            }
        }

        System.out.println("Último niño [" + niñoActual.nombre + "] escribe mensaje en la pizarra: [" + mensaje + "]");
    }

    private void deformarMensaje() {
        for (int i = 0; i < mensaje.length(); i++) {
            if (random.nextDouble() < 0.1) {
                char nuevaLetra = (char) (random.nextInt(26) + 'a');
                mensaje = mensaje.substring(0, i) + nuevaLetra + mensaje.substring(i + 1);
            }
        }

        System.out.println("Mensaje deformado: [" + mensaje + "]");
    }
}