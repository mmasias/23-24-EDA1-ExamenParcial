import java.util.Random;

public class Nino {
    private String nombre;
    private Pizarra pizarra;

    public Nino(String nombre, Pizarra pizarra) {
        this.nombre = nombre;
        this.pizarra = pizarra;
    }

    public String getNombre() {
        return nombre;
    }

    public Pizarra getPizarra() {
        return pizarra;
    }

    public void recibirMensaje(String mensaje) {
        pizarra.setMensaje(mensaje);
    }

    public void pasarMensaje(Nino siguienteNino) {
        String mensajeOriginal = this.pizarra.getMensaje();
        char[] mensajeModificado = mensajeOriginal.toCharArray();

        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            int posicionCambio = random.nextInt(10);
            mensajeModificado[posicionCambio] = (char) ('A' + random.nextInt(26));
        }

        String mensajeFinal = new String(mensajeModificado);
        siguienteNino.recibirMensaje(mensajeFinal);
    }

    public void pasarMensajeAfectado(Pizarra pizarra) {
        this.recibirMensaje(pizarra.getMensaje());
    }
}