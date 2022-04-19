import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_05<Key, Value> {
    private class Node{
        Node next;
        Key key;
        Value value;

        public Node(Node next, Key key, Value value){
            this.key = key;
            this.next = next;
            this.value = value;
        }
    }
    private Node first;
    private int N;
    public boolean isEmpty(){return N == 0;}
    public int size(){return N;}
    public boolean contains(Key key){
        return get(key) != null;
    }
    public void put(Key key, Value value){
        if (key == null){
            throw new IllegalArgumentException("Key cannot be null.");
        }
        if (value == null){
            delete(key);
            return;
        }
        //
        if (isEmpty()){
            first = new Node(null, key, value);
            N++;
            return;
        }
        for (Node node = first; node != null; node = node.next){
            if (node.key.equals(key)){
                node.value = value;
                N++;
                return;
            }
        }
        first =  new Node(first, key, value);
        N++;
    }
    public Value get(Key key){
        if (key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
        for (Node node = first; node != null; node = node.next){
            if (node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }
    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        for (Node node = first; node != null; node = node.next){
            queue.enqueue(node.key);
        }
        return queue;
    }
    public void delete(Key key){
        if (key == null){
            throw new IllegalArgumentException("Key cannot be null");
        }
        for (Node node = first; node != null; node = node.next){
            if (node.key.equals(key)){
                node.value = null;
                //node.key = null;
                N--;
                return;
            }
        }
    }

    public static void main(String[] args) {
        Exercise_05<String, String> sequentialSearchST = new Exercise_05<>();
        sequentialSearchST.put(11 + "A", 11 + "B");
        sequentialSearchST.put(4 + "A", 4 + "B");
        sequentialSearchST.put(21 + "A", 21 + "B");
        sequentialSearchST.put(5 + "A", 5 + "B");
        sequentialSearchST.put(12 + "A", 12 + "B");
        sequentialSearchST.put(6 + "A", 6 + "B");

        StdOut.println("Print out all key-value in the symbol table");
        for (String s : sequentialSearchST.keys()){
            StdOut.println(s + " " + sequentialSearchST.get(s));
        }
        StdOut.println("The size is: " + sequentialSearchST.size());
        StdOut.println("Delete two of them");
        sequentialSearchST.delete(4+"A");
        sequentialSearchST.delete(12+"A");

        StdOut.println("Print our all key-value in the symbol table after deletion");
        for (String s : sequentialSearchST.keys()){
            StdOut.println(s + " " + sequentialSearchST.get(s));
        }
        StdOut.println("The size is: " + sequentialSearchST.size());
    }
}
