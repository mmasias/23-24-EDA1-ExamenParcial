public class Cola {
    private List<Niño> niños;

    public Cola() {
        niños = new List<>();
    }

    public void añadirNiño(Niño niño) {
        niños.insert(niño, -1);
    }

    public Niño quitarNiño() {
        if (!niños.isEmpty()) {
            Niño niño = niños.getFirst().getData();
            niños.remove(0);
            return niño;
        }
        return null;
    }

    public boolean estaVacia() {
        return niños.isEmpty();
    }

    public int contarNiños() {
        return niños.size();
    }

    public void mostrarNiños() {
        Node<Niño> actual = niños.getFirst();
        while (actual != null) {
            System.out.print(actual.getData().getNombre() + " / ");
            actual = actual.getNext();
        }
        System.out.println();
    }}