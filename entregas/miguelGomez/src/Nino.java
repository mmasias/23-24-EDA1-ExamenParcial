public class Nino {
    private String pizarrin;
    private String nombre;

    public Nino(String nombre) {
        this.pizarrin = "";
        this.nombre = nombre;
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
        this.pizarrin = mensaje.getContenido();
        System.out.println(nombre + " recibe el mensaje: " + this.pizarrin);
    }

    public void mostrarMensaje(Nino siguienteNino) {
        siguienteNino.recibirMensaje(new Mensaje(this.pizarrin));
        System.out.println(nombre + " muestra el mensaje: " + this.pizarrin);
    }
}
