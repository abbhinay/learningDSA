public class Main {

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.push(6);
        System.out.println(stack.peek());
    }
}
