import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac SAT.java
 *  Execution:    java SAT z
 *
 *  java SAT 1200
 *  0.8067627906285625
 *
 *  java SAT 1500
 *  0.9893164837383883
 *
 ******************************************************************************/

public class SAT {
    public static void main(String[] args) {
        double z = Double.parseDouble(args[0]);
        double v = Gaussian.cdf((z - 1019) / 209);
        StdOut.println(v);
    }
}