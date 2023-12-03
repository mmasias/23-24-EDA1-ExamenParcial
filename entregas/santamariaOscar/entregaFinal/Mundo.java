import java.util.Scanner;

class Mundo {
    private Ludoteca ludoteca;
    private int tiempoTotal;

    public Mundo(Ludoteca unaLudoteca, int tiempoApertura){
        ludoteca = unaLudoteca;
        tiempoTotal = tiempoApertura;
    }

    public void iniciarSimulacion() {

        for (int minutoActual = 0; minutoActual < tiempoTotal; minutoActual++) {
            System.out.println("=====================================");
            System.out.println("Minuto "+minutoActual);
            if (llegaNiño( minutoActual)) {
                Niño niño = generarNiño();
                ludoteca.recibirNiño(niño);
            }
            ludoteca.actualizar();
            ludoteca.verEstado();
            new Scanner(System.in).nextLine();
        }
    }

    private boolean llegaNiño(int minutoActual) {
        if (minutoActual <= 30) {
            if (minutoActual < 10) {
                return Math.random() < 0.5;
            }else{
                return (minutoActual - 10) % 3 == 0;
            }
        }else{
            return false;
        }
    }

    private Niño generarNiño() {
        String unNombre = inventarNombre();
        System.out.println("Llega " + unNombre);
        return new Niño(unNombre);
    }

    private String inventarNombre(){
        String nombres[] = {"Daniel", "Javier", "Carolina", "Sara", "Raul", "Julian", "Diego", "Maria", "Luis", "Carlos", "Antonio", "Ana" };
        return nombres[(int)(Math.random() * nombres.length)];
    }    
  
    public static void main(String[] args) {
        Ludoteca unaLudoteca = new Ludoteca();
        Mundo elMundo = new Mundo(unaLudoteca, 120);
        elMundo.iniciarSimulacion();
    }
}
