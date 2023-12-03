public class Queue {
    private List<Child> children;
    private int childrenInQueue;

    public Queue() {
        children = new List<Child>();
        childrenInQueue = 0;
    }

    public void addChild(Child child) {
        children.insert(child, -1);
        childrenInQueue++;
    }

    public Child removeChild() {
        Child departing = children.getFirst().getData();
        children.remove(0);
        childrenInQueue--;
        return departing;
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
        Node<Child> current = children.getFirst();
        while (current != null) {
            System.out.print(current.getData().getName() + " / ");
            current = current.getNext();
        }
        System.out.println();
    }
}
