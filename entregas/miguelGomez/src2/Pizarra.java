class Pizarra {
    private String texto;

    public Pizarra() {
        this.texto = "";
    }

    public void escribirMensaje(String texto) {
        this.texto = texto;
    }

    public String leerMensaje() {
        return this.texto;
    }

    public void limpiar() {
        this.texto = "";
    }

    public boolean pizarraLimpia() {
        return texto.length() <= 0;
    }
}

