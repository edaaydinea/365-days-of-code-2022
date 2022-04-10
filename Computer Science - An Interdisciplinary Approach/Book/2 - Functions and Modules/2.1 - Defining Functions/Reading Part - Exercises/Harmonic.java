import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Harmonic.java
 *  Execution:    java Harmonic n
 *
 *  Prints the nth harmonic number: 1/1 + 1/2 + ... + 1/n.
 *
 *  % java Harmonic 10
 *  2.9289682539682538
 *
 *  % java Harmonic 10000
 *  9.787606036044348
 *
 ******************************************************************************/

public class Harmonic {

    // returns 1/1 + 1/2 + 1/3 + ... + 1/n
    public static double harmonic(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int arg = Integer.parseInt(args[i]);
            double value = harmonic(arg);
            StdOut.println(value);
        }
    }

}
