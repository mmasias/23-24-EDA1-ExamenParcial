package Ludoteca.src;

import java.util.List;

class Aisha {
    public void jugar(List<Nino> cola) {
       
        System.out.println("Limpiando la pizarra...");

        for (Nino nino : cola) {
           
            System.out.println("Mostrando mensaje a un niño: " + nino.getMensaje());
            
            try {
              Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El último niño corre a escribir en la pizarra del salón...");
    }
}
            

        

