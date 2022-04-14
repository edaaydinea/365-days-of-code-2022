import edu.princeton.cs.algs4.StdOut;

/*
Example: Convert an integer to binary
 */
public class Binary {
    public static String convert(int N) {
        if (N == 1) return "1";
        return convert(N / 2 + (N % 2)); // int 0 or 1 automatically converted 0 - String "1" or "0"
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(convert(N));
    }
}
