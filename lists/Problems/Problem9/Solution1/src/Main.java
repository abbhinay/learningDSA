public class Main {

    public static void main(String[] args) {
        Methods firstList = new Methods();
        Methods secondList = new Methods();
        Methods thirdList = new Methods();

        firstList.addToHead(10);
        firstList.addToHead(8);
        firstList.addToHead(6);
        firstList.addToHead(3);
        firstList.addToHead(1);

        secondList.addToHead(11);
        secondList.addToHead(9);
        secondList.addToHead(7);
        secondList.addToHead(5);
        secondList.addToHead(2);


        thirdList.merge(firstList.head, secondList.head, thirdList.head);

        Node current = thirdList.head;
        while(current != null){
            System.out.println(current.getData());
            current = current.getNextNode();
        }
    }
}
