import estructuraDatos.List;
import estructuraDatos.Node;

public class Cola {
    private List<Niño> niños;
    private int niñosEnCola;

    public Cola() {
        niños = new List<>();
        niñosEnCola = 0;
    }

    public void addNiño(Niño niño) {
        niños.insert(niño, -1);
        niñosEnCola++;
    }

    public boolean hayNiños() {
        return !niños.isEmpty();
    }

    public List<Niño> getNiños() {
        return niños;
    }

    public void listaNiños() {
        Node<Niño> current = niños.getFirst();
        while (current != null) {
            System.out.print(current.getData().getNombre() + " / ");
            current = current.getNext();
        }
        System.out.println();
    }
    public int size() {
        return niñosEnCola;
    }
    public Niño removeNiño() {
        if (niñosEnCola > 0) {
            Niño saliente = niños.getFirst().getData();
            niños.remove(0);
            niñosEnCola--;
            return saliente;
        } else {
            return null;
        }
    }
    public Niño removeFirstNiño() {
        if (niñosEnCola > 0) {
            Niño saliente = niños.getFirst().getData();
            niños.remove(0);
            niñosEnCola--;
            return saliente;
        } else {
            return null;
        }
    }
}
