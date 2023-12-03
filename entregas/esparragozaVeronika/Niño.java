import java.util.Random;

class Niño {
    private String nombre;
    private Pizarra pizarrin;

    public Niño(String nombre) {
        this.nombre = nombre;
        this.pizarrin = new Pizarra();
    }
    public String getNombre() {
        return nombre;
    }

    public void recibirMensaje(String mensaje) {
        pizarrin.escribirMensaje(modificarMensaje(mensaje));
        System.out.println(Color.ANSI_GREEN + nombre + " " + Color.ANSI_RESET + "recibe" + Color.ANSI_GREEN + " '" + mensaje + "'" + Color.ANSI_RESET + " y ha escrito " + Color.ANSI_GREEN + "'" + pizarrin.leerMensaje() + "'" + Color.ANSI_RESET);
    }
    private String modificarMensaje(String mensaje) {
        Random random = new Random();
        final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 2; i++) {
            int indiceAleatorio = random.nextInt(mensaje.length());
            char letraAleatoria = ALFABETO.charAt(random.nextInt(ALFABETO.length()));

            mensaje = mensaje.substring(0, indiceAleatorio) + letraAleatoria + mensaje.substring(indiceAleatorio + 1);
        }
        return mensaje;
    }

    public String mostrarMensaje() {
        return pizarrin.leerMensaje();
    }

    public void limpiarPizarra() {
        if (pizarrin != null) {
            pizarrin.limpiar();
        }
    }
}
