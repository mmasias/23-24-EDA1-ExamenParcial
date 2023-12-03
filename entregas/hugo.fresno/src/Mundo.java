class Mundo {
    private Ludoteca ludoteca;
    private int tiempoTotal;

    public Mundo(Ludoteca unaLudoteca, int tiempoApertura){
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

            ludoteca.actualizarEstado();
            ludoteca.mostrarEstadoActual();
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
        String nombres[] = {
                "Lucas M.B.", "Sofía P.V.", "Martín T.R.", "Valentina N.L.", "Mateo D.C.",
                "Camila G.P.", "Nicolás F.Q.", "Isabella R.T.", "Julián S.W.", "Gabriela L.M.",
                "Diego U.Y.", "Carla E.Z.", "Santiago V.X.", "Lucía H.J.", "Sebastián K.L.",
                "Mía I.O.", "Alejandro A.P.", "Olivia B.C.", "Samuel N.D.", "María José Q.F.",
                "David G.H.", "Victoria R.S.", "Daniel J.T.", "Mariana U.V.", "Leonardo K.W.",
                "Paula X.Y.", "Ángel L.Z.", "Fernanda A.B.", "Gustavo C.D.", "Daniela E.F.",
                "Carlos G.H.", "Jimena I.J.", "Federico K.L.", "Renata M.N.", "Javier O.P.",
                "Emilia Q.R.", "Esteban S.T.", "Carolina V.U.", "Francisco X.W.", "Sara Y.Z.",
                "Manuel A.C.", "Ana María D.E.", "Iván F.G.", "Elena H.I.", "Hernán J.K.",
                "Cecilia L.M.", "Roberto N.O.", "Diana P.Q.", "Ernesto R.S.", "Patricia T.U."
        };
        return nombres[(int)(Math.random() * nombres.length)];
    }

    public static void main(String[] args) {
        Ludoteca unaLudoteca = new Ludoteca();
        Mundo elMundo = new Mundo(unaLudoteca, 120);
        elMundo.iniciarSimulacion();
    }
}