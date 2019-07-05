public class Main {

    public static void main(String[] args) {
        Methods list = new Methods();

        for(int i=1; i<=10; i++){
            list.addToHead(i);
        }
        list.makeCyclic(11);

        System.out.println(list.IsCyclic());
    }
}
