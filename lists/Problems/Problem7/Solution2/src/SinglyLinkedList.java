import java.util.HashMap;
import java.util.Map;

public class SinglyLinkedList {
    protected Node head;

    public void addToHead(int data){
        Node current = new Node(data);
        current.setNextNode(head);
        head = current;
    }

    public void removeFromHead(){
        head = head.getNextNode();
    }

    public void insertAtEnd(int data){
        Node current = head;
        Node newNode = new Node(data);

        while(current.getNextNode() != null){
            current = current.getNextNode();
        }

        current.setNextNode(newNode);
    }

    public void removeAtEnd(){
        Node current = head;
        while(current.getNextNode().getNextNode() != null){
            current = current.getNextNode();
        }
        current.setNextNode(null);
    }

    public void insertAt(int position, int data){
        if(position == 1){
            addToHead(data);
            return;
        }else if(position == length()+1){
            insertAtEnd(data);
            return;
        }else if(position < 1 || position > length()+1){
            return;
        }

        Node current = head;
        Node newNode = new Node(data);
        int count = 1;

        while(count != position-1){
            current = current.getNextNode();
            count++;
        }
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);

    }

    public void removeAt(int position){
        if(position == 1){
            removeFromHead();
            return;
        }else if(position == length()+1){
            removeAtEnd();
            return;
        }else if(position < 1 || position > length()+1){
            return;
        }

        Node current = head;
        int count = 1;

        while(count != position-1){
            current = current.getNextNode();
            count++;
        }
        current.setNextNode(current.getNextNode().getNextNode());
    }

    public int length(){
        Node current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.getNextNode();
        }
        return count;
    }

    public boolean find (int data){
        Node current = head;
        while(current != null){
            if(current.getData() == data)
                return true;
            current = current.getNextNode();
        }
        return false;
    }

    public String toString(){
        Node current = head;
        String list = "";
        while(current!= null){
            list += current.toString();
            current = current.getNextNode();
        }
        return list;
    }
}

class Methods extends SinglyLinkedList{

    public int findMiddle(){

        Node slowIterator = head;
        Node fastIterator = head;

        try{
            while(fastIterator!=null){
                slowIterator = slowIterator.getNextNode();
                fastIterator = fastIterator.getNextNode().getNextNode();
            }
        }catch (Exception e){
            //slowIterator = slowIterator.getNextNode();
        }

        return slowIterator.getData();

    }
}
