public class Exercise_24 {
    public static class Node {
        String item;
        Node next;
    }

    public static Node append(Node list, String item) {
        Node oldfirst = list;
        list = new Node();
        list.item = item;
        list.next = oldfirst;
        return list;
    }

    public static Node removeAfter(Node Linklist) {
        if (Linklist == null || Linklist.next == null)
            return Linklist;
        else {
            Linklist.next = null;
            return Linklist;
        }

    }

    public static void main(String[] args) {
        Node Linklist = new Node();
        Linklist = null;
        Linklist = append(Linklist, "hello");
        Linklist = append(Linklist, "java");
        Linklist = append(Linklist, "world");
        Linklist = append(Linklist, "mereder");
        Linklist = append(Linklist, "python");

        Linklist = removeAfter(Linklist);

        System.out.println(Linklist.item);
    }
}
