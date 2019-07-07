public class Main {

    public static void main(String[] args) {
        Methods list = new Methods();

        for(int i=10; i>0; i--){
            list.addToHead(i);
        }

        Node current = list.reverseInPair(list.head, list.head.getNextNode());
        while (current!=null){
            System.out.println(current.getData());
            current = current.getNextNode();
        }

    }
}
