public class List {
    private Node head;

    public List() {
        this.head = null;
    }

    public void insert(Niño value) {
        Node newNode = new Node(value);
        newNode.setNext(head);
        head = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    public void removeHead() {
        if (!isEmpty()) {
            head = head.getNext();
        }
    }

    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}