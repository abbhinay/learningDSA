public class LinkedListStack {
    private Node head;

    public void push(int data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    public int peek(){
        return head.getData();
    }

    public void pop(){
        head = head.getNextNode();
    }
}
