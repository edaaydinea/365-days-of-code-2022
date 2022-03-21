public class Exercise_30 {
    public static class Node<Item> {
        public Item item;
        public Node<Item> next;
    }


    public static Node iterationReverse(Node head) {
        Node<Integer> reverse = null;
        Node<Integer> first = head;
        while (first != null) {
            Node<Integer> second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }


    public static Node recursionReverse(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;
        Node second = head.next;
        Node rest = recursionReverse(second);
        second.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        Node<Integer> first = new Node<>();
        first.item = 1;
        Node<Integer> second = new Node<>();
        second.item = 2;
        Node<Integer> third = new Node<>();
        third.item = 3;
        Node<Integer> fourth = new Node<>();
        fourth.item = 4;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        Node<Integer> test = iterationReverse(first);
        System.out.println(test.item);

        Node<Integer> test2 = recursionReverse(test);
        System.out.println(test2.item);
    }
}
