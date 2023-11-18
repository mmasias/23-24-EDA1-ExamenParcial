package Ludoteca.src;

import java.util.Random;

public class Nino {
    private String mensaje;

    public Nino() {
        generarMensajeAleatorio();
    }

    public String getMensaje() {
        return mensaje;
    }

    private void generarMensajeAleatorio() {
        
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char letra = (char) (random.nextInt(26) + 'a');
            builder.append(letra);
        }
        mensaje = builder.toString();
    }

    public String getNombre() {
        return null;
    }
}

