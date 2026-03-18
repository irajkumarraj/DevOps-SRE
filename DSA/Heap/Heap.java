package Heap;
import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> minHeap = new ArrayList<>();
    ArrayList<Integer> maxHeap = new ArrayList<>();

    public void addElementToMaxHeap(int data){
        maxHeap.addLast(data);
        heapiFyMaxHeap(maxHeap.size()-1);
    
    }

    private void heapiFyMaxHeap(int index){
        if(index==0){
            return;
        }
        int parent= (index-1)/2;
        if(maxHeap.get(parent)<maxHeap.get(index)){
            int temp= maxHeap.get(parent);
            maxHeap.set(parent, maxHeap.get(index));
            maxHeap.set(index,temp);

            heapiFyMaxHeap(parent);
        }
    }

    public int deleteElementOfMaxHeap(){
        int deleted= maxHeap.getFirst();
        maxHeap.set(0,maxHeap.getLast());
        maxHeap.removeLast();
        deleteMaxHeapify(0);
        return deleted;
    }
    
    private void deleteMaxHeapify(int index) {

        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < maxHeap.size() && maxHeap.get(left) > maxHeap.get(largest)) {
            largest = left;
        }

        if (right < maxHeap.size() && maxHeap.get(right) > maxHeap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            int temp = maxHeap.get(index);
            maxHeap.set(index, maxHeap.get(largest));
            maxHeap.set(largest, temp);

            deleteMaxHeapify(largest);
        }
    }

    public void addElementToMinHeap(int data){
        minHeap.addLast(data);
        heapiFyMinHeap(minHeap.size()-1);
    
    }

    private void heapiFyMinHeap(int index){
        if(index==0){
            return;
        }
        int parent= (index-1)/2;
        if(minHeap.get(parent)>minHeap.get(index)){
            int temp= minHeap.get(parent);
            minHeap.set(parent, minHeap.get(index));
            minHeap.set(index,temp);

            heapiFyMinHeap(parent);
        }
    }

    public int deleteElementOfMinHeap(){
        int deleted= minHeap.getFirst();
        minHeap.set(0,minHeap.getLast());
        minHeap.removeLast();
        deleteMinHeapify(0);
        return deleted;
    }
    
    private void deleteMinHeapify(int index) {

        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < minHeap.size() && minHeap.get(left) < minHeap.get(smallest)) {
            smallest = left;
        }

        if (right < minHeap.size() && minHeap.get(right) < minHeap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            int temp = minHeap.get(index);
            minHeap.set(index, minHeap.get(smallest));
            minHeap.set(smallest, temp);

            deleteMinHeapify(smallest);
        }
    }

    public void printMaxHeap(){
        int length=maxHeap.size();
        for(int i=0;i<=(length-1);i++){
            System.out.println(maxHeap.get(i)+"(root)");
            if(2*i+1<=(length-1))
                System.out.print(maxHeap.get(2*i+1)+"(l)");
            if(2*i+2<=(length-1))
                System.out.print("  "+maxHeap.get(2*i+2)+"(r)");
            System.out.println();
        }
    }

    
    public void printMinHeap(){
        int length=minHeap.size();
        for(int i=0;i<=(length-1);i++){
            System.out.println(minHeap.get(i)+"(root)");
            if(2*i+1<=(length-1))
                System.out.print(minHeap.get(2*i+1)+"(l)");
            if(2*i+2<=(length-1))
                System.out.print("  "+minHeap.get(2*i+2)+"(r)");
            System.out.println();
        }
    }

}
