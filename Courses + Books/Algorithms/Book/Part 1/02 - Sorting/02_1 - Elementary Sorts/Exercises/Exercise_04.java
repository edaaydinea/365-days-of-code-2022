import java.util.Arrays;

public class Exercise_04 {
    public static class Insertion {
        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        public static void sort(Comparable[] a) {
            // Sort a[] into increasing order.
            int N = a.length;
            for (int i = 1; i < N; i++) {
                // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
                for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                    exch(a, j, j-1);
                // Print array for this exercise
                System.out.println(Arrays.toString(a));
            }
        }
    }
    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split("\\s+");
        Insertion.sort(a);
    }
}
