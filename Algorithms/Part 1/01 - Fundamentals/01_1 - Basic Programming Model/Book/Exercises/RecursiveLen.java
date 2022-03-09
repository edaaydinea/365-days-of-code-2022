import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RecursiveLen {
    public static long fact(int n) {
        if (n < 2) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {

        StdOut.print("Enter the value: ");
        int n = StdIn.readInt();
        StdOut.printf("ln(%d!) = %f\n", n, Math.log(fact(n)));
    }
}
