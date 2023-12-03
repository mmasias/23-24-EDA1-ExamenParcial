import java.util.Scanner;

public class Mundo {
    private Ludoteca ludoteca;
    private int tiempoTotal;
    public Mundo(Ludoteca unaLudoteca, int tiempoSimulación) {
        ludoteca = unaLudoteca;
        tiempoTotal = tiempoSimulación;
    }
    public static void main(String[] args) {
        Ludoteca unaLudoteca = new Ludoteca();
        Mundo mundo = new Mundo(unaLudoteca, 120);
        mundo.simular();
    }
    private int llegadaNiños(int minutoActual){
        double random = Math.random();
        int numeroNiñosLlegan = (int) (Math.floor(Math.random()*(2-0+1)+0));
        if(minutoActual<10){
            return numeroNiñosLlegan;
        }else if(minutoActual<30&&minutoActual>9&& minutoActual%3==0){
            if(random<0.5){
                return 1;
            }

        }  return 0;  
    }
    private Niño generarNiño(){
        String nombre = inventarNombre();
        System.out.println("Ha llegado el niño: " + nombre);
        return new Niño(nombre);

    }
    private String inventarNombre(){
        String nombres[] = { "Andrés Elías A.C.", "Pablo A.D.A.", "Diego Alejandro B.M.", "Aníbal B.G.", "Umut B.", "Javier Enrique C.S.", "Fernando William C.M.", "Pablo C.R.", "Cayetano C.R.", "Iker C.B.", "Mario D.R.M.", "Adrián D.Q.", "Paula Qing D.G.", "Veronika Alexandra E.M.", "Eduardo David E.R.", "Hugo F.N.", "Adrián G.A.", "David G.C.", "César G.E.", "Diego G.N.", "Miguel G.C.", "Santiago G.D.L.T.R.", "Juan René I.S.J.", "Pablo L.T.", "Daniel L.A.", "Álvaro L.S.", "Maura M.N.", "Neco M.S.", "Diego M.T.", "Sergio Alejandro M.R.", "Sergio M.V.", "Diego Fernando M.R.", "Aurelio Sebastián O.G.", "Jorge O.G.", "Raúl P.P.", "Adrián P.B.", "Daniel P.S.", "Jorge André Q.S.", "José Manuel R.P.", "José Manuel R.M.", "José Luis R.G.", "José S.C.", "Javier S.J.", "Óscar S.S.", "Rubén S.F.", "Gabriel Francisco S.P.", "Iñaki T.A.", "Alejandro V.P.", "Andriuw Xavier Y.Z.",  };
        return nombres[(int)(Math.random() * nombres.length)];
    }    
    
    public void simular(){
        for(int minutoActual= 0; minutoActual<tiempoTotal; minutoActual++){
            System.out.println("");
            System.out.println("");
            System.out.println("Minuto: " + minutoActual);
            if (llegadaNiños(minutoActual) == 1) {
                Niño niño = generarNiño();
                ludoteca.entraNiño(niño);
            } else if (llegadaNiños(minutoActual) == 2) {
                Niño niño1 = generarNiño();
                Niño niño2 = generarNiño();
                ludoteca.entraNiño(niño1);
                ludoteca.entraNiño(niño2);
            }
            ludoteca.actualizar();
            ludoteca.listarNiños();
            new Scanner(System.in).nextLine();
        }
    }
}

