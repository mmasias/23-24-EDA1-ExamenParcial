public class List<T> implements IDataStructure<T> {

    private Node<T> head;

    public List<T> insert(T element, int index) {
        if (head == null && (index == 0 || index == -1)) {
            head = new Node<>(element);
        } else if (index == 0) {
            insertFirst(new Node<>(element));
        } else if (index == -1) {
            insertLast(new Node<>(element));
        } else if (index > 0) {
            insertAt(new Node<>(element), index);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private void insertFirst(Node<T> node) {
        node.setNextNode(head);
        head = node;
    }

    private void insertLast(Node<T> node) {
        Node<T> last = head;
        while (last.getNextNode() != null) {
            last = last.getNextNode();
        }
        last.setNextNode(node);
    }

    private void insertAt(Node<T> node, int index) {
        int i = 0;
        Node<T> current = head;
        while (i < index - 1 && current != null) {
            ++i;
            current = current.getNextNode();
        }
        if (current != null) {
            node.setNextNode(current.getNextNode());
            current.setNextNode(node);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public List<T> remove(int index) {
        if (!isEmpty()) {
            if (index == 0) {
                removeFirst();
            } else if (index == -1) {
                removeLast();
            } else {
                removeAt(index);
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private void removeFirst() {
        head = head.getNextNode();
    }

    private void removeLast() {
        if (head.getNextNode() != null) {
            Node<T> oneBeforeLast = head;
            while (oneBeforeLast.getNextNode() != null && oneBeforeLast.getNextNode().getNextNode() != null) {
                oneBeforeLast = oneBeforeLast.getNextNode();
            }
            oneBeforeLast.setNextNode(null);
        } else {
            head = null;
        }
    }

    private void removeAt(int index) {
        Node<T> current = head;
        for (int i = 0; i < index - 1; ++i) {
            current = current.getNextNode();
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        if (current.getNextNode() == null) {
            throw new IndexOutOfBoundsException();
        }
        current.setNextNode(current.getNextNode().getNextNode());
    }

    public Node<T> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (head != null) {
            return head.count();
        } else {
            return 0;
        }
    }

    public Object[] listData() {
        Object[] array = new Object[size()];
        Node<T> node = head;
        for (int i = 0; i < array.length; ++i) {
            array[i] = node.getElement();
            node = node.getNextNode();
        }
        return array;
    }
}
