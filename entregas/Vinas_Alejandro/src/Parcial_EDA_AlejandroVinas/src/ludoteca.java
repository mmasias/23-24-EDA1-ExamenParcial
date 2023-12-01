import java.util.Random;
public class ludoteca {

    Monitora lidia = null;
    Aisha aysa = null;

    public ludoteca() {
        this.lidia = new Monitora("Lidia");
        this.aysa = new Aisha("Aysa");
        this.aysa.escribePizarrin();
    }

    public void abreludoteca(){

        int m=0;
        int numninosminuto = 0;
        while (m<120){
            System.out.println("Minuto "+m);
            System.out.println("Lista Lidia: "+lidia.dameLista());
            System.out.println("Lista Aisha: "+aysa.dameLista());
            numninosminuto=dimeNumNunosllegan(m);
            if(numninosminuto!=0){
                gestionaLlegaNino(numninosminuto,m);
            }else{
                gestionaNoLlegaNino();
            }
            m++;
        }
    }

    private int cuentaNin(){
         return this.lidia.getNinos().size() + this.aysa.getNinos().size();
    }

    private void gestionaNoLlegaNino(){
        if(this.aysa.isPartidainiciada()){
            this.aysa.pasapizarraNino();
        }else{
            if(this.aysa.getNinos().size()==5){
                if(this.aysa.getPartidaTerminada()){
                    this.aysa.setPartidaTerminada(false);
                    for(Nino nin:this.aysa.getNinos()){
                        this.lidia.getNinos().add(nin);
                        this.aysa.vaciaCola();
                        this.aysa.escribePizarrin();
                        this.aysa.entraNino(this.lidia.getNinos().get(0));
                        this.lidia.getNinos().remove(0);
                    }
                }else{
                    this.aysa.pasapizarraNino();
                }
            }else{
                if(this.lidia.getNinos().size()>0){
                    this.aysa.entraNino(this.lidia.getNinos().get(0));
                    this.lidia.getNinos().remove(0);
                }

            }
        }
    }

    private void gestionaLlegaNino(int numninosminuto,int k){
        if(this.aysa.isPartidainiciada()){
            for (int j=0;j<numninosminuto;j++){
                this.lidia.entraNino(new Nino("Nino"+cuentaNin()+""));
            }
            this.aysa.pasapizarraNino();
        }else{
            for(int j=0;j<numninosminuto;j++){
                this.lidia.entraNino(new Nino("Nino"+cuentaNin()));
                if(this.aysa.getNinos().size()<5){
                    this.aysa.entraNino(this.lidia.getNinos().get(0));
                    this.lidia.getNinos().remove(0);
                }else{
                    if(this.aysa.getNinos().size()==5){
                        if(this.aysa.getPartidaTerminada()){
                            this.aysa.setPartidaTerminada(false);
                            for(Nino nin:this.aysa.getNinos()){
                               nin.setPizarrin("");
                               nin.setTextopizarraout("");
                               this.lidia.getNinos().add(nin);
                            }
                            this.aysa.vaciaCola();
                            this.aysa.escribePizarrin();
                            this.aysa.entraNino(this.lidia.getNinos().get(0));
                            this.lidia.getNinos().remove(0);
                    }else{
                            this.aysa.pasapizarraNino();}
                    }
                }
            }
        }


    }

    private int dimeNumNunosllegan(int i) {
        int num = 0;
        if (i < 10) {
            Random random = new Random();
            num = random.nextInt(3);
        } else {
            num = 0;
            if (i < 30) {
                Random random = new Random();
                int lleganino = random.nextInt(10);
                if (lleganino <= 5) {
                    num = 1;
                }
            }
        }
        return num;
    }
}
