public class Node<T> {
    private T element;
    private Node<T> nextNode;

    public Node(T element) {
        setElement(element);
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public int count() {
        if (getNextNode() == null) {
            return 1;
        } else {
            return 1 + getNextNode().count();
        }
    }
}