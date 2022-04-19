import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_03<Key extends Comparable<Key>, Value> {
    private Node first;
    private int N;

    private class Node {
        Node next;
        private Key key;
        private Value value;

        public Node(Node next, Key key, Value value) {
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null. ");
        if (value == null) {
            delete(key);
        }
        // there is no node in object
        if (isEmpty()) {
            first = new Node(null, key, value);
            N++;
            return;
        }
        // there is only one node in object
        if (first.key.compareTo(key) == 0) {
            first.value = value;
            return;
        }
        if (first.key.compareTo(key) > 0) {
            first = new Node(first, key, value);
            N++;
            return;
        }
        // if there are more one node in object
        for (Node node = first; node.next != null; node = node.next) {
            if (node.next.key.compareTo(key) == 0) {
                node.next.value = value;
                return;
            }
            if (node.next.key.compareTo(key) > 0) {
                //Node newNode = new Node(node.next, key, value);
                node.next = new Node(node.next, key, value);
                N++;
                return;
            }
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null. ");
        }
        if (first.key.compareTo(key) == 0) {
            return first.value;
        }
        for (Node node = first; node.next != null; node = node.next) {
            if (node.next.key.compareTo(key) == 0) {
                return node.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null. ");
        }
        if (isEmpty()) {
            return;
        }
        // if there is only node existing
        if (first.key.compareTo(key) == 0) {
            first = first.next;
            N--;
            return;
        }
        for (Node node = first; node != null; node = node.next) {
            if (node.next.key.compareTo(key) == 0) {
                node.next = node.next.next;
                N--;
                return;
            }
        }
    }

    // is there a value paired with key
    public boolean contains(Key key) {
        Node node = first;
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null. ");
        }
        if (first.key.compareTo(key) == 0) {
            return first.value != null;
        }
        for (; node.next != null; node = node.next) {
            if (node.key.compareTo(key) == 0) {
                return node.value != null;
            }
        }
        return node.value == null;
    }

    // smallest key
    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return first.key;
    }

    // largest key
    public Key max() {
        if (isEmpty()) {
            return null;
        }
        Node last;
        for (last = first; last.next != null; last = last.next) {
            last = last.next;
        }
        return last.key;
    }

    // delete largest key
    public void deleteMax() {
        delete(max());
    }

    // delete smallest key
    public void deleteMin() {
        delete(min());
    }

    // largest key less than or equal to key
    public Key floor(Key key) {
        if (isEmpty()) {
            return null;
        }
        if (first.key.compareTo(key) == 0) {
            return first.key;
        }
        for (Node node = first; node.next != null; node = node.next) {
            if (node.next.key.compareTo(key) == 0) {
                return node.next.key;
            }
        }
        return null;
    }

    // smallest key greater than or equal to key
    public Key ceiling(Key key) {
        if (isEmpty()) {
            return null;
        }
        if (first.key.compareTo(key) == 0) {
            return first.key;
        }
        for (Node node = first; node.next != null; node = node.next) {
            if (node.next.key.compareTo(key) == 0) {
                return node.next.key;
            }
        }
        return null;
    }

    // key of rank k
    public Key select(int k) {
        if (k < 0 || k >= N) {
            throw new IllegalArgumentException("Invalid argument. ");
        }
        int currentK = 0;
        for (Node node = first; node != null; node = node.next) {
            if (currentK == k) {
                return node.key;
            }
            currentK++;
        }
        return null;
    }

    // number of keys less than key
    public int rank(Key key) {
        int rank = 0;
        for (Node node = first; node != null; node = node.next) {
            if (node.key.compareTo(key) < 0) {
                rank++;
            } else {
                break;
            }
        }
        return rank;
    }

    // number of of keys in [lo..hi]
    public int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    // keys in [lo..hi], in sorted order
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> keys = new Queue<>();
        boolean inTheRange = false;
        for (Node node = first; node != null; node = node.next) {
            if (!inTheRange) {
                if (node.key.compareTo(lo) == 0 || node.key.compareTo(lo) > 0) {
                    keys.enqueue(node.key);
                    inTheRange = true;
                }
            } else {
                if (node.key.compareTo(hi) == 0 || node.key.compareTo(hi) < 0) {
                    keys.enqueue(node.key);
                }
            }
        }
        return keys;
    }

    // all keys in the table, in sorted order
    public Iterable<Key> keys() {
        Queue<Key> keys = new Queue<>();
        for (Node node = first; node != null; node = node.next) {
            keys.enqueue(node.key);
        }
        return keys;
    }

    public static void main(String[] args) {
        Exercise_03<String, Integer> orderedSequentialSearchST = new Exercise_03<>();
        String a = Constants.FILE_PATH + "tinyST.txt";
        String[] s = In.readStrings(a);
        //String[] t = a.split("\\s+");
        for (int i = 0; i < s.length; i++){
            orderedSequentialSearchST.put(s[i], i);
        }
        for (int i = 0; i < s.length; i++){
            StdOut.println(s[i] + " " + orderedSequentialSearchST.get(orderedSequentialSearchST.select(i)));
        }
    }
}
