import java.util.Random;

public class Children {
    private String givenWord;
    private String blackBoardWord;

    public void writeWord(String word) {
        this.givenWord = word;
    }

    public void editGivenWord() {
        if (givenWord != null && !givenWord.isEmpty()) {
            Random random = new Random();
            int numChanges = random.nextInt(3);

            char[] wordArray = givenWord.toCharArray();

            for (int i = 0; i < numChanges; i++) {
                int indexToChange = random.nextInt(wordArray.length);
                char newChar = generateRandomLetter();
                wordArray[indexToChange] = newChar;
            }

            this.blackBoardWord = new String(wordArray);
        }
    }

    private char generateRandomLetter() {
        Random random = new Random();
        char randomLetter = (char) ('a' + random.nextInt(26));
        return randomLetter;
    }

    public String readWord() {
        return this.blackBoardWord;
    }
}
