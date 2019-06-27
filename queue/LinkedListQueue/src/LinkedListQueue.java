public class LinkedListQueue {
    private Node head;

    public void add(int data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    public int peek(){
        Node current = head;
        while(current.getNextNode()!=null){
            current = current.getNextNode();
        }
        return current.getData();
    }

    public int pop(){
        Node current = head;
        while(current.getNextNode().getNextNode()!= null){
            current = current.getNextNode();
        }
        int temp = current.getNextNode().getData();
        current.setNextNode(null);
        return temp;
    }
}
