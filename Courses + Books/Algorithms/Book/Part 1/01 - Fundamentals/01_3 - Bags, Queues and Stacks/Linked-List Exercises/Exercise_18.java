public class Exercise_18 {
    public static class Node {
        public int item;
        public Node next;
    }

    public static void main(String[] args) {
        Node first = new Node();
        first.item = 1;
        Node second = new Node();
        second.item = 2;
        Node third = new Node();
        third.item = 3;

        first.next = second;
        second.next = third;
        third.next = null;

        first.next = first.next.next;

        while (first != null) {
            System.out.println(first.item);
            first = first.next;
        }
    }
}
