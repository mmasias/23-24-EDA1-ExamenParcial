import java.util.Random;

public class Jugador {
    private Pizarra pizarra;

    public Jugador(Pizarra pizarra) {
        this.pizarra = pizarra;
    }

    public void jugar(String palabra, int probFallo) {
        String palabraModificada = errPalabra(palabra, probFallo);
        pizarra.setPalabra(palabraModificada);
    }

    private String errPalabra(String word, int probability) {
        Random random = new Random();
        StringBuilder newWord = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (random.nextInt(100) < probability) {
                c = (char) (c + 2);
            }
            newWord.append(c);
        }
        return newWord.toString();
    }
}
