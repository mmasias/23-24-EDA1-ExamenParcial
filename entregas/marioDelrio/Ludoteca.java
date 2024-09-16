import java.util.Random;

public class Ludoteca {
    private List<Nino> lidia;
    private List<Nino> aisha; 
    private boolean juegoActivo = false;
    private int tiempoJuego = 120;
    private String texto;
    private int n = 0; 
    String red = "\033[31m";
    String green = "\033[32m";
    String blue = "\033[34m";
    String purple = "\033[35m";
    String reset = "\u001B[0m";

    public Ludoteca() {
        this.lidia = new List<Nino>();
        this.aisha = new List<Nino>();
        texto=null;
        n=0;
    }

    public void comenzar() {
      
        Random r = new Random();
        for (int minutos = 0; minutos < tiempoJuego; minutos++) {
            if (minutos <= 10) {
                int numeroNino = r.nextInt(3);
                for (int i = 0; i < numeroNino; i++) {
                    ninoEnEspera(new Nino(String.valueOf(n)));
                    System.out.println(green+"Minuto:" +minutos+" Niño "+n+" espera para jugar"+reset);
                    n++;
                }

            } else if (minutos <= 30) {
                if ((minutos - 10) % 3 == 0) {
                    if (r.nextInt(100) < 50) {
                        ninoEnEspera(new Nino(String.valueOf(n)));
                        n++;
                    }
                }

            }

            formarEquipo();
            if(juegoActivo){
                    jugar(minutos);
            }
            
        }



    }

    public void ninoEnEspera(Nino nino) {
        this.lidia.insertEnd(nino);
    }


    public void formarEquipo(){
        if(!juegoActivo && (this.lidia.size()>=5 || this.aisha.size()>0 )){
            while(!this.lidia.isEmpty()){
                  Nino nino = this.lidia.deleteFront();
                  System.out.println(purple+"Niño "+nino.getId()+" pasa a jugar"+reset);
                  this.aisha.insertEnd(nino);
            }
            juegoActivo=true;
            System.out.println(blue+"Comienza un nuevo juego-------------"+reset);
          

        }
    }

    public void jugar(int minuto){
        if(this.texto==null){
            //genero palabra
            this.texto=Texto.generarTexto(10);
        }
        if(this.aisha.pasarMensaje(this.texto,minuto)){ //termina el juego cuando pasar mensaje devuelve true
              System.out.println(blue+"Termina un juego-------------Resultados:"+reset);
            this.aisha.listar();
            this.texto=null;
            this.aisha.resetear();
            juegoActivo=false;
            
        };
        

    }

}