import Utils.Queue;

public class Test {
    public static void main(String args[]) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.getNodeData(4));
    }
}
