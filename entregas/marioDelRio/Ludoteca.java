import java.util.Random;

public class Ludoteca {
    private List<Nino> lydia;
    private List<Nino> aisha;
    private boolean juegoActivo;
    int tiempoDeJuego;

    public Ludoteca() {
        lydia = new List<Nino>();
        aisha = new List<Nino>();
        juegoActivo = false;
        tiempoDeJuego = 120;
    }

    public void comenzarJuego() {
        int n = 0;
        Random random = new Random();
        for (int minuto = 0; minuto <= tiempoDeJuego; minuto++) {
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

                aisha.insertFirst(lydia.deleteFront());

            }
            simularTiempo(minuto, n);
            formarEquipo();
            jugar();

        }
    }

    public void ninoEnEspera(Nino nino) {
        this.lydia.insertFirst(nino);
    }

    public void formarEquipo() {
        if (lydia.size() >= 5 && !juegoActivo) {
            while (!lydia.isEmpty()) {
                aisha.insertFirst(lydia.deleteFront());
            }
        }
    }

    public void simularTiempo(int minuto, int numeroNino) {
        System.out.println(" ");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");
        System.out.println("MINUTO: " + minuto + " HAY " + numeroNino + " NIÑOS EN TOTAL EN COLA: " + lydia.size()
                + " EN JUEGO: " + aisha.size());
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");
        System.out.println(" ");       

    }

    public void jugar() {
        Texto texto = new Texto(10);

        for (int f = 0; f < aisha.size(); f++) {
            String frase = texto.getFrase();
            System.out.println(frase);
            texto.cambioDeLetra();
            System.out.println(frase);
        }

    }
}
