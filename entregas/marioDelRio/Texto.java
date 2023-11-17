import java.util.Random;

public class Texto {
    private String frase;
    private int n;

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Texto(int n) {
        this.frase = "";
        this.n = n;

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int letra = random.nextInt(65, 90);
            this.frase += (char) letra;
        }

    }

    public void cambioDeLetra() {
        Random random = new Random();
        int errorLetra = random.nextInt(0, 3);
        char[] texto = frase.toCharArray();
        if (errorLetra == 1) {
            int cambio = random.nextInt(0,n);
            char letra=(char) random.nextInt(65, 90);
            texto[cambio]= letra;
            frase=String.valueOf(texto);
        }

        if (errorLetra == 2) {
            int cambio = random.nextInt(0,n);
            char letra=(char) random.nextInt(65, 90);
            texto[cambio]= letra;
            frase=String.valueOf(texto);

            cambio = random.nextInt(0,n);
            letra = (char) random.nextInt(65, 90);
            texto[cambio] = letra;
            frase = String.valueOf(texto);
        }
    }

}
