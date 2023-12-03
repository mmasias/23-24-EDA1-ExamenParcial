public class Ludoteca {
    private final int tiempoAbierta = 120;
    private MonitorEntrada lydia;
    private MonitorJuego aisha;

    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();
        ludoteca.inicioJornada();
    }

    public Ludoteca() {
        lydia = new MonitorEntrada("Lydia");
        aisha = new MonitorJuego("Aisha");
    }

    public void inicioJornada() {
        Juego juego = new Juego(aisha.getColaDeNiños());
        while (juego.getTiempoJuego() < tiempoAbierta){
            System.out.println(("=").repeat(50));
            System.out.println(Color.ANSI_RED + "Minuto: " + juego.getTiempoJuego() + Color.ANSI_RESET);
            estadoActual();

            if (llegadaNiños(juego.getTiempoJuego()) != 0) {
                Niño nuevoNiño = generarNiño();
                lydia.recibeNiño(nuevoNiño, aisha);
            }

            if (aisha.getColaDeNiños().size() >= 5) {
                System.out.println(Color.ANSI_BLUE + "Se inicia el juego" + ("-").repeat(20) + Color.ANSI_RESET);
                juego.jugar(juego.getTiempoJuego());
            }

            juego.setSubeTiempoJuego();
        }

        if (!juego.estaJugando()) {
            while (lydia.getColaDeNiños().size() > 0) {
                Niño niñoTransferido = lydia.getColaDeNiños().removeNiño();
                aisha.recibeNiño(niñoTransferido);
            }
        }

        System.out.println(Color.ANSI_BLUE + "La ludoteca ha cerrado" + Color.ANSI_RESET);
    }

    private Niño generarNiño() {
        String unNombre = inventarNombre();
        System.out.println(Color.ANSI_RED + " > Llega " + unNombre + Color.ANSI_RESET);
        return new Niño(unNombre);
    }

    private String inventarNombre() {
        String nombres[] = { "Andrés Elías A.C.", "Pablo A.D.A.", "Diego Alejandro B.M.", "Aníbal B.G.", "Umut B.", "Javier Enrique C.S.", "Fernando William C.M.", "Pablo C.R.", "Cayetano C.R.", "Iker C.B.", "Mario D.R.M.", "Adrián D.Q.", "Paula Qing D.G.", "Veronika Alexandra E.M.", "Eduardo David E.R.", "Hugo F.N.", "Adrián G.A.", "David G.C.", "César G.E.", "Diego G.N.", "Miguel G.C.", "Santiago G.D.L.T.R.", "Juan René I.S.J.", "Pablo L.T.", "Daniel L.A.", "Álvaro L.S.", "Maura M.N.", "Neco M.S.", "Diego M.T.", "Sergio Alejandro M.R.", "Sergio M.V.", "Diego Fernando M.R.", "Aurelio Sebastián O.G.", "Jorge O.G.", "Raúl P.P.", "Adrián P.B.", "Daniel P.S.", "Jorge André Q.S.", "José Manuel R.P.", "José Manuel R.M.", "José Luis R.G.", "José S.C.", "Javier S.J.", "Óscar S.S.", "Rubén S.F.", "Gabriel Francisco S.P.", "Iñaki T.A.", "Alejandro V.P.", "Andriuw Xavier Y.Z.",  };
        return nombres[(int) (Math.random() * nombres.length)];
    }

    public int llegadaNiños(int tiempoActual) {
        if (tiempoActual <= 10) {
            return (int) (Math.random() * 3);
        } else if (tiempoActual <= 30) {
            if (Math.random() < 0.5) {
                return 1;
            }
        }
        return 0;
    }

    private void estadoActual() {
        lydia.mostrarCola(lydia.getNombre());
        aisha.mostrarCola(aisha.getNombre());
    }
}
