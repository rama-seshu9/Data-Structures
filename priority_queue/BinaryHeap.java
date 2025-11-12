package priority_queue;

import java.util.Scanner;

class BinaryHeap<T> implements PriorityQueue<T>{

    int INITIAL_CAPACITY = 20;
    int capacity = INITIAL_CAPACITY;
    int size =0;
    Object[] arr;

    BinaryHeap(){
        arr = new Object[capacity];
    }

    public static void main(String... args){
        System.out.println("Binary Min Heap Impl of Priority Queue");
        Scanner sc = new Scanner(System.in);
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        Integer val;
        for(int i=0;i<5;i++){
            val = sc.nextInt();
            heap.insert(val);
        }

        for(int i=0;i<5;i++){
            System.out.print(heap.remove()+ " ");
        }

    }

    @Override
    public void insert(T item) {
        arr[size] = item;
        size++;
        heapifyUp();
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public T remove() {
        Object minObj = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapifyDown();
        return (T) minObj;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    private void heapifyUp() {
        int child = size-1;
        while(child > 0){
            int parent = (child-1)/2;
            if(compare(arr[parent],arr[child]) > 0){
                swap(parent, child);
                child = parent;
            }else{
                break;
            }
        }
    }

    private void heapifyDown(){
        int parent = 0;
        int leftChild;
        int rightChild;
        int smallestNode;
        do{
            leftChild = 2 * parent + 1;
            rightChild = 2 * parent + 2;
            if(leftChild >= size) break;

            smallestNode = rightChild >= size ? leftChild :
                    compare(arr[rightChild],arr[leftChild]) < 0 ? rightChild : leftChild;
            smallestNode = compare(arr[parent],arr[smallestNode]) < 0 ? parent : smallestNode;

            if(smallestNode == parent) break;
            else{
                swap(parent,smallestNode);
                parent = smallestNode;
            }
            
        }while(true);
    }

    void swap(int i1, int i2){
        Object temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private int compare(Object o1, Object o2){
        return ((Comparable) o2).compareTo(o1);
    }
}