import java.util.Random;


public class Juego {
    private GenericList<Niño> lidia; // recibe a los niños
    private GenericList<Niño> aisha; // juega con los niños
    private boolean juegoActivo = false;
    private int tiempoJuego = 120;
    private String cadena;
    private int n = 0; // numero de niños
    String black = "\033[30m";
    String red = "\033[31m";
    String green = "\033[32m";
    String yellow = "\033[33m";
    String blue = "\033[34m";
    String purple = "\033[35m";
    String cyan = "\033[36m";
    String white = "\033[37m";
    String reset = "\u001B[0m";

    public Juego() {
        this.lidia = new GenericList<Niño>();
        this.aisha = new GenericList<Niño>();
        cadena=null;
        n=0;
    }

    public void comenzar() {
      
        Random r = new Random();
        for (int minutos = 0; minutos < tiempoJuego; minutos++) {
            if (minutos <= 10) {// en los 10 primeros minutos pueden llegar por minuto 0,1 o 2 niños
                int nCrios = r.nextInt(3);
                for (int i = 0; i < nCrios; i++) {
                    ponerCrioEnEspera(new Niño(String.valueOf(n)));
                    System.out.println(green+"Minuto:" +minutos+" Niño "+n+" espera para jugar"+reset);
                    
                    n++;
                }

            } else if (minutos <= 30) {// en los 20 minutos siguientes cada tres minutos(probabilidad del 50%) pueden
                                       // llegar un niño
                if ((minutos - 10) % 3 == 0) {
                    if (r.nextInt(100) < 50) {
                        ponerCrioEnEspera(new Niño(String.valueOf(n)));
                        n++;
                    }
                }

            }

            cargarJugadores();
            if(juegoActivo){
                    jugar(minutos);
            }
            
        }



    }

    public void ponerCrioEnEspera(Niño crio) {
        this.lidia.insertEnd(crio);
    }


    public void cargarJugadores(){
        if(!juegoActivo && (this.lidia.size()>=5 || this.aisha.size()>0 )){
            //pasamos todos los niños en espera con aisha
            while(!this.lidia.isEmpty()){
                  Niño crio = this.lidia.deleteFront();
                  System.out.println(purple+" Crio "+crio.getId()+" pasa a jugar"+reset);
                  this.aisha.insertEnd(crio);
            }
            juegoActivo=true;
            System.out.println(blue+" Comienza un nuevo juego-------------" +reset);
          

        }
    }

    public void jugar(int minuto){
        if(this.cadena==null){
            //genero palabra
            this.cadena=Texto.generarTexto(10);
        }
        if(this.aisha.pasarMensaje(this.cadena,minuto)){ //termina el juego cuando pasar mensaje devuelve true
              System.out.println(blue+" Termina un juego-------------Resultados: " +reset);
            this.aisha.listar();
            this.cadena=null;
            this.aisha.resetear();
            juegoActivo=false;
            
        };
        

    }

}