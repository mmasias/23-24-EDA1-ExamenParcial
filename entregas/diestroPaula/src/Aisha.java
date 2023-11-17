import java.util.Random;

class Aisha {
    void jugar(Cola cola) {
        System.out.println("¡Comienza el juego!");
        limpiarPizarra();

        while (!cola.estaVacia()) {
            Niño niño = cola.desencolar();
            String mensaje = generarMensaje();
            niño.recibirMensaje(new StringBuilder(mensaje));
        }

        Niño ultimoNiño = cola.getUltimoNiño();
        if (ultimoNiño != null) {
            System.out.println("Último niño corre a la pizarra: " + ultimoNiño.getPizarra());
        } else {
            System.out.println("No hay último niño en la cola.");
        }
    }

    void limpiarPizarra() {
        System.out.println("Aisha limpia la pizarra.");
    }

    String generarMensaje() {
        StringBuilder mensaje = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            mensaje.append(obtenerLetraAleatoria());
        }
        System.out.println("Mensaje generado: " + mensaje);
        return mensaje.toString();
    }

    char obtenerLetraAleatoria() {
        Random random = new Random();
        return (char) ('A' + random.nextInt(26));
    }
}
