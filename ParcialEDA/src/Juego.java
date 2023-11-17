import java.util.Random;

public class Juego {
    List<Crio> espera;//Lidia
    List<Crio> juego; //Aisha
    Random random;
    public Juego() {
        this.espera = new List<>();
        this.juego = new List<>();
        random=new Random();
    }


public void probNiños (){
    for (int i = 0; i < 30; i++) {
       if (i>=0&&i<=10){
          int r=random.nextInt(0,2);
          if (r==1){
              juego.insert(new Crio(random.nextInt(0,500)));
          } else if (r==2) {
              juego.insert(new Crio(random.nextInt(0,500)));
              juego.insert(new Crio(random.nextInt(0,500)));
          }

       }
       if (i>10&&i>=30){
           int r= random.nextInt(0,1);
           if (r==1){
               juego.insert(new Crio(random.nextInt(0,500)));
               i=i+3;
       }
    }
    }
}
public void list(){
       juego.listAll();
}




}
