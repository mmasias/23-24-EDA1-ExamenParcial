class List<T> {
    private Node<T> first = null;

    public List() {
    }

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node<T> iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return (this.size() > 0) ? true : false;
    }

    public void insertFront(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void insertEnd(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node<T> iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
        }
    }

    public Node<T> getFirst() {
        return this.first;
    }

    public Node<T> getLast() {
        Node<T> iterator = this.first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    // public T[] listAll() {
    //     T[] list = (T[]) new Object[this.size()];
    //     Node<T> iterator = this.first;
    //     if (iterator == null) {
    //         return list;
    //     }
    //     int count = 0;
    //     while (iterator != null) {
    //         list[count] = iterator.getValue();
    //         count++;
    //         iterator = iterator.getNext();  
    //     }
    //     return list;
    // }

}