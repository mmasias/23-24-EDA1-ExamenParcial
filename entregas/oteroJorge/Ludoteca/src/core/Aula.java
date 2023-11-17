package core;
import java.util.Scanner;

public class Aula {
    int horaDeApertura, horaDeCierre;
    boolean estaAbierta;
    int hora;
    final int unMinuto = 1;
    Juego juego;
    Cola cola;
    Cola colaGeneral;
    public Aula() {
        this.horaDeApertura = 1;
        this.horaDeCierre = 120;
        hora = horaDeApertura;
        estaAbierta = hora >= horaDeApertura ? true : false;
        cola = new Cola();
        juego = new Juego(cola);
        colaGeneral = new Cola();
    }
    public void aJugar() {
        while (estaAbierta) {

            System.out.println("Minuto: " + hora);
            int cuantosNiños = 0;

            if (hora <= 10) {
                cuantosNiños = (int)(Math.random() * (2 - 0 + 1)) + 0;
            } else if (hora <= 30) {
                cuantosNiños = (Math.random() < 0.5) ? 1 : 0;
            }

            for (int i = 0; i < cuantosNiños; i++) {
                colaGeneral.addNiño(new Niños(""));
                System.out.println("Se ha añadido un niño a la cola");
            }
            if(!juego.estaEnJuego()){
                System.out.println("Se ha añadido una cola de niños");
                cola = colaGeneral;
                juego.setMiCola(cola);
            }

            juego.empiezaElJuego();

            estaAbierta = hora < horaDeCierre;

            hora += unMinuto;
            System.out.println(colaGeneral.toString());
            new Scanner(System.in).nextLine();
        }
    }

}
