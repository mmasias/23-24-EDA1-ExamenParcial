public class Node {
    private Niño value;
    private Node next;

    public Node(Niño value) {
        this.value = value;
        this.next = null;
    }

    public Niño getValue() {
        return value;
    }

    public void setValue(Niño newValue) {
        this.value = newValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
