package codigo;

import java.util.Random;

public class Texto {
    private static char generarLetra() {
        Random r = new Random();
        return (char) r.nextInt(65, 91);
    }
    public static String generarTexto(int n) {
        String texto = "";
        for (int i = 0; i < n; i++) {
            texto += generarLetra();
        }
        return texto;

    }



    public static String cambiarLetra(String texto) {

        char[] frase = texto.toCharArray();
        Random r = new Random();
        int nLetras = r.nextInt(0, 3);
        int pos = 0;
        if (nLetras == 1) {
            pos = r.nextInt(texto.length());
            frase[pos] = generarLetra();

        }
        if (nLetras == 2) {
            pos = r.nextInt(texto.length());
            frase[pos] = generarLetra();
            pos = r.nextInt(texto.length());
            frase[pos] = generarLetra();

        }
        return String.valueOf(frase);

    }


}