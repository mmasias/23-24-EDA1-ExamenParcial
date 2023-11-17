import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ludoteca {
    public static void abrirLudoteca(List<Nino> ninos, List<String> mensajes) {
        List<Nino> cola = new ArrayList<>();
        Random random = new Random();
        int cantidadMinimaParaComenzar = 5;

        for (int tiempo = 0; tiempo < 120; tiempo++) {
            if (tiempo < 10 || (tiempo >= 10 && tiempo < 30 && (random.nextDouble() < 0.5 || tiempo % 3 == 0))) {
                int llegadaNinos = tiempo < 10 ? random.nextInt(3) : (random.nextDouble() < 0.5 ? 1 : 0);

                for (int i = 0; i < llegadaNinos; i++) {
                    Nino nuevoNino = new Nino("Niño" + (ninos.size() + 1), new Pizarra());
                    System.out.println("Llega " + nuevoNino.getNombre());
                    ninos.add(nuevoNino);

                    cola.add(nuevoNino);

                    if (cola.size() >= cantidadMinimaParaComenzar) {
                        System.out.println("Comienza el juego con " + cola.size() + " niños en cola:");
                        Aisha.jugar(new ArrayList<>(cola), mensajes);

                        // Limpiar la cola después de jugar
                        cola.clear();
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!cola.isEmpty()) {
            System.out.println("Comienza el juego con " + cola.size() + " niños en cola:");
            Aisha.jugar(new ArrayList<>(cola), mensajes);
        }
    }
}