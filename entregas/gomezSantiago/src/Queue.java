public class Queue {
    private List<Child> children;
    private int childrenInQueue;

    public Queue() {
        children = new List<Child>();
        childrenInQueue = 0;
    }

    public void enqueueChild(Child child) {
        children.insert(child, -1);
        childrenInQueue++;
    }

    public Child dequeueChild() {
        Child departingChild = children.getHead().getElement();
        children.remove(0);
        childrenInQueue--;
        return departingChild;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public int numberOfChildren() {
        return childrenInQueue;
    }

    public int size() {
        return childrenInQueue;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void listChildren() {
        Node<Child> current = children.getHead();
        while (current != null) {
            System.out.print(current.getElement().getName() + " / ");
            current = current.getNextNode();
        }
        System.out.println();
    }
}