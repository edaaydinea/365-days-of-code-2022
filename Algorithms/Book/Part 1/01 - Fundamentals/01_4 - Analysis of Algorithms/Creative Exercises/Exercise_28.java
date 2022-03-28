import edu.princeton.cs.algs4.Queue;

public class Exercise_28 {
    public static void main(String[] args) {
        QueueStack<Integer> qs = new QueueStack<>();
        for (int i = 0; i < 10; i++) {
            qs.push(i);
        }
        System.out.println(qs.size());
        while (qs.isEmpty()) {
            System.out.print(qs.pop() + " ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            qs.push(i);
        }
        for (int i = 0; i < 5; i++) {
            qs.pop();
        }
        for (int i = 10; i < 15; i++) {
            qs.push(i);
        }
        while (qs.isEmpty()) {
            System.out.print(qs.pop() + " ");
        }
        System.out.println();

    }

    public static class QueueStack<Item> {
        private final Queue<Item> q;

        public QueueStack() {
            q = new Queue<>();
        }

        public void push(Item item) {
            q.enqueue(item);
        }

        public Item pop() {
            if (q.isEmpty()) return null;
            int end = q.size();
            for (int i = 1; i < end; i++) {
                q.enqueue(q.dequeue());
            }
            return q.dequeue();
        }

        public int size() {
            return q.size();
        }

        public boolean isEmpty() {
            return !q.isEmpty();
        }
    }
}
