public class Exercise_25 {
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

    public static Node insertAfter(Node firstList, Node secondList) {
        if (firstList == null && secondList == null) {
            return null;
        } else if (firstList == null && secondList != null) return secondList;
        else if (firstList != null && secondList == null) return firstList;
        else {
            Node connetion = firstList.next;
            firstList.next = secondList;
            Node current = firstList;
            while (current.next != null) {
                current = current.next;
            }
            current.next = connetion;
            return firstList;
        }

    }

    public static void main(String[] args) {
        Node Linklist = new Node();
        Node seondlist = new Node();
        Linklist = null;
        seondlist = null;

        Linklist = append(Linklist, "hello");
        Linklist = append(Linklist, "java");
        Linklist = append(Linklist, "world");


        seondlist = append(seondlist, "mereder");
        seondlist = append(seondlist, "python");
        Node result = insertAfter(Linklist, seondlist);
        while (result != null) {
            System.out.println(result.item);
            result = result.next;
        }

    }
}
