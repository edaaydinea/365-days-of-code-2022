import edu.princeton.cs.algs4.StdOut;

public class Exercise_02 {
    public static void main(String[] args) {
        StdOut.printf("sinh(%s) = %,.5f\n", 1, Hyperbolic.sinh(1));
        StdOut.printf("sinh(%s) = %,.5f\n", -1, Hyperbolic.sinh(-1));
        StdOut.printf("sinh(%s) = %,.5f\n", 0, Hyperbolic.sinh(0));
        StdOut.printf("sinh(%s) = %,.5f\n", Double.MAX_VALUE, Hyperbolic.sinh(Double.MAX_VALUE));
        StdOut.printf("sinh(%s) = %,.5f\n", Double.MIN_VALUE, Hyperbolic.sinh(Double.MIN_VALUE));
        StdOut.printf("sinh(%s) = %,.5f\n", Double.POSITIVE_INFINITY, Hyperbolic.sinh(Double.POSITIVE_INFINITY));
        StdOut.printf("sinh(%s) = %,.5f\n", Double.NEGATIVE_INFINITY, Hyperbolic.sinh(Double.NEGATIVE_INFINITY));

        System.out.println();

        StdOut.printf("cosh(%s) = %,.5f\n", 1, Hyperbolic.cosh(1));
        StdOut.printf("cosh(%s) = %,.5f\n", -1, Hyperbolic.cosh(-1));
        StdOut.printf("cosh(%s) = %,.5f\n", 0, Hyperbolic.cosh(0));
        StdOut.printf("cosh(%s) = %,.5f\n", Double.MAX_VALUE, Hyperbolic.cosh(Double.MAX_VALUE));
        StdOut.printf("cosh(%s) = %,.5f\n", Double.MIN_VALUE, Hyperbolic.cosh(Double.MIN_VALUE));
        StdOut.printf("cosh(%s) = %,.5f\n", Double.POSITIVE_INFINITY, Hyperbolic.cosh(Double.POSITIVE_INFINITY));
        StdOut.printf("cosh(%s) = %,.5f\n", Double.NEGATIVE_INFINITY, Hyperbolic.cosh(Double.NEGATIVE_INFINITY));

        System.out.println();

        StdOut.printf("tanh(%s) = %,.5f\n", 1, Hyperbolic.tanh(1));
        StdOut.printf("tanh(%s) = %,.5f\n", -1, Hyperbolic.tanh(-1));
        StdOut.printf("tanh(%s) = %,.5f\n", 0, Hyperbolic.tanh(0));
        StdOut.printf("tanh(%s) = %,.5f\n", Double.MAX_VALUE, Hyperbolic.tanh(Double.MAX_VALUE));
        StdOut.printf("tanh(%s) = %,.5f\n", Double.MIN_VALUE, Hyperbolic.tanh(Double.MIN_VALUE));
        StdOut.printf("tanh(%s) = %,.5f\n", Double.POSITIVE_INFINITY, Hyperbolic.tanh(Double.POSITIVE_INFINITY));
        StdOut.printf("tanh(%s) = %,.5f\n", Double.NEGATIVE_INFINITY, Hyperbolic.tanh(Double.NEGATIVE_INFINITY));

        System.out.println();

        StdOut.printf("coth(%s) = %,.5f\n", 1, Hyperbolic.coth(1));
        StdOut.printf("coth(%s) = %,.5f\n", -1, Hyperbolic.coth(-1));
        StdOut.printf("coth(%s) = %,.5f\n", 0, Hyperbolic.coth(0));
        StdOut.printf("coth(%s) = %,.5f\n", Double.MAX_VALUE, Hyperbolic.coth(Double.MAX_VALUE));
        StdOut.printf("coth(%s) = %,.5f\n", Double.MIN_VALUE, Hyperbolic.coth(Double.MIN_VALUE));
        StdOut.printf("coth(%s) = %,.5f\n", Double.POSITIVE_INFINITY, Hyperbolic.coth(Double.POSITIVE_INFINITY));
        StdOut.printf("coth(%s) = %,.5f\n", Double.NEGATIVE_INFINITY, Hyperbolic.coth(Double.NEGATIVE_INFINITY));

        System.out.println();

        StdOut.printf("sech(%s) = %,.5f\n", 1, Hyperbolic.sech(1));
        StdOut.printf("sech(%s) = %,.5f\n", -1, Hyperbolic.sech(-1));
        StdOut.printf("sech(%s) = %,.5f\n", 0, Hyperbolic.sech(0));
        StdOut.printf("sech(%s) = %,.5f\n", Double.MAX_VALUE, Hyperbolic.sech(Double.MAX_VALUE));
        StdOut.printf("sech(%s) = %,.5f\n", Double.MIN_VALUE, Hyperbolic.sech(Double.MIN_VALUE));
        StdOut.printf("sech(%s) = %,.5f\n", Double.POSITIVE_INFINITY, Hyperbolic.sech(Double.POSITIVE_INFINITY));
        StdOut.printf("sech(%s) = %,.5f\n", Double.NEGATIVE_INFINITY, Hyperbolic.sech(Double.NEGATIVE_INFINITY));

        System.out.println();

        StdOut.printf("csch(%s) = %,.5f\n", 1, Hyperbolic.csch(1));
        StdOut.printf("csch(%s) = %,.5f\n", -1, Hyperbolic.csch(-1));
        StdOut.printf("csch(%s) = %,.5f\n", 0, Hyperbolic.csch(0));
        StdOut.printf("csch(%s) = %,.5f\n", Double.MAX_VALUE, Hyperbolic.csch(Double.MAX_VALUE));
        StdOut.printf("csch(%s) = %,.5f\n", Double.MIN_VALUE, Hyperbolic.csch(Double.MIN_VALUE));
        StdOut.printf("csch(%s) = %,.5f\n", Double.POSITIVE_INFINITY, Hyperbolic.csch(Double.POSITIVE_INFINITY));
        StdOut.printf("csch(%s) = %,.5f\n", Double.NEGATIVE_INFINITY, Hyperbolic.csch(Double.NEGATIVE_INFINITY));
    }
}
