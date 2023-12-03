public class Niño {

 private Niño next;
 private Pizarra pizarrin;
 private String name;

 public Niño(String name) {
  this.name = name;
 }

 private String modifyMessage(String message) {
  int modifyAmount = (int) (Math.random() * 3);
  int messageLength = message.length();

  for (int i = 0; i < modifyAmount; i++) {
   int chosenRandomLetter = (int) (Math.random() * messageLength);
   char randomAscii = (char) ((int) (Math.random() * 26) + 'a');
   message = message.substring(0, chosenRandomLetter) + randomAscii + message.substring(chosenRandomLetter + 1);
  }
  return message;
 }

 public void recieveMessage(String message) {
  this.pizarrin.writeMessage(modifyMessage(message));
  System.out.println("Recibe [" + message + "] y ha escrito [" + this.showMessage() + "]");
 }

 public void recievePizarrin(Pizarra pizarrin) {
  this.pizarrin = pizarrin;
 }

 public void cleanPizarrin() {
  this.pizarrin.clear();
 }

 public void setNext(Niño next) {
  this.next = next;
 }

 public Niño getNext() {
  return next;
 }

 public String showMessage() {
  return this.pizarrin.getMessage();
 }

 public String getName() {
  return this.name;
 }

}
