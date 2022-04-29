import edu.princeton.cs.algs4.StdOut;

public class Exercise_09 {
    public static void main(String[] args) {

        // edge cases
        StdOut.printf("log2(%.2f) = %.2f\n", Double.NaN, lg(Double.NaN));
        StdOut.printf("log2(%.2f) = %.2f\n", Double.POSITIVE_INFINITY, lg(Double.POSITIVE_INFINITY));
        StdOut.printf("log2(%.2f) = %.2f\n\n", Double.NEGATIVE_INFINITY, lg(Double.NEGATIVE_INFINITY));

        for (int i = 1; i <= 5; i++) {
            double rnd = Math.random() * 10;
            StdOut.printf("log2(%.2f) = %.2f\n", rnd, lg(rnd));
        }
    }

    public static double lg(double n) {
        return n <= 0 ? Double.NaN : Math.log(n) / Math.log(2);
    }
}
