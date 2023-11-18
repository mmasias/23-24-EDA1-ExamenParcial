package Ludoteca.src;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ludoteca {
    
    private  List<Nino> cola = new ArrayList<>();
    private Aisha aisha = new Aisha();
    private int tiempoTotal = 120; 
    private int tiempoTranscurrido = 0;
   


    public void simular() {
        while (tiempoTranscurrido < tiempoTotal) {
            llegadaDeNinos();
            if (!cola.isEmpty()) {
                aisha.jugar(cola);
            }
            tiempoTranscurrido++;
        }
    }

    private void llegadaDeNinos() {
        Random random = new Random();
        if (tiempoTranscurrido < 10) {
            int cantidadNinos = random.nextInt(3);
            for (int i = 0; i < cantidadNinos; i++) {
                Nino nuevoNino = new Nino();
                cola.add(nuevoNino);
            }
        } else if (tiempoTranscurrido < 30) {
            
            if (random.nextDouble() < 0.5) {
                Nino nuevoNino = new Nino();
                cola.add(nuevoNino);
            }
        }
        
    }
}





    

    

