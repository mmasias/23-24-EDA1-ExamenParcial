public class Pizarra {
    private String mensaje;

    public Pizarra() {
        mensaje = "";
    }

    public void escribirMensaje(String nuevoMensaje) {
        mensaje = nuevoMensaje;
    }

    public String leerMensaje() {
        return mensaje;
    }

    public void limpiar() {
        mensaje = "";
    }
}