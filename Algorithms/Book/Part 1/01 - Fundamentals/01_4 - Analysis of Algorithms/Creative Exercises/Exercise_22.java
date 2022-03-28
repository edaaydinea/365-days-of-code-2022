import edu.princeton.cs.algs4.Stopwatch;

public class Exercise_22 {
    public static int fibonacciSearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int fi = 0;
        while (f(fi) + f(fi) < hi) {
            fi++;
        }
        while (hi >= lo) {
            int mid = lo + f(--fi);
            if (mid > hi) mid = hi;
            if (a[mid] > key) hi = mid - 1;
            else if (a[mid] < key) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int f(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }

    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > key) hi = mid - 1;
            else if (a[mid] < key) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int bruteSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[200000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i += a.length - 1) {
            System.out.printf("fibonacciSearch(%d): %s\n", i, fibonacciSearch(a, i));
            System.out.printf("   binarySearch(%d): %s\n", i, binarySearch(a, i));
            System.out.printf("    bruteSearch(%d): %s\n", i, bruteSearch(a, i));
        }

        // Time
        Stopwatch s = new Stopwatch();
        for (int i = 0; i < a.length; i++) {
            fibonacciSearch(a, i);
        }
        System.out.printf("%14s: %6.3f\n", "fibonacci time", s.elapsedTime());
        s = new Stopwatch();
        for (int i = 0; i < a.length; i++) {
            binarySearch(a, i);
        }
        System.out.printf("%14s: %6.3f\n", "binary time", s.elapsedTime());
        s = new Stopwatch();
        for (int i = 0; i < a.length; i++) {
            bruteSearch(a, i);
        }
        System.out.printf("%14s: %6.3f\n", "brute time", s.elapsedTime());

    }
}
