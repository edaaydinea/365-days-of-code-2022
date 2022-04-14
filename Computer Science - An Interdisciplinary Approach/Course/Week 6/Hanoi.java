import edu.princeton.cs.algs4.StdOut;

/*
hanoi(n): Print moves for n discs.
- Return one space for n = 0.
- Otherwise, set move to the specified move for disc n.
- Then sandwich move between two copies of hanoi(n-1).
 */
public class Hanoi {
    public static String hanoi(int n, boolean left) {
        if (n == 0) return " ";
        String move;
        if (left)
            move = n + "L";
        else
            move = n + "R";
        return hanoi(n - 1, !left) + move + hanoi(n - 1, !left);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(hanoi(n, false));
    }
}
