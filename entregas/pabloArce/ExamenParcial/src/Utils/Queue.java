package Utils;

import static Utils.Utils.SysOut;

public class Queue<T> implements IDataStructure<T> {
    private Node<T> head;
    private Node<T> tail;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T data){
        Node<T> node = new Node<T>(data);
        if (tail != null){
            tail.setNext(node);
        }
        tail = node;
        if (head == null){
            head = node;
        }
    }

    public T dequeue(){
        return dequeue(1);
    }
    private T dequeue(int quantity){
        if (head == null){
            return null;
        }
        T data = head.getData();
        head = head.getNext();
        if (head == null){
            tail = null;
        }
        return data;
    }

    public T peek(int end){
        if (end == 1) {
            return head.getData();
        } else if(end == -1) {
            return tail.getData();
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        Node<T> current = head;

        while (current != null) {
            count++;
            current = current.getNext();
        }

        return count;
    }

    @Override
    public void listData() {
        for (int i = 0; i < this.size(); i++) {
            SysOut(this.peek(i));
        }
    }
}
