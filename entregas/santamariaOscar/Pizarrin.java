class Pizarrin {
    private String contenido;

    Pizarrin(String contenido) {
        this.contenido = contenido;
    }

    String getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return contenido;
    }
}
