public class Stack {

    private int[] dataArray;
    private int capacity;
    private int count;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.dataArray = new int[capacity];
        this.count = 0;
    }

    public boolean push(int data){
        if (capacity == count) {
            return false;
        }
        dataArray[count++] = data;
        return true;

    }

    public int peek(){
        if(count == 0){
            return dataArray[0];
        }
        return dataArray[count-1];
    }

    public void pop(){
        if(count == 0){
            return;
        }
        count--;
    }
}
