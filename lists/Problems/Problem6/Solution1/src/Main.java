public class Main {

    public static void main(String[] args) {
        Methods firstList = new Methods();
        Methods secondList = new Methods();
        Methods convergedList = new Methods();

        for(int i=11; i<=20; i++){
            convergedList.addToHead(i);
        }

        for(int i=1; i<=10; i++){
            firstList.addToHead(i);
        }

        firstList.join(convergedList.head);

        for(int i=1; i<=5; i++){
            secondList.addToHead(i);
        }

        secondList.join(convergedList.head);

        System.out.println(firstList.convergentNode(firstList.head, secondList.head));

    }
}
