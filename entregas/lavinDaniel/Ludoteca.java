package src;

import java.util.Random;
class Ludoteca {
    Cola cola;
    String mensaje;
    Random random;

    public Ludoteca() {
        this.cola = new Cola();
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
        while (tiempo < 120) {

            int llegadaNiños = (tiempo <= 10) ? random.nextInt(3) : (random.nextInt(2) == 0) ? 0 : 1;

            for (int i = 0; i < llegadaNiños; i++) {
                Niño niño = new Niño();
                cola.encolar(niño);
            }

            if (!cola.isEmpty() && cola.inicio != null) {
                System.out.println("Comienza el juego en el minuto " + tiempo);

                while (!cola.isEmpty()) {
                    Niño niñoActual = cola.desencolar();
                    niñoActual.recibirMensaje(mensaje);
                    System.out.println("Niño recibe mensaje: " + niñoActual.pizarra);

                    tiempo += 2;

                    if (!cola.isEmpty()) {
                        cola.inicio.niño.recibirMensaje(niñoActual.pizarra);
                        System.out.println("Niño pasa mensaje: " + cola.inicio.niño.pizarra);
                    }
                }

                tiempo += 2;
                System.out.println("Último niño escribe mensaje en la pizarra: " + mensaje);

                deformarMensaje();
            }

            tiempo++;
        }
    }

    private void deformarMensaje() {
        for (int i = 0; i < mensaje.length(); i++) {
            if (random.nextDouble() < 0.1) {
                char nuevaLetra = (char) (random.nextInt(26) + 'a');
                mensaje = mensaje.substring(0, i) + nuevaLetra + mensaje.substring(i + 1);
            }
        }

        System.out.println("Mensaje deformado: " + mensaje);
    }
}
