public class List<T extends Jugador> {

    private Node<T> first = null;

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
        return this.size() > 0 ? false : true;
    }

    public void insertFront(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void insertEnd(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node<T> iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public T deleteFront() {
        Node<T> delete = null;
        if (this.first != null) {
            delete = this.first;
            this.first = this.first.getNext();
        }
        return delete.getValue();
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

    public T[] listAll() {
        T[] list = (T[]) new Object[this.size()];

        Node<T> iterator = this.first;

        if (iterator == null)
            return list;

        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public boolean pasarMensaje(String mensaje, int minuto) {
        Node<T> iterator = this.first;
        Node<T> anterior = null;
        boolean fin = true;
        while (iterator != null) {
            T objeto = iterator.getValue();
            if (iterator == this.first && objeto.conseguirtPizarrin().equals("")) {
                objeto.actualizarPizarrin(mensaje);
                iterator.setValue(objeto);
                anterior = this.first;
                fin = false;
                System.out.println("Minuto " + minuto + objeto.mostrarValores());

            } else if (objeto.conseguirtPizarrin().equals("")) {
                T aux = anterior.getValue();
                objeto.actualizarPizarrin(Texto.cambiarLetra(aux.conseguirtPizarrin()));
                iterator.setValue(objeto);
                anterior = iterator;
                fin = false;
                System.out.println("Minuto " + minuto + objeto.mostrarValores());
            } else {
                anterior = iterator;

            }
            if (!fin) {
                break;
            }

            iterator = iterator.getNext();
        }
        return fin;
    }

    public void vaciar() {
        Node<T> iterator = this.first;
        while (iterator != null) {
            deleteFront();
            iterator = iterator.getNext();
        }

    }

    public void resetear() {
        Node<T> iterator = this.first;

        while (iterator != null) {
            T objeto = iterator.getValue();
            objeto.actualizarPizarrin("");
            iterator.setValue(objeto);
            iterator = iterator.getNext();
        }
    }

    public void listar() {
        Node<T> iterator = this.first;

        System.out.println("\033[33m" + "--------------------------------");
        while (iterator != null) {
            T objeto = iterator.getValue();
            System.out.println("\033[33m" + objeto.mostrarValores() + "\u001B[0m");
            iterator = iterator.getNext();
        }
        System.out.println("\033[33m" + "--------------------------------");
    }
}