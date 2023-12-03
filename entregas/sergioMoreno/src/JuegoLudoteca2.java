import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoLudoteca2 {
    public static void main(String[] args) {
        Ludoteca ludoteca = new Ludoteca();
        Random rand = new Random();
        int contadorNinos = 0;

        for (int minuto = 0; minuto < 120; minuto++) { 
            System.out.println("--------");
            System.out.println("Minuto: " + minuto);
            if (minuto < 10) { 
                int ninosEsteMinuto = rand.nextInt(3);
                for (int i = 0; i < ninosEsteMinuto; i++) {
                    ludoteca.agregarNino(new Nino("Niño " + contadorNinos));
                    System.out.println("Niño " + contadorNinos++ + " agregado a la fila");
                }
            } else if (minuto < 30 && minuto % 3 == 0 && rand.nextBoolean()) { 
                ludoteca.agregarNino(new Nino("Niño " + contadorNinos));
                System.out.println("Niño " + contadorNinos++ + " agregado a la fila");
            }
            ludoteca.procesarJuego(minuto);
            
        }
    }
}

class Nino {
    String nombre;
    String mensaje;

    public Nino(String nombre) {
        this.nombre = nombre;
        this.mensaje = "";
    }

    public void recibirYModificarMensaje(String mensaje) {
        Random rand = new Random();
        this.mensaje = mensaje;
       
        for (int i = 0; i < rand.nextInt(2) + 1; i++) {
            int pos = rand.nextInt(mensaje.length());
            char nuevaLetra = (char) ('A' + rand.nextInt(26));
            this.mensaje = mensaje.substring(0, pos) + nuevaLetra + mensaje.substring(pos + 1);
        }
        System.out.println(nombre + " escribe: " + this.mensaje);
    }
}

class Ludoteca {
    List<Nino> fila = new ArrayList<>();
    String mensajeOriginal = "ABCDEFGHIJ";
    int indiceActual = 0;
    boolean juegoEnCurso = false;

    public void agregarNino(Nino nino) {
        fila.add(nino);
    }

    public void procesarJuego(int minutoActual) {
        if (!juegoEnCurso && fila.size() >= 5) {
          
            juegoEnCurso = true;
            indiceActual = 0;
            System.out.println("Nuevo juego iniciado con mensaje: " + mensajeOriginal);
        }

        if (juegoEnCurso && indiceActual < fila.size()) {
            Nino ninoActual = fila.get(indiceActual);
            ninoActual.recibirYModificarMensaje(mensajeOriginal);
            mensajeOriginal = ninoActual.mensaje;
            indiceActual++;

            if (indiceActual == fila.size()) {
               
                System.out.println("Mensaje final: " + mensajeOriginal);
                juegoEnCurso = false;
                mensajeOriginal = "ABCDEFGHIJ"; 
                if (fila.size() >= 5) {
                  
                    juegoEnCurso = true;
                    indiceActual = 0;
                    System.out.println("Nuevo juego iniciado con mensaje: " + mensajeOriginal);
                } else {
                   
                    fila.clear();
                }
            }
        }
    }
}
