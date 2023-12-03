package core;

import java.util.Random;

public class Niño {

    private Pizarra pizarrin;

    public Niño(Pizarra pizarrin) {
        this.pizarrin = pizarrin;
    }

    public void errorDeEscucha(String palabra){
        pizarrin.setPalabra(cambiarLetras(palabra));
    }

    public String mostrarPalabra(){
        return pizarrin.getPalabra();
    }

    public void limpiarPizarra(){
        pizarrin.borrarPizarra();
    }

    public static String cambiarLetras(String palabra) {
        if (palabra == null || palabra.length() < 3) {
            return palabra;
        }

        Random random = new Random();
        char[] letras = palabra.toCharArray();

        for (int i = 0; i < 3; i++) {
            int indiceAleatorio = random.nextInt(palabra.length());
            char nuevaLetra = generarLetraAleatoria();
            letras[indiceAleatorio] = nuevaLetra;
        }

        return new String(letras);
    }

    private static char generarLetraAleatoria() {
        Random random = new Random();
        return (char) ('a' + random.nextInt(26));
    }

}
