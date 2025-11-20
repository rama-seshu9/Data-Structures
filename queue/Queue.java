package queue;

public interface Queue<T> {

    void enqueue(T item);
    T dequeue();
    T peek();
    int size();
    int capacity();
}
