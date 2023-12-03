package Ludoteca.src;

import java.util.List;

class Aisha {
    public void jugar(List<Nino> cola) {
        System.out.println("Limpiando la pizarra del salón...");

        for (int i = 0; i < cola.size(); i++) {
            Nino nino = cola.get(i);

            if (i == 0) {
                System.out.println("Escribiendo un mensaje en el pizarrín y mostrándolo al primer niño: " + nino.getMensaje());
            } else {
                Nino ninoAnterior = cola.get(i - 1);
                nino.recibirMensaje(ninoAnterior.getMensaje());
                System.out.println("El niño " + ninoAnterior.getNombre() + " le muestra el mensaje al niño " + nino.getNombre());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Nino ultimoNino = cola.get(cola.size() - 1);
        System.out.println("El último niño, " + ultimoNino.getNombre() + ", corre a escribir en la pizarra del salón el mensaje que ha recibido: " + ultimoNino.getMensaje());
    }
}
