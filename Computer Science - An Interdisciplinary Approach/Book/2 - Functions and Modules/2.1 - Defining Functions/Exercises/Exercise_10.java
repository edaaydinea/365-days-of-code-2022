import edu.princeton.cs.algs4.StdOut;

public class Exercise_10 {
    public static void main(String[] args) {
        StdOut.println(lg(8));
    }

    public static int lg(int n) {
        if (n <= 0) return Integer.MIN_VALUE;
        int powers = 1, i = 0;
        while (powers < n) {
            powers *= 2;
            i++;
        }
        return powers == n ? i - 1 : i - 2;
    }
}
