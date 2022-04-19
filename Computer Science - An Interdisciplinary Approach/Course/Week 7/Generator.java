import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Generator {
    // Generate N integers in [-M, M)
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        for (int i = 0; i < N; i++) {
            StdOut.println(StdRandom.uniform(-M, M));
        }
    }
}
