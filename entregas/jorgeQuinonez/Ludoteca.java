public class Ludoteca {
 private Monitor lidia;
 private Monitor aisha;
 private Pizarra pizarra;

 public Ludoteca() {
  this.lidia = new Monitor("Lidia");
  this.aisha = new Monitor("Aisha");
  this.pizarra = new Pizarra();
 }

 public void recieveKid(Niño kid) {
  lidia.recieveKid(kid);
 }

 public void update() {
  if (lidia.hasKids() && !aisha.isPlaying()) {
   lidia.giveKid(aisha);
  }
  if (aisha.canPlay()) {
   aisha.play();
  }
 }

 public void printLists() {
  if (!aisha.isPlaying()) {
   lidia.showKids();
   aisha.showKids();
  }
 }
}