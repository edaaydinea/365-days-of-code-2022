import edu.princeton.cs.algs4.StdOut;
/*
ruler(n): create subdivisions of a ruler to 1 / 2^n inches.
- Return one space for n = 0.
- Otherwise, sandwich n between two copies of ruler (n-1).
 */

public class Ruler {
    public static String ruler(int n) {
        if (n == 0) return " ";
        return ruler(n - 1) + ruler(n - 1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(ruler(n));
    }
}
