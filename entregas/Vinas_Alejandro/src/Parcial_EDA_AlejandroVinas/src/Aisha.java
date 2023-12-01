import java.util.ArrayList;
import java.util.List;

public class Aisha extends Monitora{

    String pizarrin = "";
    private String[] abecedario = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                                   "n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private boolean partidainiciada = false;
    private boolean partidaTerminada = false;


    public Aisha(String nombr) {
        super(nombr);
    }

    public void setAbecedario(String[] abecedario) {
        this.abecedario = abecedario;
    }
    public String[] getAbecedario() {
        return abecedario;
    }
    public boolean isPartidainiciada() {
        return partidainiciada;
    }
    public void pasaNino(Nino nin){
        nin.setPizarrin("");
        if(this.ninos.size()==5){
           this.partidainiciada = true;
           this.ninos.get(0).setPizarrin(this.pizarrin);
        }
    }
    public void escribePizarrin(){
        for(int i=0;i<10;i++){
            int aleatorio = (int) (Math.random()*26);
            this.pizarrin+=abecedario[aleatorio];

        }
    }

    @Override
    public void entraNino(Nino nin){
        super.entraNino(nin);
        this.pasaNino(nin);
    }

    public void pasapizarraNino(){
        int i =0;
        for (i=0;i<this.ninos.size();i++){
            if(this.ninos.get(i).getTextopizarraout().equals("")){
                if(i==0){
                    System.out.println("El "+this.ninos.get(i).getNombre()+" recibe en su pizarra:"+this.pizarrin);
                    this.ninos.get(i).setTextopizarrain(this.pizarrin);
                }else{
                    System.out.println("El "+this.ninos.get(i).getNombre()+" recibe en su pizarra:"+this.ninos.get(i-1).getTextopizarraout());
                    this.ninos.get(i).setTextopizarrain(this.ninos.get(i-1).getTextopizarraout());
                }
                break;
            }
        }
        if(i==this.ninos.size()){
            this.ninos.get(i-1).escribePizarron();
            this.partidainiciada = false;
            System.out.println("Partida terminada");
            this.partidaTerminada = true;
            this.pizarrin = "";
        }
    }
    public void setPartidaTerminada(boolean res) {
        this.partidaTerminada = res;
    }
    public boolean getPartidaTerminada() {
        return this.partidaTerminada;
    }
    public void vaciaCola(){
        this.ninos= new ArrayList<Nino>();
    }

}
