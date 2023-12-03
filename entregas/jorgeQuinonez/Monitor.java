public class Monitor {
 private String name;
 private Cola cola;
 private Pizarra pizarra;
 private Niño currentKid;
 private boolean playing;
 private boolean canPlay;

 public Monitor(String name) {
  this.name = name;
  this.cola = new Cola();
  this.pizarra = new Pizarra();
  this.playing = false;
 }

 public String getName() {
  return name;
 }

 public void recieveKid(Niño kid) {
  this.cola.insertEnd(kid);
 }

 public void recieveKid(Niño kid, Pizarra pizarrin) {
  kid.recievePizarrin(pizarrin);
  this.cola.insertEnd(kid);
 }

 public void giveKid(Monitor other) {
  if (this.hasKids()) {
   System.out.println(" >  " + this.getName() + " Entrega un niño a " + other.getName());
   Niño givenKid = this.cola.getFirst();
   this.cola.deleteStart();
   other.recieveKid(givenKid, new Pizarra());
  }
 }

 public void cleanPizarras() {
  Niño iterator = this.cola.getFirst();
  while (iterator != null) {
   iterator.cleanPizarrin();
   iterator = iterator.getNext();
  }
 }

 public void play() {
  if (!this.isPlaying()) {
   this.playing = true;
   this.cleanPizarras();
   this.currentKid = this.cola.getFirst();
   this.currentKid.recieveMessage("Los sobrinos de Lidia");
  } else {
   Niño iterator = this.cola.getFirst();
   while (iterator != currentKid) {
    iterator = iterator.getNext();
   }
   if (iterator.getNext() != null) {
    Niño actualKid = iterator;
    Niño nextKid = iterator.getNext();
    nextKid.recieveMessage(actualKid.showMessage());
    this.currentKid = iterator;
   } else {
    this.playing = false;
    this.currentKid = this.cola.getFirst();
   }
  }
 }

 public void showKids() {
  System.out.println(" > " + this.getName() + " tiene en cola a: ");
  this.cola.listAll();
  System.out.println("------------------------------------");
 }

 public boolean isPlaying() {
  return playing;
 }

 public boolean canPlay() {
  return this.cola.size() > 5 ? true : false;
 }

 public boolean hasKids() {
  return !this.cola.isEmpty();
 }
}
