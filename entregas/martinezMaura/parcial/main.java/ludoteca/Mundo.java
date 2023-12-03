package ludoteca;

import java.util.Scanner;

public class Mundo {

    private Aula aula;
    private int tiempoTotal;

    public Mundo(Aula ludoteca, int tiempoApertura) {
        this.aula = ludoteca;
        this.tiempoTotal = tiempoApertura;
    }

    public void iniciarSimulacion() {
        for (int minutoActual = 0; minutoActual < tiempoTotal; minutoActual++) {
            System.out.println("=".repeat(30));
            System.out.println("Minuto " + minutoActual);
            if (llegaNiño()) {
                Niño nuevoNiño = generarNiño();
                aula.recibeNiño(nuevoNiño);
            }
            aula.comprobar();
            aula.estado();
            new Scanner(System.in).nextLine();
        }
    }

    private Niño generarNiño() {
        System.out.println("Llega un Niño");
        return new Niño(new Pizarra());
    }

    private boolean llegaNiño() {
        return Math.random() > 0.5;
    }
}
