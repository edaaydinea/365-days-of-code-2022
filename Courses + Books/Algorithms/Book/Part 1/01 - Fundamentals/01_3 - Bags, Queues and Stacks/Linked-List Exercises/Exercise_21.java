public class Exercise_21 {
    private int n;
    private Node first;

    public Exercise_21() {
        n = 0;
        first = null;
    }

    private static class Node {
        private String item;
        private Node next;
    }

    public void append(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public static boolean find(Exercise_21 linkList, String Key) {
        Exercise_21 current = linkList;
        int temp = current.n;
        Node node = current.first;
        while (temp > 0) {
            if (node.item.equals(Key)) return true;
            else node = node.next;
            temp--;
        }
        return false;
    }

    public static void main(String[] args) {
        Exercise_21 linkList = new Exercise_21();

        linkList.append("hello");
        linkList.append("java");
        linkList.append("world");
        linkList.append("mereder");
        linkList.append("python");

        if (find(linkList, "hello"))
            System.out.println("true");
        else System.out.println("false");

        if (find(linkList, "1111"))
            System.out.println("true");
        else System.out.println("false");

    }
}
