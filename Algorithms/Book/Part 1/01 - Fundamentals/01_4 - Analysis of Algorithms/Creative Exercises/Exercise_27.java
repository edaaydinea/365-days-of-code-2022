import edu.princeton.cs.algs4.Stack;

public class Exercise_27 {
    public static void main(String[] args) {
        StackQueue<Integer> sq = new StackQueue<>();
        for (int i = 0; i < 10; i++) {
            sq.enqueue(i);
        }
        System.out.println(sq.size());
        while (!sq.isEmpty()) {
            System.out.print(sq.dequeue() + " ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            sq.enqueue(i);
        }
        for (int i = 0; i < 5; i++) {
            sq.dequeue();
        }
        for (int i = 10; i < 15; i++) {
            sq.enqueue(i);
        }
        while (!sq.isEmpty()) {
            System.out.print(sq.dequeue() + " ");
        }
        System.out.println();
    }

    public static class StackQueue<Item> {
        private final Stack<Item> items;
        private final Stack<Item> backup;

        public StackQueue() {
            items = new Stack<>();
            backup = new Stack<>();
        }

        public void enqueue(Item item) {
            backup.push(item);
        }

        public Item dequeue() {
            if (isEmpty()) return null;
            if (items.isEmpty()) update();
            Item item = items.pop();
            return item;
        }

        private void update() {
            while (!backup.isEmpty()) {
                items.push(backup.pop());
            }
        }

        public int size() {
            return backup.size() + items.size();
        }

        public boolean isEmpty() {
            return backup.isEmpty() && items.isEmpty();
        }
    }
}
