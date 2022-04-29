import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_02 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            StdOut.printf("%d != %f\n", n, lnFactorial(n));
        }
    }

    public static double lnFactorial(int n) {
        if (n < 0) return Double.NaN;
        if (n == 0) return Double.NEGATIVE_INFINITY;
        if (n == 1) return 0;
        return Math.log(n) + lnFactorial(n - 1);
    }
}
