import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private RandomizedQueueNode head, tail;
    private int size;

    public RandomizedQueue() {

    }

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        for (int i = 0; i < 5000; i++) {
            double ran = StdRandom.uniform();
            if (ran <= 1) {
                randomizedQueue.enqueue("A");
            } else {
                try {
                    randomizedQueue.dequeue();
                } catch (NoSuchElementException e) {
                    StdOut.print();
                }
            }
        }
        try {
            randomizedQueue.dequeue();
        } catch (NoSuchElementException e) {
            StdOut.print();
        }

        randomizedQueue.enqueue("2");
        randomizedQueue.enqueue("3");
        randomizedQueue.enqueue("4");
        randomizedQueue.enqueue("5");
        randomizedQueue.enqueue("6");
        randomizedQueue.enqueue("7");
        randomizedQueue.enqueue("8");
        randomizedQueue.enqueue("9");
        randomizedQueue.enqueue("10");
        randomizedQueue.enqueue("A");
        randomizedQueue.enqueue("B");
        randomizedQueue.enqueue("C");
        for (Iterator<String> it = randomizedQueue.iterator(); it.hasNext(); ) {
            StdOut.println(it.next());
        }
        StdOut.println(randomizedQueue.dequeue());
        randomizedQueue.sample();
    }

    private RandomizedQueueNode createNode(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        return new RandomizedQueueNode(item);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        RandomizedQueueNode node = createNode(item);
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        RandomizedQueueNode current = head;
        RandomizedQueueNode previous = null;
        for (int i = 0, f = StdRandom.uniform(size); i < f; i++) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }
        if (current == tail) {
            tail = previous;
        }
        size--;
        return current.item;
    }

    public Item sample() {
        return iterator().next();
    }

    public Iterator<Item> iterator() {
        int[] indexes = new int[size];
        Item[] nodes = (Item[]) new Object[size];
        for (int i = 0; i < size; i++) {
            indexes[i] = i;
        }
        StdRandom.shuffle(indexes);
        RandomizedQueueNode current = head;
        for (int i = 0; i < size; i++) {
            nodes[i] = current.item;
            current = current.next;
        }
        return new RandomizedQueueIterator(nodes, indexes);
    }

    private class RandomizedQueueNode {
        private Item item;
        private RandomizedQueueNode next;

        private RandomizedQueueNode(Item item) {
            this.item = item;
        }
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] items;
        private int[] indexes;
        private int current;

        private RandomizedQueueIterator(Item[] items, int[] indexes) {
            this.items = items;
            this.indexes = indexes;
        }

        @Override
        public boolean hasNext() {
            return current != indexes.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[indexes[current++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
