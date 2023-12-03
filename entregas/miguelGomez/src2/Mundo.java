import java.util.Scanner;

class Mundo {
    private Ludoteca ludoteca;
    private int tiempoTotal;

    public Mundo(Ludoteca laLudoteca, int tiempo){
        ludoteca = laLudoteca;
        tiempoTotal = tiempo;
    }

    public void iniciarSimulacion() {
        for (int minutoActual = 0; minutoActual < tiempoTotal; minutoActual++) {
            System.out.println("=".repeat(30));
            System.out.println("Minuto "+minutoActual);
            if (llegaNiño()) {
                Niño niño = generarNiño();
                ludoteca.recibirNiño(niño);
            }
            ludoteca.actualizar();
            ludoteca.verEstado();
            new Scanner(System.in).nextLine();
        }
    }

    private boolean llegaNiño() {
        return Math.random() > 0.5;
    }

    private Niño generarNiño() {
        String unNombre = inventarNombre();
        System.out.println("Llega " + unNombre);
        return new Niño(unNombre);
    }

    private String inventarNombre(){
        String nombres[] = { "Andrés Elías A.C.", "Pablo A.D.A.", "Diego Alejandro B.M.", "Aníbal B.G.", "Umut B.", "Javier Enrique C.S.", "Fernando William C.M.", "Pablo C.R.", "Cayetano C.R.", "Iker C.B.", "Mario D.R.M.", "Adrián D.Q.", "Paula Qing D.G.", "Veronika Alexandra E.M.", "Eduardo David E.R.", "Hugo F.N.", "Adrián G.A.", "David G.C.", "César G.E.", "Diego G.N.", "Miguel G.C.", "Santiago G.D.L.T.R.", "Juan René I.S.J.", "Pablo L.T.", "Daniel L.A.", "Álvaro L.S.", "Maura M.N.", "Neco M.S.", "Diego M.T.", "Sergio Alejandro M.R.", "Sergio M.V.", "Diego Fernando M.R.", "Aurelio Sebastián O.G.", "Jorge O.G.", "Raúl P.P.", "Adrián P.B.", "Daniel P.S.", "Jorge André Q.S.", "José Manuel R.P.", "José Manuel R.M.", "José Luis R.G.", "José S.C.", "Javier S.J.", "Óscar S.S.", "Rubén S.F.", "Gabriel Francisco S.P.", "Iñaki T.A.", "Alejandro V.P.", "Andriuw Xavier Y.Z.",  };
        return nombres[(int)(Math.random() * nombres.length)];
    }    
  
    public static void main(String[] args) {
        Ludoteca laLudoteca = new Ludoteca();
        Mundo elMundo = new Mundo(laLudoteca, 120);
        elMundo.iniciarSimulacion();
    }
}