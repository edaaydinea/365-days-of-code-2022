import edu.princeton.cs.algs4.StdOut;

public class Exercise_04 {
    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5};
        int[] b = {3, 1, 4, 1};
        int[] c = {3, 1, 4, 1, 5};
        int[] d = {2, 7, 1, 8, 2};

        StdOut.println(eq(a, a));
        StdOut.println(eq(a, b));
        StdOut.println(eq(a, c));
        StdOut.println(eq(a, d));
    }

    public static boolean eq(int[] a, int[] b) {
        if (a.length != b.length)
            return false;

        // check elements
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
