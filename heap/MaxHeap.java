import java.util.*;
import java.io.*;

public class MaxHeap{

    int[] Heap;
    int size;
    int maxsize;

    public MaxHeap(int maxsize){
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    }

    /* Helper Methods */
    private int parent(int pos){return pos / 2;} 
    private int leftChild(int pos){ return (2 * pos);}
    private int rightChild(int pos){ return (2 * pos) + 1;}
    private boolean isLeaf(int pos){
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        }
        return false;
    }
    private void swap(int pos1, int pos2){
        int temp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = temp;
    }

    private void maxHeapify(int pos) 
    { 
        if (isLeaf(pos)) 
            return; 

        if (Heap[pos] < Heap[leftChild(pos)] ||  Heap[pos] < Heap[rightChild(pos)]) { 
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    }

    public void add(int element) 
    { 
        Heap[++size] = element; 
        // Traverse up and fix violated property 
        int current = size; 
        while (Heap[current] > Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    }

    public int poll() 
    { 
        int popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped;
    }

    public int peek(){
        return Heap[1];
    }

    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.println(Heap[i] +" "+ Heap[2 * i] +" "+ Heap[2 * i + 1]);
        } 
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15); 
        maxHeap.add(5); 
        maxHeap.add(3); 
        maxHeap.add(17); 
        maxHeap.add(10); 
        maxHeap.add(84); 
        maxHeap.add(19); 
        maxHeap.add(6); 
        maxHeap.add(22); 
        maxHeap.add(9); 

        System.out.println(maxHeap.peek());
        maxHeap.poll();
        System.out.println(maxHeap.peek());

        //maxHeap.print(); 
    }
}