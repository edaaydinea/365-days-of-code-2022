import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private DequeLinkedNode head, tail;
    private int size;

    public Deque() {
        size = 0;
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        StdOut.println(deque.isEmpty());
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        for (Iterator<Integer> it = deque.iterator(); it.hasNext(); ) {
            StdOut.println(it.next());
        }
    }

    private DequeLinkedNode createNode(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        return new DequeLinkedNode(item);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        DequeLinkedNode node = createNode(item);
        node.next = head;
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (head != null) {
            head.previous = node;
        }
        head = node;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(Item item) {
        DequeLinkedNode node = createNode(item);
        node.previous = tail;
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (size == 0) {
            head = tail;
        }
        size++;
    }

    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        DequeLinkedNode node = head;
        head = node.next;
        size--;
        if (size == 0) {
            tail = null;
        } else {
            head.previous = null;
        }
        return node.item;
    }

    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        DequeLinkedNode node = tail;
        tail = node.previous;
        size--;
        if (size == 0) {
            head = null;
        } else {
            tail.next = null;
        }
        return node.item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator(head);
    }

    private class DequeLinkedNode {
        private Item item;
        private DequeLinkedNode previous;
        private DequeLinkedNode next;

        private DequeLinkedNode(Item item) {
            this.item = item;
        }
    }

    private class DequeIterator implements Iterator<Item> {

        private DequeLinkedNode current;

        private DequeIterator(DequeLinkedNode current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            DequeLinkedNode node = current;
            current = current.next;
            return node.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}