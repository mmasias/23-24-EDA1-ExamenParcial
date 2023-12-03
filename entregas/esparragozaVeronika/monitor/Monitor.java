package monitor;

public abstract class Monitor {
    private String nombre;

    public Monitor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarCola(String nombre);
}