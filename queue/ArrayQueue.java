package queue;

public class ArrayQueue<T> implements Queue<T>{

    private final int INITIAL_CAPACITY = 5;
    private int capacity = INITIAL_CAPACITY;
    private int size;
    private Object[] queue;
    private int rear;
    private int front;

    ArrayQueue(){
        queue = new Object[capacity];
        rear = 0;
        front = 0;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if(size == capacity) resize();
        queue[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        if(size == 0) return null;
        Object item = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        return (T) item;
    }

    @Override
    public T peek() {
        if(size() == 0)
            return null;
        else
            return (T) queue[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Object[] newQueue = new Object[newCapacity];

        for(int i=0; i<size;i++){
            newQueue[i] = queue[front];
            front = (front + 1) % capacity;
        }

        queue = newQueue;
        front = 0;
        rear = size;
        capacity = newCapacity;
    }

    public static void main(String... args){
        ArrayQueue<Integer> q = new ArrayQueue<>();
        q.enqueue(35);
        q.enqueue(45);
        q.enqueue(55);
        q.enqueue(65);

        q.enqueue(75);
        q.enqueue(85);
        q.enqueue(95);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
