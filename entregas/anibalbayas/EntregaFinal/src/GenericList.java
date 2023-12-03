

public class GenericList<T extends Jugador> {

    private GenericNode<T> first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        GenericNode<T> iterator = first;
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
        GenericNode<T> newNode = new GenericNode<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void insertEnd(T value) {
        GenericNode<T> newNode = new GenericNode<T>(value);
        if (this.first == null)
            this.first = newNode;
        else {
            GenericNode<T> iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public T deleteFront() {
        GenericNode<T> delete = null;
        if (this.first != null) {
            delete = this.first;
            this.first = this.first.getNext();
        }
        return delete.getValue();
    }

    public GenericNode<T> getFirst() {
        return this.first;
    }

    public GenericNode<T> getLast() {
        GenericNode<T> iterator = this.first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    public T[] listAll() {
        T[] list = (T[]) new Object[this.size()];

        GenericNode<T> iterator = this.first;

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
        GenericNode<T> iterator = this.first;
        GenericNode<T> anterior = null;
        boolean fin = true;
        while (iterator != null) {
            T objeto = iterator.getValue();
            if (iterator == this.first && objeto.conseguirtPizarrin().equals("")) {
                objeto.actualizarPizarrin(mensaje);
                iterator.setValue(objeto);
                anterior = this.first;
                fin = false;
                System.out.println("minutos " + minuto + " crio " + objeto.mostrarValores());

            } else if (objeto.conseguirtPizarrin().equals("")) {
                T aux = anterior.getValue();
                objeto.actualizarPizarrin(Texto.cambiarLetra(aux.conseguirtPizarrin()));
                iterator.setValue(objeto);
                anterior = iterator;
                fin = false;
                System.out.println("minutos " + minuto + " crio " + objeto.mostrarValores());
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
        GenericNode<T> iterator = this.first;
        while (iterator != null) {
            deleteFront();
            iterator = iterator.getNext();
        }

    }

    public void resetear() {
        GenericNode<T> iterator = this.first;

        while (iterator != null) {
            T objeto = iterator.getValue();
            objeto.actualizarPizarrin("");
            iterator.setValue(objeto);
            iterator = iterator.getNext();
        }
    }

    public void listar() {
        GenericNode<T> iterator = this.first;

        while (iterator != null) {
            T objeto = iterator.getValue();
            System.out.println(objeto.mostrarValores());
            iterator = iterator.getNext();
        }
    }

}
