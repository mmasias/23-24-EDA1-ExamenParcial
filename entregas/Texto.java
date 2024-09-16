import java.util.Random;

public class Texto {
    private String texto;
    private int n;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Texto(int n) {
        this.texto = "";
        this.n = n;

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int letra = random.nextInt(65, 90);
            this.texto += (char) letra;
        }
    }

    public void cambioDeLetra() {
        Random random = new Random();
        int error = random.nextInt(0, 3);
        char[] frase = texto.toCharArray();
        if (error == 1) {
            int cambio = random.nextInt(0, n);
            char letra = (char) random.nextInt(65, 90);
            frase[cambio] = letra;
            texto = String.valueOf(frase);
        }

        if (error == 2) {
            int cambio = random.nextInt(0, n);
            char letra = (char) random.nextInt(65, 90);
            frase[cambio] = letra;
            texto = String.valueOf(frase);
            cambio = random.nextInt(0, n);
            letra = (char) random.nextInt(65, 90);
            frase[cambio] = letra;
            texto = String.valueOf(frase);
        }
    }
}