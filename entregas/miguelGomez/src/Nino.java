public class Nino {
    private String nombre;
    private String pizarrin;

    public Nino(String nombre) {
        this.nombre = nombre;
        this.pizarrin = "";
    }

    public String getNombre() {
        return nombre;
    }

    public String getPizarrin() {
        return pizarrin;
    }

    public void setPizarrin(String pizarrin) {
        this.pizarrin = pizarrin;
    }

    public void recibirMensaje(Mensaje mensaje) {
        System.out.println(nombre + " recibe el mensaje: " + mensaje.getContenido());
        pizarrin = mensaje.getContenido();
    }

    public void mostrarMensaje(Nino ninoAnterior) {
        System.out.println(nombre + " muestra el mensaje: " + ninoAnterior.getPizarrin());
        pizarrin = ninoAnterior.getPizarrin();
    }
}
