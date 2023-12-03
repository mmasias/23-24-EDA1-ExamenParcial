public class Pizarra {
    private String mensaje;

    public void limpiar() {
        mensaje = "";
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void mostrarMensaje() {
        System.out.println(mensaje);
    }
}
