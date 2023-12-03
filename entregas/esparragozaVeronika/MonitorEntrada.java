import monitor.Monitor;

public class MonitorEntrada extends Monitor {
    private Cola colaDeNiños;

    public MonitorEntrada(String nombre) {
        super(nombre);
        this.colaDeNiños = new Cola();
    }
    public Cola getColaDeNiños() {
        return colaDeNiños;
    }

    public void recibeNiño(Niño niño, MonitorJuego aisha) {
        colaDeNiños.addNiño(niño);
        if (aisha.getColaDeNiños().size() <= 5) {
            colaDeNiños.removeNiño();
            aisha.recibeNiño(niño);
        }
    }

    @Override
    public void mostrarCola(String nombre) {
        System.out.println(Color.ANSI_BLUE + "Cola de " + nombre + ": " + Color.ANSI_RESET);
        colaDeNiños.listaNiños();
    }
}
