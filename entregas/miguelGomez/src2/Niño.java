import java.util.Random;
class Niño {
    private String nombre;
    private Pizarra pizarraniño;

    public Niño(String nombre) {
        this.nombre = nombre;
    }

    public void recibirPizarrin(Pizarra pizarra) {
        this.pizarraniño = pizarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void recibirMensaje(String mensaje) {
        pizarraniño.escribirMensaje(modificarMensaje(mensaje));
        System.out.println("[" + nombre + "] recibe [" + mensaje + "] y ha escrito [" + pizarraniño.leerMensaje() + "]");        
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
        return pizarraniño.leerMensaje();
    }

    public void limpiarPizarrin() {
        pizarraniño.limpiar();
    }
}
