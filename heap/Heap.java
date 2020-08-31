import java.util.*;
import java.io.*;

class Heap{
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        list = new ArrayList<>();
        insert(20);
        insert(13);
        insert(14);
        insert(9);
        insert(8);
        insert(7);
        insert(10);
        insert(10);
        System.out.println(remove());
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+ " ");
        }
    }

    public static void insert(int no){
        list.add(no);
        int current = list.size()-1;
        if(list.size()>1){
            int index = (current-1)/2;
            while(index>=0){
                if(list.get(index)<list.get(current)){
                    int temp = list.get(current);
                    list.set(current, list.get(index));
                    list.set(index, temp);
                    current = index;
                    index = (current-1)/2;
                }else{
                    break;
                }
            }
        }
    }

    public static int remove(){
        if(list.size()==0) return -1;
        if(list.size()==1){
            int root = list.get(0);
            list.remove(0);
            return root;
        }
        else{
            int root = list.get(0);
            list.set(0, list.size()-1);
            list.remove(list.size()-1);
            int right = 0;
            int left = 1;
            int current = 0;
            while(left<list.size()){
                right = left+1;
                if(right < list.size()){
                    if(list.get(left)>list.get(right)){
                        if(list.get(left)>list.get(current)){
                            int temp = list.get(left);
                            list.set(left, list.get(current));
                            list.set(current, temp);
                            current = left;
                            left = (2*current)+1;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        if(list.get(right)>list.get(current)){
                            int temp = list.get(right);
                            list.set(right, list.get(current));
                            list.set(current, temp);
                            current = right;
                            left = (2*current)+1;
                        }
                        else{
                            break;
                        }
                    }
                }
                else if(left < list.size()){
                    if(list.get(left)>list.get(current)){
                        int temp = list.get(left);
                        list.set(left, list.get(current));
                        list.set(current, temp);
                        current = left;
                        left = (2*current)+1;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
            return root;
        }
    }
}