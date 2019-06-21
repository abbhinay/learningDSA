package com.company;

public class Main {

    public static void main(String[] args) {
	    LinkedList list = new LinkedList();
	    list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(4);
        list.addToHead(5);
        list.addToHead(6);
        list.addToHead(7);
        
        list.removeFromHead();

        list.insertAtEnd(10);
        list.removeAtEnd();
        list.insertAt(4, 22);

        System.out.println(list.find(10));

        System.out.println(list.length());
        System.out.println(list.toString());
    }
}
