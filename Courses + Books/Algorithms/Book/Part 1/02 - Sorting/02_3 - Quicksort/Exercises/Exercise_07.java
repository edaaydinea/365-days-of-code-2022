import edu.princeton.cs.algs4.StdRandom;

public class Exercise_07 {
    public static class Quick {
        private static int count0;
        private static int count1;
        private static int count2;

        public static int[] sort(Comparable[] a) {
            StdRandom.shuffle(a);
            count0 = 0;
            count1 = 0;
            count2 = 0;
            sort(a, 0, a.length - 1);
            return new int[] {count0, count1, count2};
        }
        private static void sort(Comparable[] a, int low, int high) {
            if      (high - low == 0) count0++;
            else if (high - low == 1) count1++;
            else if (high - low == 2) count2++;
            if (high <= low) {
                return;
            }
            int j = partition(a, low, high);
            sort(a, low, j - 1);
            sort(a, j + 1, high);
        }
        private static int partition(Comparable[] a, int low, int high) {
            // Partition into a[low..i-1], a[i], a[i+1..high].
            int i = low, j = high+1;
            Comparable v = a[low];
            while (true) {
                while (less(a[++i], v)) {
                    if (i == high) break;
                }
                while (less(v, a[--j])) {
                    if (j == low) break;
                }
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
            Comparable copy = a[i];
            a[i] = a[j];
            a[j] = copy;
        }
    }
    public static void main(String[] args) {
        int trials = 10000;
        System.out.printf("%8s %8s %8s %8s\n", "n", "count0", "count1", "count2");
        for (int n = 100; n <= 100000; n += n) {
            double count0 = 0.0;
            double count1 = 0.0;
            double count2 = 0.0;
            for (int t = 0; t < trials; t++) {
                Integer[] a = new Integer[n];
                for (int i = 0; i < n; i++) {
                    a[i] = i;
                }
                int[] counts = Quick.sort(a);
                count0 += counts[0];
                count1 += counts[1];
                count2 += counts[2];
            }
            System.out.printf("%8d %8.1f %8.1f %8.1f\n", n, count0/trials, count1/trials, count2/trials);
        }
    }
}
