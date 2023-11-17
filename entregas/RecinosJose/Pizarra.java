import java.util.Random;
public class Pizarra {
    private String mensaje;

    public Pizarra() {
        this.mensaje = "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void deformarMensaje() {
        Random random = new Random();
        StringBuilder mensajeModificado = new StringBuilder(this.mensaje);

        for (int i = 0; i < this.mensaje.length(); i++) {
            char letra = this.mensaje.charAt(i);

            // Deformar el mensaje cambiando una o dos letras
            if (random.nextDouble() < 0.2) { // 20% de probabilidad de cambiar la letra
                // Cambiar una letra
                letra = (char) (random.nextInt(26) + 'A');

                // Con 50% de probabilidad, cambiar otra letra
                if (random.nextDouble() < 0.5) {
                    int posicionAleatoria = random.nextInt(this.mensaje.length());
                    char nuevaLetra = (char) (random.nextInt(26) + 'A');
                    mensajeModificado.setCharAt(posicionAleatoria, nuevaLetra);
                }
            }

            // Actualizar la letra deformada
            mensajeModificado.setCharAt(i, letra);
        }

        this.mensaje = mensajeModificado.toString();
    }
}