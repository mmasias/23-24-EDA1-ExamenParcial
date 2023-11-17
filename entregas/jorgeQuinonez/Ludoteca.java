public class Ludoteca {

 private String startingMessage = "Hola Niños De La Ludoteca";
 private Lidia lidia = new Lidia();
 private Aisha aisha = new Aisha();
 private int minutes = 0;

 private void printFinalMessage() {
  if (!aisha.isPlaying()) {
   System.out.println("Mensaje entregado: " + aisha.getLastKidMessage());
  }
 }

 public void open() {
  while (minutes <= 120) {
   Kid newKid = null;
   minutes++;
   if (minutes <= 10) {
    int newKidProb = (int) Math.random() * (2 - 1) + 1;
    newKid = new Kid();
    if (newKidProb == 2) {
     newKid.setNext(new Kid());
    }
    System.out.println("Llega un nuevo niño a la ludoteca");
    lidia.addKid(newKid);
   } else if (minutes > 10 && minutes <= 30) {
    if (minutes % 3 == 0) {
     double newKidProb = Math.random();
     if (newKidProb <= 0.5) {
      newKid = new Kid();
     }
    }
    lidia.addKid(newKid);
   }
   if (!aisha.isPlaying() && lidia.kidsWaiting()) {
    aisha.addKid(lidia.getFirstKid());
    lidia.removeKid();
   }
   aisha.startGame(startingMessage);
   printFinalMessage();
  }

 }
}