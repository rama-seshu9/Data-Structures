package priority_queue;

public interface PriorityQueue<T>{
    void insert(T item);
    T peek();
    T remove();
    boolean isEmpty();
}