import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_11 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            StdOut.println(signum(StdIn.readInt()));
        }
    }

    public static int signum(int n) {
        return Integer.compare(n, 0);
    }
}
