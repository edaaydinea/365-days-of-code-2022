import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_10 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            StdOut.printf("T(%d) = T(%d/2) + 1 = %d\n", n, n, t1(n));
            StdOut.printf("T(%d) = 2T(%d/2) + 1 = %d\n", n, n, t2(n));
            StdOut.printf("T(%d) = 2T(%d/2) + %d = %d\n", n, n, n, t3(n));
            StdOut.printf("T(%d) = 4T(%d/2) + 3 = %d\n", n, n, n, t4(n));
        }
    }

    private static int t4(int n) {
        if (n <= 1) return 1;
        return 4 * t4(n / 2) + 3;
    }

    private static int t3(int n) {
        if (n <= 1) return 1;
        return 2 * t3(n / 2) + n;
    }

    private static int t2(int n) {
        if (n <= 1) return 1;
        return 2 * t2(n / 2) + 1;
    }

    public static int t1(int n) {
        if (n <= 1) return 1;
        return t1(n / 2) + 1;
    }

}
