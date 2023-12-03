import java.util.Scanner;

public class Mundo {
 private Ludoteca ludoteca;
 private int time;
 private int incomingInterval = 0;
 private int incomingKidsAmount = 0;

 public Mundo(int timeOpen) {
  this.ludoteca = new Ludoteca();
  this.time = timeOpen;
 }

 private int newKid(int actualTime) {
  if (actualTime <= 10) {
   int amountOfKids = (int) (Math.random() * 3);
   incomingKidsAmount = amountOfKids;
  } else if (actualTime <= 20 && actualTime > 10) {
   incomingInterval += 1;
   if (incomingInterval % 3 == 0) {
    if (this.newKidProb()) {
     incomingKidsAmount = 1;
    }
   }
  } else {
   incomingKidsAmount = 0;
  }
  return incomingKidsAmount;
 }

 private boolean stillOpen() {
  return this.time == 0 ? false : true;
 }

 private boolean newKidProb() {
  return Math.random() <= 0.5 ? true : false;
 }

 public void update() {
  for (int actualTime = 0; actualTime < this.time; actualTime++) {
   System.out.println("Minuto: " + actualTime);
   int amountOfKids = this.newKid(actualTime);
   for (int i = 0; i < amountOfKids; i++) {
    String newName = this.inventarNombre();
    Niño kid = new Niño(newName);
    this.ludoteca.recieveKid(kid);
   }
   this.ludoteca.update();
   this.ludoteca.printLists();
   System.out.println("--------------------------------------------------");
   new Scanner(System.in).nextLine();
  }
 }

 private String inventarNombre() {
  String nombres[] = { "Andrés Elías A.C.", "Pablo A.D.A.", "Diego Alejandro B.M.", "Aníbal B.G.", "Umut B.",
    "Javier Enrique C.S.", "Fernando William C.M.", "Pablo C.R.", "Cayetano C.R.", "Iker C.B.", "Mario D.R.M.",
    "Adrián D.Q.", "Paula Qing D.G.", "Veronika Alexandra E.M.", "Eduardo David E.R.", "Hugo F.N.", "Adrián G.A.",
    "David G.C.", "César G.E.", "Diego G.N.", "Miguel G.C.", "Santiago G.D.L.T.R.", "Juan René I.S.J.", "Pablo L.T.",
    "Daniel L.A.", "Álvaro L.S.", "Maura M.N.", "Neco M.S.", "Diego M.T.", "Sergio Alejandro M.R.", "Sergio M.V.",
    "Diego Fernando M.R.", "Aurelio Sebastián O.G.", "Jorge O.G.", "Raúl P.P.", "Adrián P.B.", "Daniel P.S.",
    "Jorge André Q.S.", "José Manuel R.P.", "José Manuel R.M.", "José Luis R.G.", "José S.C.", "Javier S.J.",
    "Óscar S.S.", "Rubén S.F.", "Gabriel Francisco S.P.", "Iñaki T.A.", "Alejandro V.P.", "Andriuw Xavier Y.Z.", };
  return nombres[(int) (Math.random() * nombres.length)];
 }
}