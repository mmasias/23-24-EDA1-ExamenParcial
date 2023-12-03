public class List {
    private Node first = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(String value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            Node iterator = first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        size++;
    }

    public void delete() {
        if (first != null) {
            if (size == 1) {
                first = null;
            } else {
                Node iterator = first;
                Node previous = null;
                while (iterator.getNext() != null) {
                    previous = iterator;
                    iterator = iterator.getNext();
                }
                previous.setNext(null);
            }
            size--;
        }
    }

    public String[] listAll() {
        String[] list = new String[size];
        Node iterator = first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public void printList() {
        String[] children = listAll();
        System.out.println("Lista de niños:");
        for (String child : children) {
            System.out.println(child);
        }
    }
    
    public boolean hasMoreThanFiveChildren() {
        return size > 5;
    }
}
