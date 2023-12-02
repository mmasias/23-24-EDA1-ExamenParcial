import java.util.Random;
class Niño {
    private String nombre;
    private Pizarra pizarrin;

    public Niño(String nombre) {
        this.nombre = nombre;
    }

    public void recibirPizarrin(Pizarra pizarra) {
        this.pizarrin = pizarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void recibirMensaje(String mensaje) {
        pizarrin.escribirMensaje(modificarMensaje(mensaje));
        System.out.println("[" + nombre + "] recibe [" + mensaje + "] y ha escrito [" + pizarrin.leerMensaje() + "]");
    }

    private String modificarMensaje(String mensaje) {
        Random random = new Random();
        final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";

        String[] palabras = mensaje.split("\\s+");

        for (int i = 0; i < palabras.length; i++) {
            int numLetrasCambiadas = random.nextInt(3) + 1;
            for (int j = 0; j < numLetrasCambiadas; j++) {
                int indiceAleatorio = random.nextInt(palabras[i].length());
                char letraAleatoria = ALFABETO.charAt(random.nextInt(ALFABETO.length()));
                palabras[i] = palabras[i].substring(0, indiceAleatorio) + letraAleatoria + palabras[i].substring(indiceAleatorio + 1);
            }
        }

        StringBuilder mensajeModificado = new StringBuilder();
        for (String palabra : palabras) {
            mensajeModificado.append(palabra).append(" ");
        }

        return mensajeModificado.toString().trim();
    }

    public String mostrarMensaje() {
        return pizarrin.leerMensaje();
    }

    public void limpiarPizarrin() {
        pizarrin.limpiar();
    }
}