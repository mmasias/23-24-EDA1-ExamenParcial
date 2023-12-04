package entregas.ludoteca;

import java.io.Console;
import java.util.Random;

import entregas.ludoteca.utils.ConsoleUI;

public class Child {
    String name;
    private String message;

    public Child(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getMessage() {
      return this.message;
    }

    private String distortMessage(String message) {
      char[] message_char_array = message.toCharArray();
      Random random = new Random();
      int numDistortions = random.nextInt(3);
      
      for (int i = 0; i < numDistortions; i++) {
        int indexToDistort = random.nextInt(message_char_array.length);
        char distortedChar = (char) (random.nextInt(26) + 'A');
        message_char_array[indexToDistort] = distortedChar;
      }

      String distorted_message = new String(message_char_array);
      
      return distorted_message;
    }

    private void writeMessage(String message) {
      this.message = distortMessage(message);
      ConsoleUI.printMinuteLog(this.name + " writes '" + message + "' on his board ");
    }

    public void receiveMessage(String message) {
      this.message = message;
      ConsoleUI.printMinuteLog(this.name + " received message: " + message);
      writeMessage(message);
    }

    public void passMessageTo(Child child) {
      child.receiveMessage(this.message);
    }

    public void cleanBoard() {
      this.message = "";
      ConsoleUI.printMinuteLog(this.name + " erased his message.");
    }
  }
