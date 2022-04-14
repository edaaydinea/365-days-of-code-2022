import edu.princeton.cs.algs4.StdOut;

public class Beckett {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        moves(n, true);
    }

    private static void moves(int n, boolean enter) {
        if (n == 0) return;
        moves(n - 1, true);
        if (enter) StdOut.println("enter " + n);
        else StdOut.println("exit " + n);
        moves(n - 1, false);
    }
}
