public class Pizarra {
    private String mensaje;
    private boolean limpia;

    public Pizarra() {
        this.mensaje = "";
        this.limpia = true;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return this.mensaje;
    }

    public void limpiar(){
        this.mensaje = "";
        this.limpia = true;
    }

    public boolean estaLimpia(){
        return limpia;
    }
}
