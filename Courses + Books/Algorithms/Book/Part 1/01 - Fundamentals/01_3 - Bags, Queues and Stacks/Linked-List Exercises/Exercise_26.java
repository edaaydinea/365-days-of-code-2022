public class Exercise_26 {
    public static void remove(LinkList linkList, String Key) {
        int temp = linkList.getSize();
        for (int i = 0; i < temp; i++) {
            if (linkList.delete(Key)) continue;
        }
    }

    public static void main(String[] args) {
        LinkList Linklist = new LinkList();

        Linklist.addHead("hello");
        Linklist.addHead("java");
        Linklist.addHead("world");
        Linklist.addHead("mereder");
        Linklist.addHead("python");
        Linklist.addHead("world");

        Linklist.display();

        remove(Linklist, "world");

        Linklist.display();

    }
}
