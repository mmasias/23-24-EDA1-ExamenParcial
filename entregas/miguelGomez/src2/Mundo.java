public class Mundo {
    private Ludoteca ludoteca;
    private int tiempo;

    public Mundo(Ludoteca laludoteca, int tiempodado) {
        ludoteca = laludoteca;
        tiempo = tiempodado;
    }

    public void IniciarEvento() {
        for (int minutoActual = 0; minutoActual < tiempo; minutoActual++) {
            System.out.println("=".repeat(30));
            System.out.println("Minuto: " + minutoActual);
            if(llegaNiño()){
                Niño niño = inventaNiño();
                ludoteca.ingresarNiño(niño);
            }
            ludoteca.actualizar();
            ludoteca.mostrar();
            new Scanner(System.in).nextLine();
            }
        }

        private boolean llegaNiño() {
            return Math.random() < 0.5;
        }

        private Niño inventaNiño() {
            String nombreniño = pensarNombre();
            System.out.println("Llega a la ludoteca el niño " + nombreniño);
            return new Niño(nombreniño);
        }

        private String pensarNombre() {
            String nombres[] = {"Juan", "Pedro", "Pablo", "Diego", "Jorge", "Luis", "Carlos", "Mario", "Javier", "José", "Jesús", "Manuel", "Francisco", "Miguel", "Rafael", "Fernando", "Daniel", "Alejandro", "David", "José Antonio", "Andrés", "José Luis", "Joaquín", "Sergio", "Antonio", "Rubén", "Miguel Ángel", "Alberto", "Juan Carlos", "Ángel", "Julián", "Alfonso", "Vicente", "Ricardo", "Enrique", "Óscar", "Jorge", "Eduardo", "Jaime", "Ramón", "Ignacio", "Salvador", "Adrián", "Marcos", "Juan Manuel", "Tomás", "Agustín", "Jesús María", "Juan José", "Jordi", "Jesús Manuel", "Jesús María", "Jesús Ángel", "José Francisco", "José María", "José Miguel", "José Ramón", "José Vicente", "Juan Antonio", "Juan Francisco", "Juan José", "Juan Luis", "Juan Manuel", "Juan Miguel", "Juan Pedro", "Luis Ángel", "Luis Miguel", "Manuel Jesús", "Manuel José", "Manue"};
            return nombres[(int) (Math.random() * nombres.length)];
        }

        public static void main(String[] args) {
            Ludoteca laludoteca = new Ludoteca();
            Mundo Tierra = new Mundo(laludoteca, 120);
            Tierra.IniciarEvento();
        }
    }
