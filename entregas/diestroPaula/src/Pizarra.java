import java.util.Random;

class Pizarra {
    private StringBuilder mensaje;

    public Pizarra() {
        this.mensaje = generarMensajeAleatorio();
    }

    public void limpiar() {
        mensaje.setLength(0);
    }

    public void mostrarMensaje() {
        System.out.println("Mensaje actual en la pizarra: " + mensaje.toString());
    }

    public void recibirMensaje(StringBuilder mensaje) {
        this.mensaje = mensaje;
    }

    public void deformarMensaje() {
        Random random = new Random();
        int posicion = random.nextInt(mensaje.length());
        char nuevaLetra = generarLetraAleatoria();
        mensaje.setCharAt(posicion, nuevaLetra);
    }

    private StringBuilder generarMensajeAleatorio() {
        StringBuilder mensajeAleatorio = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            mensajeAleatorio.append(generarLetraAleatoria());
        }

        return mensajeAleatorio;
    }

    private char generarLetraAleatoria() {
        Random random = new Random();
        char letra = (char) (random.nextInt(26) + 'A');
        return letra;
    }
}

  