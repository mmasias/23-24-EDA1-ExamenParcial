public class Nino {
    private String pizarrin;

    public Nino() {
        this.pizarrin = "";
    }

    public String getPizarrin() {
        return pizarrin;
    }

    public void setPizarrin(String pizarrin) {
        this.pizarrin = pizarrin;
    }

    public void recibirMensaje(Mensaje mensaje) {
        this.pizarrin = Mensaje.getContenido();
    }

    public void mostrarMensaje(Nino siguienteNino) {
        siguienteNino.recibirMensaje(new Mensaje(this.pizarrin));
    }
}

