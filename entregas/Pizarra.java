package entregas;

import java.util.Random;

public class Pizarra implements MensajeDeformable {
    private String mensaje;

    public Pizarra(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String deformarMensaje(String mensaje) {
        char[] mensajeArray = mensaje.toCharArray();
        Random random = new Random();
        int numCambios = random.nextInt(2) + 1;

        for (int i = 0; i < numCambios; i++) {
            int indice = random.nextInt(mensajeArray.length);
            char nuevaLetra = (char) (random.nextInt(26) + 'a');
            mensajeArray[indice] = nuevaLetra;
        }

        return new String(mensajeArray);
    }
}    