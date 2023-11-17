public class List <T>{
    Node<T> first;

    public List<T> insert(T data, int index) {
        if (first == null && (index == 0 || index == -1)) {
            first = new Node<T>(data);
        } else if (index == 0) {
            insertFirst(new Node<T>(data));
        } else if (index == -1) {
            insertLast(new Node<T>(data));
        } else if (index > 0) {
            insertAt(new Node<T>(data), index);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private void insertFirst(Node<T> node) {
        node.setNext(first);
        first = node;
    }

    private void insertLast(Node<T> node) {
        Node<T> last = first;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(node);
    }

    private void insertAt(Node<T> node, int index) {
        int i = 0;
        Node<T> current = first;
        while (i < index - 1 && current != null) {
            ++i;
            current = current.getNext();
        }
        if (current != null) {
            node.setNext(current.getNext());
            current.setNext(node);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public void removeFirst() {
        first = getFirst().getNext();
    }
    public Node<T> getFirst() {
        return first;
    }
}