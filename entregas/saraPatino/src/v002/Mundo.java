import java.util.Scanner;

class Mundo {
    private Ludoteca ludoteca;
    private int tiempoTotal;

    public Mundo(Ludoteca unaLudoteca, int tiempoApertura) {
        ludoteca = unaLudoteca;
        tiempoTotal = tiempoApertura;
    }

    public void iniciarSimulacion() {
        for (int minutoActual = 0; minutoActual < tiempoTotal; minutoActual++) {
            System.out.println("=".repeat(30));
            System.out.println("Minuto " + minutoActual);
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

    private String inventarNombre() {
        String nombres[] = {
                "Elena María A.C.", "Andrés Antonio A.D.A.", "Juan Diego B.M.", "María Isabel B.G.", "Pedro Umut B.",
                "Laura Javier C.S.", "Santiago Fernando C.M.", "Gabriela Pablo C.R.", "Carlos Cayetano C.R.",
                "Lucía Iker C.B.",
                "Mateo Mario D.R.M.", "Carmen Adrián D.Q.", "Luisa Paula Qing D.G.", "Rafael Veronika Alexandra E.M.",
                "Julieta Eduardo David E.R.", "Pablo Hugo F.N.", "Valentina Adrián G.A.", "Daniel David G.C.",
                "Isabella César G.E.",
                "Diego Miguel G.N.", "Olivia Santiago G.D.L.T.R.", "Sofía Juan René I.S.J.", "Martín Pablo L.T.",
                "Alejandra Daniel L.A.",
                "Lucas Álvaro L.S.", "Valeria Maura M.N.", "Mariano Neco M.S.", "Camila Diego M.T.",
                "Andrea Sergio Alejandro M.R.",
                "Sebastián Sergio M.V.", "Emilia Diego Fernando M.R.", "Fernando Aurelio Sebastián O.G.",
                "Paulina Jorge O.G.",
                "Isidro Raúl P.P.", "Ana Adrián P.B.", "Sara Daniel P.S.", "Francisco Jorge André Q.S.",
                "Mónica José Manuel R.P.",
                "Ricardo José Manuel R.M.", "Santiago José Luis R.G.", "Olga José S.C.", "Rafael Javier S.J.",
                "Eva Óscar S.S.",
                "Andrea Rubén S.F.", "Juan Gabriel Francisco S.P.", "María Iñaki T.A.", "Roberto Alejandro V.P.",
                "Elena Andriuw Xavier Y.Z."
        };
        
        return nombres[(int) (Math.random() * nombres.length)];
    }

    public static void main(String[] args) {
        Ludoteca unaLudoteca = new Ludoteca();
        Mundo elMundo = new Mundo(unaLudoteca, 120);
        elMundo.iniciarSimulacion();
    }
}
