package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.remove();
        list.insertAtEnd(9);
        list.removeAtEnd();
        list.insertAt(4, 22);
        list.removeAt(4);

        System.out.println(list.length());
        System.out.println(list.find(5));
        System.out.println(list.toString());
    }
}
