import edu.princeton.cs.algs4.StdOut;

public class TowersOfHanoi {
    public static void main(String[] args) {
        // Read n, print moves to move n discs left.
        int n = Integer.parseInt(args[0]);
        moves(n, true);
    }

    private static void moves(int n, boolean left) {
        if (n == 0) return;
        moves(n - 1, !left);
        if (left) StdOut.println(n + " left");
        else StdOut.println(n + " right");
        moves(n - 1, !left);

    }
}
