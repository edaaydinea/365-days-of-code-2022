import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_07 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        StdOut.printf("Enter %d district numbers in range 1 - %d\n", n - 1, n);

        int nSum = n * (n + 1) / 2;
        int inputSum = 0;

        for (int i = 0; i < n - 1; i++) {
            inputSum += StdIn.readInt();
        }

        StdOut.printf("Missing number is %d", nSum - inputSum);
    }
}
