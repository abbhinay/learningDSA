package com.company;

public class LinkedList {

    private Node head;

    public void add(int data){
        Node current = new Node(data);
        current.setNextNode(head);
        current.setPreviousNode(null);
        head = current;
    }

    public void remove(){
        head = head.getNextNode();
    }

    public void insertAtEnd(int data){
        Node current = head;
        Node newNode = new Node(data);
        while(current.getNextNode() != null){
            current = current.getNextNode();
        }
        current.setNextNode(newNode);
        newNode.setPreviousNode(current);
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
            add(data);
            return;
        }
        else if(position == length()+1){
            insertAtEnd(data);
            return;
        }
        else if(position < 1 || position > length()+1){
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
        newNode.setPreviousNode(current);
        current.getNextNode().setPreviousNode(newNode);
        current.setNextNode(newNode);
    }

    public void removeAt(int position){
        if(position == 1){
            remove();
            return;
        }
        else if(position == length()+1){
            removeAtEnd();
            return;
        }
        else if(position < 1 || position > length()+1){
            return;
        }

        Node current = head;
        int count = 1;
        while(count != position-1){
            current = current.getNextNode();
            count++;
        }
        current.getNextNode().getNextNode().setPreviousNode(current);
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

    public boolean find(int data){
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
        String data = "";
        while(current != null){
            data += current.toString();
            current = current.getNextNode();
        }
        return data;
    }
}
