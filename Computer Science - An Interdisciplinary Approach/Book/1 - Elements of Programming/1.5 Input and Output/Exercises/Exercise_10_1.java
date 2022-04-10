import edu.princeton.cs.algs4.StdOut;

public class Exercise_10_1 {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++)
            StdOut.print((int) (Math.random() * m) + " ");  // [0, m-1]
    }
}
