import java.util.Random;

public class Kid {

 private Pizarrin pizarrin = null;
 private Kid next = null;

 private char getRandomChar() {
  int randomAscii = (int) (Math.random() * 26) + 'a';
  return (char) randomAscii;
 }

 private int getLettersChanged() {
  Random random = new Random();
  return random.nextInt(2) + 1;
 }

 public void givePizarrin(Pizarrin pizarrin) {
  this.pizarrin = pizarrin;
 }

 public Pizarrin getPizarrin() {
  return pizarrin;
 }

 public String getMessage() {
  return pizarrin.getMessage();
 }

 public void writeMessage(String message) {
  String newMessage = message;
  if (message.length() > 0) {
   char[] messageChars = message.toCharArray();

   for (int i = 0; i < getLettersChanged(); i++) {
    int randomIndex = (int) (Math.random() * messageChars.length);
    messageChars[randomIndex] = getRandomChar();
    newMessage = new String(messageChars);
   }
  }
  System.out.println("El mensaje de " + this + " es: " + newMessage);
  pizarrin.setMessage(newMessage);
 }

 public void clearMessage() {
  pizarrin.setMessage("");
 }

 public Kid getNext() {
  return next;
 }

 public void setNext(Kid next) {
  this.next = next;
 }
}
