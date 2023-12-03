
import java.util.Random;
class LudotecaGame {
    private ListaNiños fila;
    private ListaNiños filaEspera;
    private Monitor lydia;
    private Monitor aisha;
    private Random random;

    LudotecaGame() {
        fila = new ListaNiños();
        filaEspera = new ListaNiños();
        lydia = new Monitor("Lydia");
        aisha = new Monitor("Aisha");
        random = new Random();
    }

    void iniciarJuego() {

        for (int tiempo = 0; tiempo < 120; tiempo++) {

            int numNiños = 0;
            if (tiempo < 10) {
                numNiños = random.nextInt(3); // Entre 0 y 2 niños por minuto
            } else if (tiempo < 30) {
                if (random.nextDouble() < 0.5) {
                    numNiños = 1; // 50% de probabilidad de llegar un niño cada 3 minutos
                }
            }

            for (int i = 0; i < numNiños; i++) {
                if (tiempo < 30) {

                    Nino niñoNuevo = new Nino();
                    fila.agregarNiño(niñoNuevo);
                    System.out.println("Nuevo niño en la fila: " + niñoNuevo);
                } else {
                    Nino niñoNuevo = new Nino();
                    filaEspera.agregarNiño(niñoNuevo);
                    System.out.println("Nuevo niño en la fila de espera: " + niñoNuevo);
                }
            }

            if (fila.obtenerCantidadNiños() + filaEspera.obtenerCantidadNiños() > 5) {
                jugar();
            }
        }
    }

    private void jugar() {
        System.out.println("Comienza el juego!");
        Pizarrin mensajeOriginal = new Pizarrin(generarMensaje());
        System.out.println("Mensaje original: " + mensajeOriginal);

        NodoNino nodoActual = fila.getPrimero();
        while (nodoActual != null) {
            Nino niñoActual = nodoActual.getNiño();
            Pizarrin mensajeDeformado = new Pizarrin(deformarMensaje(mensajeOriginal.getContenido()));
            System.out.println(niñoActual + " recibe mensaje: " + mensajeDeformado);
            niñoActual.anotarMensaje(mensajeDeformado);
            nodoActual = nodoActual.getSiguiente();
        }

        Nino ultimoNiño = fila.getUltimo().getNiño();
        ultimoNiño.escribirEnPizarra();
        System.out.println("Fin del juego!");

        while (filaEspera.obtenerCantidadNiños() > 0) {
            Nino niñoEnEspera = filaEspera.removerPrimero();
            fila.agregarNiño(niñoEnEspera);
            System.out.println(niñoEnEspera + " se une a la fila para el próximo juego.");
        }
        fila.limpiarLista();
    }

    private String generarMensaje() {
        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            mensaje.append(letra);
        }
        return mensaje.toString();
    }

    private String deformarMensaje(String mensaje) {
        char[] mensajeArray = mensaje.toCharArray();
        int cambios = random.nextInt(3); // Puede cambiar 0, 1 o 2 letras
        for (int i = 0; i < cambios; i++) {
            int posicionCambio = random.nextInt(10); // Posición aleatoria en el mensaje
            char nuevaLetra = (char) (random.nextInt(26) + 'A');
            mensajeArray[posicionCambio] = nuevaLetra;
        }
        return new String(mensajeArray);
    }
}
