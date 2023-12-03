package RetoTelefono;

public class Niño {
    private String nombre;
    private Pizarra pizarra;
    private String mensajeEnPizarra;
    private String palabraRecibida;

    public Niño(String nombre) {
        this.nombre = nombre;
        this.palabraRecibida = "";
    }

    public String getNombre() {
        return nombre;
    }

    public Pizarra getPizarra() {
        return pizarra;
    }

    public String getPalabraRecibida() {
        return palabraRecibida;
    }

    public void setPalabraRecibida(String palabraRecibida) {
        this.palabraRecibida = palabraRecibida;
    }

    public void recibirPalabra(String palabra) {
        this.palabraRecibida = palabra;
    }

    public void setPizarra(Pizarra pizarra) {
        this.pizarra = pizarra;
    }

    public void limpiarPizarra() {
        mensajeEnPizarra = null;
    }

    public void escribirEnPizarra(String mensaje) {
        mensajeEnPizarra = mensaje;
    }

    public String obtenerMensajeEnPizarra() {
        return mensajeEnPizarra;
    }

    public boolean haEscritoEnPizarra() {

        return pizarra != null && pizarra.haEscritoAlgo();
    }
}
