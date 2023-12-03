public class Ludoteca {
   Frase f;
   Juego j;
private int minLudoteca;
    public Ludoteca(int minLudoteca) {
        f=new Frase(10);
        j= new Juego();
        minLudoteca=90;
    }

    public void Accion(){
        for (int i = 0; i < minLudoteca; i++) {
            j.probNiños();

               for (int k = 0; k < j.juego.size(); k++) {
                   System.out.println(f.getTexto());
                   System.out.println("Minuto: "+i);
                   f.cambioDeLetra();
               }




        }
    }
}
