public class Main {

    public static void main(String[] args) {
        Methods list = new Methods();

        for(int i=1; i<=10; i++){
            list.addToHead(i);
        }

        Node reverseHead = list.reverseList();
        while(reverseHead!=null){
            System.out.println(reverseHead.getData());
            reverseHead = reverseHead.getNextNode();
        }

    }
}
