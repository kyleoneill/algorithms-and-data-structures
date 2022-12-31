package fundamentals;

// This is a linked list implementation of a stack. This avoids the need
// to re-size an array

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LLStack<T> implements Iterable<T> {
    private Node first;
    private int n;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T newValue) {
        Node oldFirst = first;
        first = new Node();
        first.item = newValue;
        first.next = oldFirst;
        n++;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            // This is current != null instead of current.next != null
            // because the next() method returns the current item and then
            // iterates current to current.next
            // `current` should probably be named `next` to avoid this
            // confusion, but blame the book!
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LLStack<String> s = new LLStack<String>();
        s.push("hello");
        s.push("There");
        String foo = s.pop();
        assert foo.equals("There");
        assert s.size() == 1;
        s.push("Another Value");
        s.push("Final value");
        for (String str : s) {
            System.out.println(str);
        }
    }
}
