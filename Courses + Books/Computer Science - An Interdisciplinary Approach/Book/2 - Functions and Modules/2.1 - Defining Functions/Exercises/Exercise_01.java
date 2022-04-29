import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_01 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            double a = StdIn.readDouble();
            double b = StdIn.readDouble();
            double c = StdIn.readDouble();

            StdOut.printf("Max from (%.2f, %.2f, %.2f) is %.2f\n", a, b, c, max3(a, b, c));
        }

    }

    public static double max3(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }
}
