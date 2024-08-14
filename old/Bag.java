package fundamentals;

import java.util.ArrayList;
import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private ArrayList<T> items;

    public Bag() {
        items = new ArrayList<T>();
    }

    public void add(T item) {
        items.add(item);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            public boolean hasNext() {
                return position < size();
            }

            public T next() {
                T item = items.get(position);
                position++;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<Integer>();
        bag.add(5);
        bag.add(10);
        bag.add(15);
        for (int i : bag) {
            System.out.printf("Bag number: %s\n", i);
        }
    }
}
