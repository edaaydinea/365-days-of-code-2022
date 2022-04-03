import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Exercise_34 {
    public static void main(String[] args) {
        RandomBag<Integer> b = new RandomBag<>();
        for (int i = 0; i < 10; i++) {
            b.add(i);
        }
        StdOut.printf("%10s: %s\n", "Bag", b);
        for (int i = 0; i < 10; i++) {
            StdOut.printf("Iterator %d: ", i);
            for (int item : b) {
                StdOut.print(item + " ");
            }
            StdOut.println();
        }
    }

    public static class RandomBag<Item> implements Iterable<Item> {
        Item[] items;
        int N;

        public RandomBag() {
            items = (Item[]) new Object[4];
            N = 0;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void add(Item item) {
            items[N++] = item;
            if (items.length == N) {
                resize(items.length * 2);
            }
        }

        public void resize(int size) {
            Item[] copy = (Item[]) new Object[size];
            if (N >= 0) System.arraycopy(items, 0, copy, 0, N);
            items = copy;
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < N; i++) {
                s.append(items[i]).append(" ");
            }
            return s.toString();
        }

        @Override
        public Iterator<Item> iterator() {
            return new RandomBagIterator();
        }

        public class RandomBagIterator implements Iterator<Item> {
            int current;

            public RandomBagIterator() {
                current = 0;
                for (int i = 0; i < N; i++) {
                    int random = StdRandom.uniform(0, N);
                    Item copy = items[random];
                    items[random] = items[i];
                    items[i] = copy;
                }
            }

            @Override
            public boolean hasNext() {
                return current < N;
            }

            @Override
            public Item next() {
                return items[current++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove in iterator");
            }
        }
    }
}