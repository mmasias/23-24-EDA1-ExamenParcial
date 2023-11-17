package entregas.joseSalceda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ludoteca {
    private static int contadorNiños = 0;
    private static int tiempo = 0; 

    public static void main(String[] args) {
        Monitora lydia = new Monitora("Lydia");
        Monitora aisha = new Monitora("Aisha");
        List<Niño> niñosConPizarrin = new ArrayList<>();

        Random random = new Random();


        while (tiempo < 120) {
            System.out.println("Minuto: " + tiempo);


            if (JuegoTelefonoEscacharrado.puedeJugar(niñosConPizarrin)) {
                JuegoTelefonoEscacharrado.jugar(niñosConPizarrin, tiempo);

                niñosConPizarrin.clear();
            } else {

                if (tiempo < 10) {
                    int numNiños = random.nextInt(3);
                    for (int j = 0; j < numNiños; j++) {
                        Niño niño = new Niño("Niño" + (++contadorNiños));
                        lydia.recibirNiño(niño, niñosConPizarrin);
                        aisha.darPizarrin(niño);
                    }
                }

                else if (tiempo < 30) {
                    if (random.nextBoolean()) {
                        Niño niño = new Niño("Niño" + (++contadorNiños));
                        lydia.recibirNiño(niño, niñosConPizarrin);
                        aisha.darPizarrin(niño);
                    }
                }

                tiempo++;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}