public class Cola {
    private List<Niño> niños;
    private int niñosEnCola;

    public Cola() {
        niños = new List<Niño>();
        niñosEnCola = 0;
    }

    public void addNiño(Niño niño) {
        niños.insert(niño, -1);
        niñosEnCola++;
    }

    public Niño removeNiño() {
        Niño saliente = niños.getFirst().getData();
        niños.remove(0);
        niñosEnCola--;
        return saliente;
    }

    public boolean hayNiños() {
        return !niños.isEmpty();
    }

    public int numeroNiños() {
        return niñosEnCola;
    }

    public int size() {
        return niñosEnCola;
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
}
