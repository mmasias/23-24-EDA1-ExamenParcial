public class Niño {
    private Pizarra pizarra;

    public Niño() {
        this.pizarra = new Pizarra();
    }

    public Pizarra getPizarra() {
        return pizarra;
    }

    public void mostrarMensaje(Niño siguienteNiño) {
        siguienteNiño.getPizarra().setMensaje(this.pizarra.getMensaje());
        siguienteNiño.getPizarra().deformarMensaje();
    }
}