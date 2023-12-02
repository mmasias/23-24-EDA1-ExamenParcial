package parcial;

import java.util.Random;

class Aisha {
    private static final int LONGITUD_MENSAJE = 10;

    private Random random = new Random();

    public void pasarPizarron(Niño niño) {
        System.out.println("Aisha pasa el pizarron a " + niño.getNombre());
    }

    public void inicializer(List<Niño> niñosDeLydia) {
        System.out.println("Jugando");

        StringBuilder message = new StringBuilder(generateMessage());
        System.out.println("Mensaje original: " + message);

        List<Niño> niños = new List<>();
        while (!niñosDeLydia.isEmpty()) {
            niños.insert(niñosDeLydia.getFirst().getData(), -1);
            niñosDeLydia.remove(0);
        }

        while (!niños.isEmpty()) {
            Niño niño = niños.getFirst().getData();
            niños.remove(0);
            deformMessage(message);
            System.out.println(niño.getNombre() + " recibe el mensaje: " + message);
        }

        System.out.println("Ultimo niño escribe el mensaje: " + message);
        limpiarPizarras(niñosDeLydia);
    }

    private String generateMessage() {
        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < LONGITUD_MENSAJE; i++) {
            char letra = (char) (random.nextInt(26) + 'A');
            mensaje.append(letra);
        }
        return mensaje.toString();
    }

    private void deformMessage(StringBuilder mensaje) {
        int cambios = random.nextInt(3);
        for (int i = 0; i < cambios; i++) {
            int posicion = random.nextInt(LONGITUD_MENSAJE);
            char nuevaLetra = (char) (random.nextInt(26) + 'A');
            mensaje.setCharAt(posicion, nuevaLetra);
        }
    }

    public void limpiarPizarras(List<Niño> niñosDeLydia) {
        niñosDeLydia = new List<>();
    }
}