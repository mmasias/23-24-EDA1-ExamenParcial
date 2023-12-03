package entregas.diegoGarcia.ExamenParcial;

public class GenericList<T extends IDataStructure> {

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
    public boolean sendMessage(String message, int minute) {
        GenericNode<T> iterator = this.first;
        GenericNode<T> previous = null;
        boolean end = true;
        while (iterator != null) {
            T object = iterator.getValue();
            if (iterator == this.first && object.takeBlackboard().equals("")) {
                object.updateBlackboard(message);
                iterator.setValue(object);
                previous = this.first;
                end = false;
                System.out.println("Minute " + minute + object.showValues());

            } else if (object.takeBlackboard().equals("")) {
                T aux = previous.getValue();
                object.updateBlackboard(Text.randomLetterChange(aux.takeBlackboard()));
                iterator.setValue(object);
                previous = iterator;
                end = false;
                System.out.println("Minute " + minute + object.showValues());
            } else {
                previous = iterator;

            }
            if (!end) {
                break;
            }

            iterator = iterator.getNext();
        }
        return end;
    }

    public void empty() {
        GenericNode<T> iterator = this.first;
        while (iterator != null) {
            deleteFront();
            iterator = iterator.getNext();
        }

    }

    public void reset() {
        GenericNode<T> iterator = this.first;

        while (iterator != null) {
            T object = iterator.getValue();
            object.updateBlackboard("");
            iterator.setValue(object);
            iterator = iterator.getNext();
        }
    }

    public void printLine(){
        System.out.println("=".repeat(60));
    }

    public void list() {
        GenericNode<T> iterator = this.first;

        printLine();
        while (iterator != null) {
            T object = iterator.getValue();
            System.out.println( object.showValues());
            iterator = iterator.getNext();
        }
        printLine();    
    }
}
