pacakge ludoteca;
public class Niño {

    private Pizarra pizarra;

    public Niño(Pizarra pizarra) {
        this.pizarra = pizarra;
    }

    public void corregirEscucha(String palabra) {
        pizarra.setPalabra(modificarLetras(palabra));
    }

    public String mostrarPalabra() {
        return pizarra.getPalabra();
    }

    public void limpiarPizarra() {
        pizarra.borrarPizarra();
    }

    public static String modificarLetras(String palabra) {
        if (palabra == null || palabra.length() < 3) {
            return palabra;
        }

        StringBuilder palabraModificada = new StringBuilder(palabra);
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int indiceAleatorio = random.nextInt(palabra.length());
            char nuevaLetra = generarLetraAleatoria();
            palabraModificada.setCharAt(indiceAleatorio, nuevaLetra);
        }

        return palabraModificada.toString();
    }

    private static char generarLetraAleatoria() {
        Random random = new Random();
        return (char) ('a' + random.nextInt(26));
    }
}

