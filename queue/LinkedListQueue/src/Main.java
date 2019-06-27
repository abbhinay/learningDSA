public class Main {

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        queue.pop();
        System.out.println(queue.peek());

    }
}
