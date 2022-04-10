import edu.princeton.cs.algs4.StdOut;

public class Exercise_06 {
    public static void main(String[] args) {
        double rnd = Math.random() * 101;
        StdOut.printf("sigmoid (%.2f) = %.2f", rnd, sigmoid(rnd));
    }

    public static double sigmoid(double x) {
        return 1.0 / (1 + Math.exp(-x));
    }
}
