
import java.util.Random;

public class Juego {
    private GenericList<Crio> lidia; // recibe a los niños
    private GenericList<Crio> aisha; // juega con los niños
    private boolean juegoActivo = false;
    private int tiempoJuego = 121;
    private String cadena;
    private int n = 1;


    public Juego() {
        this.lidia = new GenericList<Crio>();
        this.aisha = new GenericList<Crio>();
        cadena = null;
        n = 1;
    }

    public void comenzar() {

        Random r = new Random();
        for (int minutos = 1; minutos < tiempoJuego; minutos++) {
            if (minutos <= 10) {
                int nCrios = r.nextInt(3);
                for (int i = 0; i < nCrios; i++) {
                    ponerCrioEnEspera(new Crio(String.valueOf(n)));
                    System.out.println("Minuto:" + minutos + " Niño " + n + " espera para jugar");
                    n++;
                }

            } else if (minutos <= 30) {
                if (( minutos - 10 ) % 3 == 0) {
                    if (r.nextInt(100) < 50) {
                        ponerCrioEnEspera(new Crio(String.valueOf(n)));
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

    public void ponerCrioEnEspera(Crio crio) {
        this.lidia.insertEnd(crio);
    }


    public void cargarJugadores() {
        if (!juegoActivo && ( this.lidia.size() >= 5 || this.aisha.size() > 0 )) {
            while (!this.lidia.isEmpty()) {
                Crio crio = this.lidia.deleteFront();
                System.out.println("Crio " + crio.getId() + " pasa a jugar");
                this.aisha.insertEnd(crio);
            }
            juegoActivo = true;
            System.out.println("Comienza un nuevo juego-------------");


        }
    }

    public void jugar(int minuto) {
        if (this.cadena == null) {
            this.cadena = Texto.generarTexto(10);
        }
        if (this.aisha.pasarMensaje(this.cadena, minuto)) {
            System.out.println("Termina un juego-------------Resultados:");
            this.aisha.listar();
            this.cadena = null;
            this.aisha.resetear();
            juegoActivo = false;

        }
    }
}