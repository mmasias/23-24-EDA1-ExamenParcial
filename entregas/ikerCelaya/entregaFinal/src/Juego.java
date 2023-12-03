package entregas.ikerCelaya.entregaFinal.src;

import java.util.Random;

public class Juego {
    private GenericList<Nino> lidia;
    private GenericList<Nino> aisha;
    private boolean juegoActivo = false;
    private int tiempoJuego = 120;
    private String cadena;
    private int n = 0;

    public Juego() {
        this.lidia = new GenericList<Nino>();
        this.aisha = new GenericList<Nino>();
        cadena = null;
        n = 0;
    }

    public void comenzar() {

        Random r = new Random();
        for (int minutos = 1; minutos <= tiempoJuego; minutos++) {
            if (minutos <= 10) {
                int nNinos = r.nextInt(3);
                for (int i = 0; i < nNinos; i++) {
                    ponerNinoEnEspera(new Nino(String.valueOf(n)));
                    System.out.println("\033[31m" + "Minuto " + minutos + " - Niño " + n + " espera para jugar" + "\u001B[0m");
                    n++;
                }

            } else if (minutos <= 30) {
                if ((minutos - 10) % 3 == 0) {
                    if (r.nextInt(100) < 50) {
                        ponerNinoEnEspera(new Nino(String.valueOf(n)));
                        n++;
                    }
                }

            }

            cargarJugadores();
            if (juegoActivo) {
                jugar(minutos);
            }

        }

    }

    public void ponerNinoEnEspera(Nino nino) {
        this.lidia.insertEnd(nino);
    }

    public void cargarJugadores() {
        if (!juegoActivo && (this.lidia.size() >= 5 || this.aisha.size() > 0)) {
            while (!this.lidia.isEmpty()) {
                Nino nino = this.lidia.deleteFront();
                System.out.println("\033[32m" + "Niño " + nino.getId() + " pasa a jugar" + "\u001B[0m");
                this.aisha.insertEnd(nino);
            }
            juegoActivo = true;
            System.out.println("\033[34m" + "Comienza un nuevo juego" + "\u001B[0m");

        }
    }

    public void jugar(int minuto) {
        if (this.cadena == null) {
            this.cadena = Texto.generarTexto(10);
        }

        if (this.aisha.pasarMensaje(this.cadena, minuto)) {
            System.out.println("\033[34m" + "Termina un juego. Resultados:" + "\u001B[0m");
            this.aisha.listar();
            this.cadena = null;
            this.aisha.resetear();
            juegoActivo = false;
        }
    }
}