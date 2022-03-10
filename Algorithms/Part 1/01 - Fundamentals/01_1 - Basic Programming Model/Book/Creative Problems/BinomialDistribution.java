import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.InputMismatchException;

public class BinomialDistribution {
    public static double binomial(int N, int k, double p) {
        if ((N == 0) && (k == 0)) return 1.0;
        if ((N < 0) || (k < 0)) return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static void main(String[] args) {
        for (boolean test = false; !test; ) {
            try {
                StdOut.print("Enter number of trials: ");
                int N = StdIn.readInt();
                StdOut.print("Enter number of times for a specific outcome within n trials: ");
                int k = StdIn.readInt();
                StdOut.print("Enter probability of success on a single trial: ");
                double p = StdIn.readDouble();
                test = true;

                StdOut.printf("Binomial Distribution: %f", binomial(N, k, p));
            } catch (InputMismatchException e) {
                test = false;
                StdOut.println("Invalid input");
            }
        }
    }
}
