public class ColaNinos {
    private List<Nino> ninos;
    private int ninosEnCola;

    public ColaNinos() {
        ninos = new List<>();
        this.ninosEnCola = 0;
    }

    public int getNinosEnCola() {
        return ninosEnCola;
    }

    public void addNino(Nino nino) {
        ninos.insert(nino, -1);
        ninosEnCola++;
        System.out.println("Hay un nuevo nino");
    }

    public Nino getPrimerNino(){
        if (ninosEnCola > 0) {
            Nino ninoActual = ninos.getFirst().getData();
            return ninoActual;
        } else {
            return null;
        }
    }
    public void pasarMensaje() {
        if (ninosEnCola > 0) {
            ninos.removeFirst();
            ninosEnCola--;
        } else {
            System.out.println("No hay ninos en la cola.");
        }
    }
}