public class Cola {
    private List<Niño> niños;
    private int numeroNiñosCola;
    public Cola() {
        niños = new List<Niño>();
        numeroNiñosCola = 0;
    }  
    public void agregarNiño(Niño niño) {
        niños.insert(niño, -1);
        numeroNiñosCola++;
    }
    public Niño removeNiño() {
        Niño saliente = niños.getFirst().getData();
        niños.remove(0);
        numeroNiñosCola--;
        return saliente;
    }
    public int getNumeroNiñosCola() {
        return numeroNiñosCola;
    }
    public boolean estaVacia() {
        return niños.isEmpty();
    }
    public int size() {
        return niños.size();
    }
    public List<Niño> getNiños() {
        return niños;
    }
    public void listarNiños() {
        Node<Niño> current = niños.getFirst();
        while (current != null) {
            System.out.print(current.getData().getNombre() + " / ");
            current = current.getNext();
        }
        System.out.println();
    }
    
}
