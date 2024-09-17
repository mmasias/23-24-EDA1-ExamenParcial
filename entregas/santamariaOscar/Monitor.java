class Monitor {
    private String nombre;

    Monitor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Monitor " + nombre;
    }
}
