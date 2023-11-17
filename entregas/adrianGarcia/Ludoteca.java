import java.util.Random;

public class Ludoteca {
    private GenericList<Nino> lydia;
    private GenericList<Nino> aisha;
    private boolean juegoActivo;
    private int tiempoDeJuego;

    public Ludoteca() {
        lydia = new GenericList<Nino>();
        aisha = new GenericList<Nino>();
        juegoActivo = false;
        tiempoDeJuego = 120;
    }

    public void ComenzarJuego(int minuto) {
        int n = 0;
        Random random = new Random();
        for (minuto = 0; minuto < tiempoDeJuego; minuto++) {
            if (minuto <= 10) {
                int numeroNino = random.nextInt(3);
                for (int j = 0; j < numeroNino; j++) {
                    ninoEnEspera(new Nino(String.valueOf(n)));
                    n++;
                }
            } else if (minuto <= 30) {
                if ((minuto - 20) % 3 == 0) {
                    if (random.nextInt(100) < 50) {
                        ninoEnEspera(new Nino(String.valueOf(n)));
                        n++;
                    }
                }
            } else if (minuto > 30 && !lydia.isEmpty()) {
                aisha.insertEnd(lydia.deleteFront());
            }
            simularTiempo(minuto, n);
            formarEquipo();
            jugar();
        }
    }

    public void ninoEnEspera(Nino nino) {
        this.lydia.insertEnd(nino);
    }

    public void formarEquipo() {
        if (lydia.size() >= 5 && !juegoActivo) {
            while (!lydia.isEmpty()) {
                aisha.insertEnd(lydia.deleteFront());
            }
        }
    }

    public void simularTiempo(int minuto, int numeroNino) {
        System.out.println("------------------------------------------------------");
        System.out.println("MINUTO " + minuto + " - Hay " + numeroNino + " niños");
        System.out.println("En la cola hay: " + lydia.size());
        System.out.println("En juego hay: " + aisha.size());
    }

    public void jugar() {

    }
}
