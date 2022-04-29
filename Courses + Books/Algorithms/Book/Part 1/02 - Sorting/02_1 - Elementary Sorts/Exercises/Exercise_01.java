import java.util.Arrays;

/*
[A, E, S, Y, Q, U, E, S, T, I, O, N]
[A, E, S, Y, Q, U, E, S, T, I, O, N]
[A, E, E, Y, Q, U, S, S, T, I, O, N]
[A, E, E, I, Q, U, S, S, T, Y, O, N]
[A, E, E, I, N, U, S, S, T, Y, O, Q]
[A, E, E, I, N, O, S, S, T, Y, U, Q]
[A, E, E, I, N, O, Q, S, T, Y, U, S]
[A, E, E, I, N, O, Q, S, T, Y, U, S]
[A, E, E, I, N, O, Q, S, S, Y, U, T]
[A, E, E, I, N, O, Q, S, S, T, U, Y]
[A, E, E, I, N, O, Q, S, S, T, U, Y]
[A, E, E, I, N, O, Q, S, S, T, U, Y]

 */
public class Exercise_01 {
    public static class Selection {
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
            int N = a.length;               // array length
            for (int i = 0; i < N; i++) {
                // Exchange a[i] with smallest entry in a[i+1...N).
                int min = i;                 // index of minimal entry
                for (int j = i+1; j < N; j++)
                    if (less(a[j], a[min])) min = j;
                exch(a, i, min);

                // Print array for this exercise
                System.out.println(Arrays.toString(a));
            }
        }
    }
    public static void main(String[] args) {
        String s = "E A S Y Q U E S T I O N";
        String[] a = s.split("\\s+");
        Selection.sort(a);
    }
}
