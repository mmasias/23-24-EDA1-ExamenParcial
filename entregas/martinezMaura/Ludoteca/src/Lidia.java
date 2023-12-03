package Ludoteca.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class  Lidia {
    private List<Nino> listaNinos;
    private Aisha aisha;

    public  Lidia(Aisha aisha) {
        this.listaNinos = new ArrayList<>();
        this.aisha = aisha;
    }

    public void recibirNino(Nino nino) {
        System.out.println("Lidia recibe al niño: " + nino.getNombre());
        listaNinos.add(nino);

        if (listaNinos.size() >= 5) {
            System.out.println("¡Hay más de 5 niños! ¡Llamando a Aisha para jugar!");
            aisha.jugar(listaNinos);
            listaNinos.clear(); 
        }
    }

    public void llegadaDeNuevosNinos() {
        Random random = new Random();
        int nuevosNinos = random.nextInt(3); 

        for (int i = 0; i < nuevosNinos; i++) {
            Nino nuevoNino = new Nino();
            System.out.println("¡Llega un nuevo niño durante el juego! " + nuevoNino.getNombre());
            listaNinos.add(nuevoNino);
        }
    }
}
