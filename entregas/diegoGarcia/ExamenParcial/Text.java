package entregas.diegoGarcia.ExamenParcial;

import java.util.Random;

public class Text {

    public static String createRandomString(int n) {
        String text = "";
        for (int i = 0; i < n; i++) {
            text += generateRandomnLetter();
        }
        return text;

    }

    private static char generateRandomnLetter() {
        Random r = new Random();
        return (char) r.nextInt(65, 91);
    }

    public static String randomLetterChange(String text) {
        char[] message = text.toCharArray();
        Random r = new Random();
        int letterNumber = r.nextInt(0, 3);
        int pos = 0;
        if (letterNumber == 1) {
            pos = r.nextInt(text.length());
            message[pos] = generateRandomnLetter();

        }
        if (letterNumber == 2) {
            pos = r.nextInt(text.length());
            message[pos] = generateRandomnLetter();
            pos = r.nextInt(text.length());
            message[pos] = generateRandomnLetter();

        }
        return String.valueOf(message);

    }

}
