public class Exercise_22 {
    public static class Node {
        int item;
        Node next;
    }

    public static void main(String[] args) {
        Node first = new Node();
        first.item = 1;
        Node second = new Node();
        second.item = 2;
        Node t = new Node();
        t.item = 20;
        Node x = new Node();
        x.item = 10;
        first.next = second;
        second.next = x;
        x.next = null;
        t.next = x.next;
        x.next = t;
        while (first.next != null) {
            System.out.println(first.item);
            first = first.next;
        }
        System.out.println(first.item);


    }
}