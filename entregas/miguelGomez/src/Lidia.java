public class Lidia {
 private list<Nino> ninos;
 private int ninoscola;

    public Lidia() {
        ninos = new List<Nino>();
        ninoscola = 0;

}
    public void addNino(Nino nino){
        ninos.insert(nino);
        ninoscola++;
    }
    public Nino removeNino(Nino nino){
        Nino sale = Nino.getFirst();
        ninos.removeFirst();
        ninoscola--;
        return Ninosale;
    }

}
