public class List<T> {

    private Node<T> first = null;

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
            Node<T> iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(nodoQueEntra);
        }
        System.out.println("> llego "+value);
    }


    public void insertFirst(Node<T> nuevo){

        nuevo.setNext(first);
        first= nuevo;
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
            System.out.println("Se fue "+iterator.getValue());
        }
    }
    public Node<T> search(T value){
        Node<T> iterator = this.first;
        Node<T> r=null;
        while (iterator!=null){
            if (iterator.getValue().equals(value)){
                r=iterator;
                break;
            }
            iterator=iterator.getNext();
        }
        return r;
    }

    public void deleteFirst(){
        first=first.getNext();

    }
    public void deleteall(){
        first=null;

    }
    public Node<T>  deleteMidSide(T value){
        Node<T> iterator= this.first;
        Node<T> anterior= first;
        while (iterator!=null){
            if(iterator.getValue()==value){
                anterior.setNext(iterator.getNext());
                return iterator;
            }else{
                anterior=iterator;
            }
            iterator=iterator.getNext();
        }

        return null;
    }
    public boolean insertPos(Node<T> n, int pos){
        Node<T> nodoQueEntra = new Node<T>((T) n);

        if(pos==0){
            insertFirst(n);
        } else if( pos >=this.size()){
            insert(n.getValue());
        }else{
            Node<T> iterator=first;
            int i=1;
            while (iterator!=null){
                if (i==pos){
                    n.setNext(iterator.getNext());
                    iterator.setNext(n);
                }
                i++;
                iterator=iterator.getNext();
            }
        }
        return false;
    }
    /*public boolean deletePos(Node<T> n, int pos){
            if (pos==0){
                first=first.getNext();
            } else if (pos >=this.size()) {
                delete(n.getValue());
            }
    }*/
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

}
