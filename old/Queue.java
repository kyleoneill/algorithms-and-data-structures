package fundamentals;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {
    private LinkedList<T> items;

    public Queue() {
        items = new LinkedList<T>();
    }

    public void enqueue(T item) {
        items.addLast(item);
    }

    public T dequeue() {
        return items.removeFirst();
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            public boolean hasNext() {
                return items.peek() != null;
            }

            public T next() {
                return items.removeFirst();
            }
        };
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int dequeued = queue.dequeue();
        assert dequeued == 1;
        for (int i : queue) {
            System.out.printf("Dequeued %s\n", i);
        }
    }
}
