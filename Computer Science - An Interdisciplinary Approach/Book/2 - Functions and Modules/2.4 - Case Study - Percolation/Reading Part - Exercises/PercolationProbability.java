import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac PercolationProbability.java
 *  Execution:    java PercolationProbability n p trials
 *  Dependencies: Percolation.java StdOut.java
 *
 *  Repeatedly generated n-by-n boolean matrices, where each site
 *  is true with probability p, and compute the probability that
 *  the system percolates.
 *
 *  % java PercolationProbability 32 0.4 10000
 *
 ******************************************************************************/


public class PercolationProbability {

    // do specified number of trials and return fraction that percolate
    public static double evaluate(int n, double p, int trials) {
        int count = 0;
        for (int t = 0; t < trials; t++) {
            boolean[][] isOpen = Percolation.random(n, p);
            if (Percolation.percolates(isOpen))
                count++;
        }
        return (double) count / trials;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        int trials = Integer.parseInt(args[2]);
        double q = evaluate(n, p, trials);
        StdOut.println(q);
    }
}
