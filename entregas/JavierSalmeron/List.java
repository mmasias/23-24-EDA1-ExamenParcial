public class List {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void insertEnd(Pizarra pizarra) {
        Jugador nuevoJugador = new Jugador(pizarra);
        Node newNode = new Node(nuevoJugador);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }
    
    public void insertFront(String name) {
        Jugador nuevoJugador = new Jugador(new Pizarra(""));
        Node newNode = new Node(nuevoJugador);
        if (this.first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void delete() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous == null) {
                this.first = null;
            } else {
                previous.setNext(null);
            }
        }
    }

    public Jugador[] listAll() {
        Jugador[] list = new Jugador[this.size()];
        Node iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getJugador();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public Jugador getNodeAt(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getJugador();
    }

    private class Node {
        private Jugador jugador;
        private Node next;

        public Node(Jugador jugador) {
            this.jugador = jugador;
        }

        public Jugador getJugador() {
            return jugador;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
