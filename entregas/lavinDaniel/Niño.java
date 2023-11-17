package src;

import java.util.Random;

class Niño {
    String pizarra;

    public Niño() {
        this.pizarra = "";
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
