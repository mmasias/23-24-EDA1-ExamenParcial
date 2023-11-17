import com.sun.jdi.Value;

public class List<T>{

    private Node <T>first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        } else {
            int count = 1;
            Node<T> iterator = first;
            while (iterator.getNext() != null) {
                count++;
                iterator = iterator.getNext();
            }
            return count;
        }
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insert(T value) {
        Node<T> nodoQueEntra = new Node<T>(value);
        if (this.first == null)
            this.first = nodoQueEntra;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
    }

    public void delete() {
        if (this.first != null) {
            Node<T> iterator = this.first;
            Node<T> previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
        }
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node<T> iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = String.valueOf(iterator.getValue());
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
    public T deleteFront() {
        T resultado= null;
        
        if (this.first != null) {
            resultado= this.first.getValue();
            this.first = this.first.getNext();
        }
        return resultado;
    }
    public void insertFirst(T value){
       Node<T> nuevo = new Node<>(value);
       nuevo.setNext(first);
       first = nuevo;
    }
    
    public Node<T> search(T value){
        Node<T> iterator = first;
        Node<T> buscado = null;
        while (iterator != null){
            if(iterator.getValue() == value){
                buscado = iterator;
                break;
            }
            iterator = iterator.getNext();
        }
        return buscado;

    }
    public void vaciar(){
       first=null;
    }
    public Node<T> deleteValue(T value){
        Node<T> iterator = first;
        Node<T> anterior = first;
        while (iterator != null){
            if (iterator.getValue() == value ){
                anterior.setNext(iterator.getNext());
                return iterator;
            }else{
                anterior = iterator;

            }
            iterator = iterator.getNext();
        }
        return null;

    }
    
}
