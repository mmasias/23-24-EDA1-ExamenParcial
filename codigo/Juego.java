package codigo;

import java.util.Random;


public class Juego {
    private GenericList<Crio> lidia;
    private GenericList<Crio> aisha;
    private boolean juegoActivo = false;
    private int tiempoJuego = 120;
    private String cadena;
    private int n = 0;


    public Juego() {
        this.lidia = new GenericList<Crio>();
        this.aisha = new GenericList<Crio>();
        cadena=null;
        n=0;
    }

    public void empezar() {
      
        Random r = new Random();
        for (int minutos = 0; minutos < tiempoJuego; minutos++) {
            if (minutos <= 10) {
                int nCrios = r.nextInt(3);
                for (int i = 0; i < nCrios; i++) {
                    pasarCrioEnEspera(new Crio(String.valueOf(n)));
                    System.out.println("Minuto:" +minutos+" Niño "+n+" espera para jugar");
                    
                    n++;
                }

            } else if (minutos <= 30) {
                if ((minutos - 10) % 3 == 0) {
                    if (r.nextInt(100) < 50) {
                        pasarCrioEnEspera(new Crio(String.valueOf(n)));
                        n++;
                    }
                }

            }

            pasarNinos();
            if(juegoActivo){
                    jugar(minutos);
            }
            
        }



    }

    public void pasarCrioEnEspera(Crio crio) {
        this.lidia.insertEnd(crio);
    }


    public void pasarNinos(){
        if(!juegoActivo && (this.lidia.size()>=5 || this.aisha.size()>0 )){
            while(!this.lidia.isEmpty()){
                  Crio crio = this.lidia.deleteFront();
                  System.out.println("Crio "+crio.getId()+" pasa a jugar");
                  this.aisha.insertEnd(crio);
            }
            juegoActivo=true;
            System.out.println("Comienza un nuevo juego-------------");
          

        }
    }

    public void jugar(int minuto){
        if(this.cadena==null){

            this.cadena=Texto.generarTexto(10);
        }
        if(this.aisha.pasarMensaje(this.cadena,minuto)){
              System.out.println("Termina el juego----------------------------Resultados:");
            this.aisha.listar();
            this.cadena=null;
            this.aisha.resetear();
            juegoActivo=false;
            
        };
        

    }

}