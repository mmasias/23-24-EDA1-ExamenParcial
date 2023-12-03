import java.util.Random;

public class Niño {
    private String nombre;
    private Pizarra pizarrin;

    public Niño(String nombre) {
        this.nombre = nombre;
        pizarrin = new Pizarra();
    }

    public void recibirMensaje(String mensaje) {
        pizarrin.escribirMensaje(modificarMensaje(mensaje));
        System.out.println("[" + nombre + "] recibe [" + mensaje + "] y escribe [" + pizarrin.leerMensaje() + "]");
    }

    private String modificarMensaje(String mensaje) {
        Random random = new Random();
        char[] caracteres = mensaje.toCharArray();
        for (int i = 0; i < 2; i++) {
            int indice = random.nextInt(caracteres.length);
            char letra = (char)(random.nextInt(26) + 'a');
            caracteres[indice] = letra;
        }
        return new String(caracteres);
    }

    public String mostrarMensaje() {
        return pizarrin.leerMensaje();
    }

    public void limpiarPizarrin() {
        pizarrin.limpiar();
    }
    public String getNombre() {
        return nombre;
    }
}