import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;
import java.util.Random;

public class Exercise_15 {
    public static class MergeBUQ {
        private static Queue<Queue> q;

        public static void sort(Comparable[] a) {
            q = new Queue<>();
            for (Comparable c : a) {
                Queue<Comparable> tmp = new Queue<>();
                tmp.enqueue(c);
                q.enqueue(tmp);
            }
            while (q.size() > 1)
                q.enqueue(merge(q.dequeue(), q.dequeue()));

            Queue<Comparable> b = q.dequeue();
            for (int i = 0; i < a.length; i++)
                a[i] = b.dequeue();
        }

        private static Queue<Comparable> merge(Queue<Comparable> a, Queue<Comparable> b) {
            Queue<Comparable> c = new Queue();
            while (!a.isEmpty() || !b.isEmpty()) {
                if      (a.isEmpty())                      c.enqueue(b.dequeue());
                else if (b.isEmpty())                      c.enqueue(a.dequeue());
                else if (a.peek().compareTo(b.peek()) < 0) c.enqueue(a.dequeue());
                else                                       c.enqueue(b.dequeue());
            }
            return c;
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }

    public static void main(String[] args) {
        // Test a reverse sorted array
        Integer[] nums = new Integer[30];
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums.length - i;
        MergeBUQ.sort(nums);
        System.out.println(Arrays.toString(nums));

        // Test random array
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = r.nextInt(nums.length);
            int n = nums[i];
            nums[i] = nums[j];
            nums[j] = n;
        }
        MergeBUQ.sort(nums);
        System.out.println(Arrays.toString(nums));

        // Test multiple random arrays
        for (int n = 10; n < 2000; n += 10) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = r.nextInt(n);
            MergeBUQ.sort(a);
            if (!isSorted(a)) System.out.println("We have a problem.");
        }

    }
}
