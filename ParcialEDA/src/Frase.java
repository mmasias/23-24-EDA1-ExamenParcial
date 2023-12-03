import java.util.Random;

public class Frase {
    private String texto;

    public Frase(int n) {
        Random random = new Random();
        texto = "";
        for (int i = 0; i <n ; i++) {




            char c = (char) random.nextInt(97, 97 + 26);
            texto += c;
        }

    }

    public String getTexto() {
        return texto;
    }
    public void cambioDeLetra(){
        Random random=new Random();
        int letras=random.nextInt(3);
        if (letras==1) {
            int n=random.nextInt(10);
            char c = (char) random.nextInt(97, 97 + 26);
            char []t = texto.toCharArray();
            t[n]=c;
            texto=String.valueOf(t);


        }
        else if (letras==2) {
            int n1=random.nextInt(10);
            int n2=random.nextInt(10);
            char c1 = (char) random.nextInt(97, 97 + 26);
            char c2 = (char) random.nextInt(97, 97 + 26);
            char []t = texto.toCharArray();
            t[n1]=c1;
            t[n2]=c2;
            texto=String.valueOf(t);
        }

    }
}
