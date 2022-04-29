import edu.princeton.cs.algs4.StdOut;

public class Euclid {
    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        return gcd(p, q % p);
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int divisor = gcd(p, q);
        StdOut.println(divisor);
    }
}
