public class Fila {
    private Niño first = null;
    private int size;

    public Fila() {
    }

    public void añadirNiño(Niño niño){
        Niño last = first;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(niño);
        size++;
    }

    public void removerNiño(){
        if (first.getNext() != null){
            Niño i = first;
            while (i.getNext() != null && i.getNext().getNext() != null) {
                i = i.getNext();
            }
            i.setNext(null);
            size--;
        } else {
            first = null;
        }
    }

    public int getSize() {
        return this.size;
    }

    public Niño getFirst(){
       return first;
    }


}
