import java.util.Random;

public class Niño {
    private String nombre;
    private Pizarrin pizarrin;
    private Random rand;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Niño(String nombre) {
        this.nombre = nombre;
        this.pizarrin = new Pizarrin();
        this.rand = new Random();
    }

    public void limpiarPizarrin() {
        pizarrin.limpiar();
    }

    public void recibirMensaje(String mensaje) {
        String mensajeModificado = modificarMensaje(mensaje);
        pizarrin.setMensaje(mensajeModificado);
    }

    public String leerPizarrin() {
        return pizarrin.getMensaje();
    }

    public String modificarMensaje(String mensaje) {
        StringBuilder mensajeModificado = new StringBuilder(mensaje);
        int letrasParaCambiar = 1 + rand.nextInt(2);

        for (int i = 0; i < letrasParaCambiar; i++) {
            int indiceParaCambiar = rand.nextInt(mensaje.length());
            char nuevaLetra = ALPHABET.charAt(rand.nextInt(ALPHABET.length()));
            mensajeModificado.setCharAt(indiceParaCambiar, nuevaLetra);
        }

        return mensajeModificado.toString();
    }

    public String getNombre() {
        return nombre;
    }
}