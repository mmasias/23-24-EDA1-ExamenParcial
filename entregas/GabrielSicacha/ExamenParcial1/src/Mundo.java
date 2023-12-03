import java.util.Scanner;

public class Mundo {
    Ludoteca ludoteca = new Ludoteca();
    int tiempoTotal;

    public Mundo(Ludoteca ludoteca, int tiempoApertura){
        ludoteca = ludoteca;
        tiempoTotal = tiempoApertura;

    }
    public void iniciarSimulacion() {
        for (int minutoActual = 0; minutoActual < tiempoTotal; minutoActual++) {
            System.out.println("=".repeat(30));
            System.out.println("Minuto "+minutoActual);
            if (llegaNiño()) {
                ludoteca.lydia.recibirNiño();
            }
            ludoteca.actualizar();
            new Scanner(System.in).nextLine();
        }
    }

    private boolean llegaNiño() {
        return Math.random() > 0.5;
    }


    public static void main(String[] args) {
        Ludoteca unaLudoteca = new Ludoteca();
         Mundo mundo = new Mundo(unaLudoteca, 120);
        mundo.iniciarSimulacion();
    }

}
