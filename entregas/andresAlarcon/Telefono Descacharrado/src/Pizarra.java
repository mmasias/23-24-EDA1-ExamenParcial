public class Pizarra {
    private String mensaje;

    public Pizarra() {
        this.mensaje = "";
    }

    public void limpiar() {
        this.mensaje = "";
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}