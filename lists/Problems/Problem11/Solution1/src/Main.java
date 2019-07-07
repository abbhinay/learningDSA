public class Main {

    public static void main(String[] args) {
        Methods list = new Methods();

        list.addToHead(1);
        list.addToHead(2);
        list.addToHead(3);
        list.addToHead(4);
        list.addToHead(5);
        list.addToHead(4);
        list.addToHead(3);
        list.addToHead(2);
        list.addToHead(1);

        System.out.println(list.isPalindrom());

    }
}
