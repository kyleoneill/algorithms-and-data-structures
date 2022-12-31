package fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

// This is a re-sizing array implementation. A stack can also be implemented
// using a linked list to avoid the cost of re-sizing. Linked lists have
// far less efficient indexing of data, but this drawback does not matter
// when we are only interested in the last element in the list.
public class Stack<T> implements Iterable<T> {
    private T[] a = (T[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(T item) {
        if (n == a.length) resize(a.length * 2);
        a[n++] = item;
    }

    public T pop() {
        T item = a[--n];
        a[n] = null;
        if (n > 0 && n <= a.length / 4) resize(a.length / 2);
        return item;
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        // This is LIFO iteration because we are iterating a stack
        private int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public T next() {
            if (i < 1) {
                throw new NoSuchElementException();
            }
            return a[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {

    }
}
