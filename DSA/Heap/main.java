package Heap;

public class main {
    public static void main(String[] args) {
        Heap myHeap= new Heap();

        int[] values= {12,56,34,89,24,12,32,21};

        for(int val: values){
            myHeap.addElementToMinHeap(val);
        }

        myHeap.printMinHeap();

        System.out.println("deleted element:"+myHeap.deleteElementOfMinHeap());

        myHeap.printMinHeap();
    }
    
}
