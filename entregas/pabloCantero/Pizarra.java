public class Pizarra {
    private String mensaje;

    public Pizarra() {
        mensaje = "";
    }

    public void escribirMensaje(String unMensaje) {
        this.mensaje = unMensaje;
    }

    public String leer() {
        return mensaje;
    }

    public void borrar() {
        mensaje = "";
    }
    public boolean estaVacia() {
        return mensaje.equals("");
    }
    
}
