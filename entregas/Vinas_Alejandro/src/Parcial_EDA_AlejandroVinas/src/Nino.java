
import java.util.Random;
public class Nino {

    String nombre = "";
    String textopizarrain = "";
    String textopizarraout = "";

    String pizarrin = "";

    Aisha aisha = null;

    String[] abecedario = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                           "n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public Nino(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    private int modificaletras(){
        Random random = new Random();

        int numletrasmodificadas = random.nextInt(3);
        return numletrasmodificadas;
    }
    public String getTextopizarrain() {
        return textopizarrain;
    }
    public void setTextopizarrain(String textopizarrain) {
        recibetexto(textopizarrain);
    }
    public String getTextopizarraout() {
        return textopizarraout;
    }
    public void setTextopizarraout(String textopizarraout) {
        this.textopizarraout = textopizarraout;
    }
    public String getPizarrin() {
        return pizarrin;
    }
    public void setPizarrin(String pizarrin) {
        this.pizarrin = pizarrin;
    }
    public void limpiaPizarrin(){
        this.textopizarrain = "";
    }

    public void recibetexto(String textopizarrin){
        this.textopizarrain = textopizarrin;
        System.out.println("Nino "+this.nombre+" recibe texto: "+textopizarrin);
        int letrasmodificar= modificaletras();
        System.out.println("El "+ this.nombre+" "+letrasmodificar+" letras");
        if(letrasmodificar>0){
            System.out.println("El "+ this.nombre+" modifica el texto");
        }else{
            System.out.println("El "+ this.nombre+" no modifica el texto");
            this.setTextopizarraout(this.textopizarrain);
        }
        this.textopizarraout = this.textopizarrain;
        for(int i=0;i<letrasmodificar;i++){
            int aleatorio = (int) (Math.random()*10);
            Character letra = this.textopizarrain.charAt(aleatorio);
            int aleatorio2 = (int) (Math.random()*26);
            String letra2 = abecedario[aleatorio2];
            this.textopizarraout = this.textopizarraout.replaceAll(letra.toString(), letra2);
        }
        System.out.println("El "+ this.nombre+" tras modificar el texto queda: "+this.textopizarraout);
    }

    public void escribePizarron(){
        System.out.println("El "+ this.nombre+" corre al pizarron y escribe: "+this.textopizarraout);
    }

}
