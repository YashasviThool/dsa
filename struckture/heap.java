package struckture;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class heap<T extends Comparable<T>>{
    private ArrayList<T> list;
    public heap(){
        list=new ArrayList<>();
    }

    void swap(int i,int j){
        T temp=list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return (2 * index)+1;
    }
    private int right(int index){
        return (2 * index)+2;
    }
    public void insert(T value){
        list.add(value);
        unheap(list.size()-1);
    }
    private void unheap(int index){
        int p=parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index, p);
            unheap(p);
        }
    }
    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("heap is empty");
        }
        T temp=list.get(0);
        T last =list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }
    public int size(){
        return list.size();
    }

    private void downheap(int index ) {
        int min=index;
        int left=left(index);
        int right=right(index);
        if(left<list.size() && list.get(min).compareTo(list.get(left))>0){
            min=left;
        }
        if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min=right;
        }
        if(min!=index){
            swap(min, index);
            downheap(min);
        }
    }
    public ArrayList<T> get_list(){
        return list;
    }
    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data=new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        list=data;
        return data;
    }
    public static void main(String[] args) throws Exception{
        heap<Integer> heap =new heap<>();
        heap.insert(6); 
        heap.insert(8);
        heap.insert(5);
        heap.insert(10);
        heap.insert(1);
        heap.insert(2);
        heap.insert(14);
        System.out.println(heap.heapSort());
        for(int i=0;i<6;i++){
            
            System.out.println(heap.remove());
            System.out.println(heap.get_list());
        }
    }
}
