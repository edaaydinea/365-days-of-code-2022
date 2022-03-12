import edu.princeton.cs.algs4.StdOut;

public class Int2Binary {
    public static String int2binary(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.insert(0, (n % 2));
            n /= 2;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        StdOut.println(int2binary(Integer.parseInt(args[0])));
    }
}
