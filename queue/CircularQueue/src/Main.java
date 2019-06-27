public class Main {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.remove();

        System.out.println(queue.peek());
    }
}
