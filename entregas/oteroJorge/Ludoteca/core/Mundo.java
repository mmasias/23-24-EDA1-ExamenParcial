package core;

import java.util.Scanner;

public class Mundo {
    private Aula ludoteca;
    private int tiempoTotal;

    public Mundo(Aula unaLudoteca, int tiempoApertura){
        ludoteca = unaLudoteca;
        tiempoTotal = tiempoApertura;
    }

    private Niño generarNiño() {
        System.out.println("Llega un Niño");
        return new Niño(new Pizarra());
    }
    private boolean llegaNiño() {
        return Math.random() > 0.5;
    }
    
    public void iniciarSimulacion() {
        for (int minutoActual = 0; minutoActual < tiempoTotal; minutoActual++) {
            System.out.println("=".repeat(30));
            System.out.println("Minuto "+minutoActual);
            if (llegaNiño()) {
                Niño niño = generarNiño();
                ludoteca.recibeNiño(niño);
            }
            ludoteca.comprobar();
            ludoteca.estado();
            new Scanner(System.in).nextLine();
        }
    } 
}
