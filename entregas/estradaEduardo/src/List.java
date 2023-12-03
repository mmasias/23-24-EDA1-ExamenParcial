public class List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public List() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void addEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    public void addFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
        size++;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T data = first.getData();
        first = first.getNext();

        if (first == null) {
            last = null;
        }
        size--;

        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Object[] listAll() {
        Object[] elements =  new Object[size];
        Node<T> current = first;
        int index = 0;

        while (current != null) {
            elements[index++] = current.getData();
            current = current.getNext();
        }

        return elements;
    }
}
