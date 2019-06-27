import java.lang.reflect.Array;

public class ArrayQueue {
    private int[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity){
        queue = new int[capacity];
        front = 0;
        back = 0;
    }

    public void add(int data){

        if(size() == queue.length-1){
            int tempBack = size();
            int[] newArray = new int[2*queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length-front );
            System.arraycopy(queue, 0, newArray, queue.length-front, back);
            queue = newArray;
            front = 0;
            back = tempBack;
        }
        queue[back] = data;

        if(back<queue.length-1){
            back++;
            return;
        }



        back = 0;
        return;


    }

    public void remove(){
        if(size()==0){
            return;
        }

        if(front<queue.length-1){
            front++;
        }

        if(front == queue.length-1){
            front = 0;
        }
    }

    public int peek(){
        if(size()==0){
            return -1;
        }
        return queue[front];
    }

    public int size(){
        if(front <= back){
            return back-front;
        }else{
            return back-front+queue.length;
        }
    }
}
