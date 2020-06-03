public class Main {

    public static void main(String[] args) {
        Methods list = new Methods();

        for(int i=10; i>0; i--){
            list.addToHead(i);
        }

        //list.reverse(4, list.head);
        Node current = list.reverse(4, list.head);
        while(current!=null){
            System.out.println(current.getData());
            current = current.getNextNode();
        }

    }
}
