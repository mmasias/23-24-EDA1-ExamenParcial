package entregas.propuestaFinal;

import java.util.Random;

public class Niño {
    String nombre;
    String pizarra;

    public Niño() {
        this.nombre = generarNombre();
        this.pizarra = "";
    }

    private String generarNombre() {
        Random random = new Random();
        char letra1 = (char) (random.nextInt(26) + 'A');
        char letra2 = (char) (random.nextInt(26) + 'a');
        return letra1 + "" + letra2;
    }

    public void recibirMensaje(String mensaje) {
        Random random = new Random();
        for (int i = 0; i < mensaje.length(); i++) {
            if (random.nextDouble() < 0.1) {
                char nuevaLetra = (char) (random.nextInt(26) + 'a');
                this.pizarra += nuevaLetra;
            } else {
                this.pizarra += mensaje.charAt(i);
            }
        }
    }
}