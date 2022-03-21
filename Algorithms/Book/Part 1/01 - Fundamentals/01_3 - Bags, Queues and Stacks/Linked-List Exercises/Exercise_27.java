import edu.princeton.cs.algs4.StdRandom;

public class Exercise_27 {
    public static class Node {
        public int item;
        public Node next;
    }

    public static int Max(Node first) {
        int max = 0;
        Node current = first;
        while (current != null) {
            if (current.item > max) max = current.item;
            current = current.next;
        }
        return max;
    }

    public static int max = 0;

    public static int Recursion_Max(Node first) {
        Node current = first;
        if (current == null) return max;
        else {
            if (current.item > max) max = current.item;
            return Recursion_Max(current.next);
        }
    }

    public static void main(String[] args) {
        Node first = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();

        first.item = StdRandom.uniform(1, 20);
        first.next = n1;
        n1.item = StdRandom.uniform(1, 20);
        n1.next = n2;
        n2.item = StdRandom.uniform(1, 20);
        n2.next = n3;
        n3.item = StdRandom.uniform(1, 20);
        n3.next = n4;
        n4.item = StdRandom.uniform(1, 20);
        n4.next = null;

        int maxIterator = Max(first);
        System.out.println(maxIterator);

        int maxRecursion = Recursion_Max(first);
        System.out.println(maxRecursion);
    }
}
