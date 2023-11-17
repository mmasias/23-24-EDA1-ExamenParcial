public class ColaNiños {
    private List<Niño> niños;
    private int niñosEnCola;

    public ColaNiños() {
        niños = new List<>();
        this.niñosEnCola = 0;
    }

    public int getNiñosEnCola() {
        return niñosEnCola;
    }

    public void addNiño(Niño niño) {
        niños.insert(niño, -1);
        niñosEnCola++;
        System.out.println("Hay un nuevo niño");
    }

    public Niño getPrimerNiño(){
        if (niñosEnCola > 0) {
            Niño niñoActual = niños.getFirst().getData();
            return niñoActual;
        } else {
            return null;
        }
    }
    public void pasarMensaje() {
        if (niñosEnCola > 0) {
            //System.out.println("Niño pasó el mensaje al siguiente niño.");
            niños.removeFirst();
            niñosEnCola--;
        } else {
            System.out.println("No hay niños en la cola.");
        }
    }
}