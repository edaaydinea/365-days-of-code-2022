import edu.princeton.cs.algs4.Stack;

public class Exercise_29 {
    public static void main(String[] args) {
        StackSteque<Integer> ss = new StackSteque<>();
        for (int i = 0; i < 10; i++) {
            ss.push(i);
        }
        while (!ss.isEmpty()) {
            System.out.print(ss.pop() + " ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            ss.enqueue(i);
        }
        while (!ss.isEmpty()) {
            System.out.print(ss.pop() + " ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            ss.push(i);
        }
        for (int i = 10; i < 20; i++) {
            ss.enqueue(i);
        }
        while (!ss.isEmpty()) {
            System.out.print(ss.pop() + " ");
        }
        System.out.println();
    }

    public static class StackSteque<Item> {
        private final Stack<Item> s;
        private final Stack<Item> q;

        public StackSteque() {
            s = new Stack<>();
            q = new Stack<>();
        }

        public void push(Item item) {
            s.push(item);
        }

        public void enqueue(Item item) {
            q.push(item);
        }

        public Item pop() {
            if (isEmpty()) return null;
            if (s.isEmpty()) update();
            Item item = s.pop();
            return item;
        }

        private void update() {
            while (!q.isEmpty()) {
                s.push(q.pop());
            }
        }

        public int size() {
            return s.size() + q.size();
        }

        public boolean isEmpty() {
            return s.isEmpty() && q.isEmpty();
        }
    }
}
