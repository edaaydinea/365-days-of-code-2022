import edu.princeton.cs.algs4.StdRandom;

public class Exercise_03 {
    public static class Quick {
        private static Comparable max;
        private static int maxCount;

        public static int sort(Comparable[] a) {
            StdRandom.shuffle(a);
            max = a[0];
            maxCount = 0;
            for (Comparable c : a) {
                if (less(max, c)) max = c;
            }
            sort(a, 0, a.length - 1);
            return maxCount;
        }
        private static void sort(Comparable[] a, int low, int high) {
            if (high <= low)
                return;
            int mid = partition(a, low, high);
            sort(a, low, mid - 1);
            sort(a, mid + 1, high);
        }
        private static int partition(Comparable[] a, int low, int high) {
            // Partition into a[low..i-1], a[i], a[i+1..high].
            int i = low, j = high+1;
            Comparable v = a[low];
            while (true) {
                while (less(a[++i], v)) if (i == high) break;
                while (less(v, a[--j])) if (j == low) break;
                if (i >= j) break;
                exch(a, i, j);
            }
            exch(a, low, j);
            return j;             // with a[low..j-1] <= a[j] <= a[j+1..high].
        }
        private static boolean less(Comparable a, Comparable b) {
            return a.compareTo(b) < 0;
        }
        private static void exch(Comparable[] a, int i, int j) {
            if (a[i].compareTo(max) == 0 || a[j].compareTo(max) == 0) maxCount++;
            Comparable copy = a[i];
            a[i] = a[j];
            a[j] = copy;
        }
    }
    public static void main(String[] args) {
        int trials = 10000;
        System.out.printf("%6s %4s %6s\n", "n", "max", "lg N");
        for (int n = 100; n < 10000; n += n) {
            int max = 0;
            for (int t = 0; t < trials; t++) {
                Integer[] a = new Integer[n];
                for (int i = 0; i < n; i++) {
                    a[i] = i;
                }
                int cur = Quick.sort(a);
                if (cur > max) max = cur;
            }
            System.out.printf("%6d %4d %6.1f\n", n, max, Math.log(n)/Math.log(2));
        }
    }
}
