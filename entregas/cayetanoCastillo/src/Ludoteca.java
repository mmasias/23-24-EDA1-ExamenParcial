package RetoTelefono;

import java.util.Random;
import java.util.concurrent.TimeUnit;

// Clase Ludoteca
public class Ludoteca {
    private Monitor lydia;
    private Monitor aisha;
    private Fila fila;
    private int minutos;
    private int contadorNiños;

    public Ludoteca() {
        this.lydia = new Monitor("Lydia");
        this.aisha = new Monitor("Aisha");
        this.fila = new Fila();
        this.minutos = 0;
        this.contadorNiños = 0;
    }

    public void iniciarPrograma() {
        while (minutos <= 120) { // Hasta 120 minutos
            simularPasoDeTiempo();
            System.out.println("Minuto: " + minutos);

            // Lógica para la llegada de niños solo en los primeros 30 minutos
            if (minutos <= 30) {
                int cantidadNiños = calcularLlegadaPrimeros30Minutos();
                for (int i = 0; i < cantidadNiños; i++) {
                    contadorNiños++;
                    Niño nuevoNiño = new Niño("Niño" + contadorNiños);
                    lydia.recibirNiño(nuevoNiño);
                    aisha.formarFila(fila, nuevoNiño);

                    // Verificar si la fila acumula 5 niños, entonces Aisha empieza a jugar
                    if (fila.tamaño() == 5) {
                        System.out.println("¡Aisha comienza a jugar!");
                        aishaJugar();
                    }
                }
            } else {
                // Después de los primeros 30 minutos, los niños siguen llegando
                contadorNiños++;
                Niño nuevoNiño = new Niño("Niño" + contadorNiños);
                lydia.recibirNiño(nuevoNiño);
                fila.agregarNiño(nuevoNiño);
            }

            // Realiza otras operaciones de la Ludoteca según sea necesario
        }
    }

    private int calcularLlegadaPrimeros30Minutos() {
        if (minutos <= 10) {
            // Entre 0 y 2 niños por minuto durante los primeros 10 minutos
            return (int) (Math.random() * 3);
        } else if (minutos <= 30) {
            // Entre 0 y 1 niños por minuto durante los siguientes 20 minutos
            return (int) (Math.random() * 2);
        }
        return 0; // No debería llegar ningún niño después del minuto 30
    }

    // En la clase Ludoteca
    private void aishaJugar() {
        // Lógica del juego de Aisha
        // Supongamos que el juego dura 10 minutos
        String palabraAleatoria = generarMensajeAleatorio();
        System.out.println("La palabra es: " + palabraAleatoria);

        for (int i = 0; i < 10; i++) {
            simularPasoDeTiempo();
            System.out.println("Minuto: " + minutos + " - Aisha está jugando...");

            // Pase de la palabra de forma lineal a los niños
            Node<Niño> current = fila.getPrimero();
            while (current != null) {
                Niño niñoActual = current.getData();
                if (niñoActual != null) {
                    niñoActual.recibirPalabra(palabraAleatoria);
                    System.out.println("Niño " + niñoActual.getNombre() + " recibió la palabra: " + palabraAleatoria);
                }

                current = current.getNext();
            }

            // Lógica para la llegada de niños durante el juego de Aisha
            int cantidadNiños = calcularLlegadaPrimeros30Minutos();
            for (int j = 0; j < cantidadNiños; j++) {
                contadorNiños++;
                Niño nuevoNiño = new Niño("Niño" + contadorNiños);
                lydia.recibirNiño(nuevoNiño);
                fila.agregarNiño(nuevoNiño);
            }
        }

        // Después de que Aisha termina de jugar, los niños en Fila pueden unirse al
        // grupo
        System.out.println("¡Aisha ha terminado de jugar! Los niños en Fila se unen al grupo.");
        while (fila.tamaño() > 0) {
            Niño niñoEnFila = fila.removerNiño(); // Sacar un niño de la fila
            aisha.formarFila(fila, niñoEnFila); // Unir al niño al grupo después de que Aisha ha jugado
        }

        // Iniciar el próximo juego con los niños que aún no han jugado
        if (fila.tamaño() > 0) {
            System.out.println("Iniciando nuevo juego con los niños que faltan.");
            iniciarNuevoJuego();
        }
    }

    private void intercambiarMensajes(Fila fila) {
        aisha.limpiarPizarrines(fila);

        Node<Niño> current = fila.getPrimero();
        // Verificar si el último niño escribió en la pizarra

        Node<Niño> ultimoNiño = fila.getUltimo();

        while (current != null) {
            String mensaje = generarMensajeAleatorio(); // Genera un mensaje aleatorio de 10 letras
            current.getData().escribirEnPizarra(mensaje);

            if (current.getNext() != null) {
                System.out.println(current.getData().getNombre() + " muestra el mensaje: " + mensaje +
                        " a " + current.getNext().getData().getNombre());
            }

            ultimoNiño = current; // Asignar el último niño en cada iteración
            current = current.getNext();
        }

        // Verificar si ultimoNiño no es null antes de acceder a su data
        if (ultimoNiño != null) {
            String mensajeFinal = ultimoNiño.getData().obtenerMensajeEnPizarra();
            System.out.println(
                    ultimoNiño.getData().getNombre() + " corre y escribe en la pizarra del salón: " + mensajeFinal);
        }
    }

    private String generarMensajeAleatorio() {
        // Caracteres posibles para el mensaje
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        // Crear un objeto Random
        Random random = new Random();

        // Construir el mensaje aleatorio
        StringBuilder mensajeAleatorio = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            // Obtener un índice aleatorio
            int indice = random.nextInt(caracteres.length());

            // Obtener el carácter correspondiente al índice
            char caracterAleatorio = caracteres.charAt(indice);

            // Agregar el carácter al mensaje
            mensajeAleatorio.append(caracterAleatorio);
        }

        return mensajeAleatorio.toString();
    }

    private void iniciarNuevoJuego() {
        // Lógica para formar la fila y comenzar el próximo juego
        while (fila.tamaño() > 0) {
            Niño niñoEnFila = fila.removerNiño(); // Sacar un niño de la fila
            aisha.formarFila(fila, niñoEnFila); // Unir al niño al grupo para el próximo juego
        }
    }

    private void simularPasoDeTiempo() {
        try {
            TimeUnit.SECONDS.sleep(1); // Simula el paso de 1 segundo
            minutos++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
