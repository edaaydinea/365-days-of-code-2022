public class Exercise_19 {
    public static class Shell {
        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        // Return count of compares for each h-iteration
        public static int sort(Comparable[] a) {
            // Sort a[] into increasing order.
            int N = a.length;
            int h = 1;
            while (h < N / 3) {
                h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
            }
            int compares = 0;
            while (h >= 1) {
                System.out.printf("h = %2d: \n", h);
                // h-sort the array.
                for (int i = h; i < N; i++) {
                    // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                    for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                        compares++;
                        exch(a, j, j - h);
                    }
                    System.out.printf("i = %2d: ", i);
                    for (Comparable k : a) System.out.printf("%3d", k);
                    System.out.println();
                }
                h = h / 3;
                for (Comparable k : a) System.out.printf("%3d", k);
                System.out.println();
            }
            return compares;
        }
    }

    public static void main(String[] args) {
    }
}
