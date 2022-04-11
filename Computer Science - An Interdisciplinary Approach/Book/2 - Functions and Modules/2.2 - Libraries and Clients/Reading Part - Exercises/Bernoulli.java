import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/******************************************************************************
 *  Compilation:  javac Bernoulli.java
 *  Execution:    java Bernoulli n trials
 *  Dependencies: StdDraw.java StdRandom.java Gaussian.java StdStats.java
 *
 *  Each experiment consists of flipping n fair coins trials times.
 *  Plots a histogram of the number of times i of the n coins are heads.
 *
 *  % java Bernoulli 32 1000
 *
 *  % java Bernoulli 64 1000
 *
 *  % java Bernoulli 128 1000
 *
 ******************************************************************************/


public class Bernoulli {

    // number of heads when flipping n biased-p coins
    public static int binomial(int n, double p) {
        int heads = 0;
        for (int i = 0; i < n; i++) {
            if (StdRandom.bernoulli(p)) {
                heads++;
            }
        }
        return heads;
    }

    // number of heads when flipping n fair coins
    // or call binomial(n, 0.5)
    public static int binomial(int n) {
        int heads = 0;
        for (int i = 0; i < n; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads++;
            }
        }
        return heads;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);        // number of coins to flip per trial
        int trials = Integer.parseInt(args[1]);   // number of trials

        StdDraw.setYscale(0, 0.2);

        // flip n fair coins, trials times
        int[] freq = new int[n + 1];
        for (int t = 0; t < trials; t++) {
            freq[binomial(n)]++;
        }

        // plot normalized values
        double[] normalized = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            normalized[i] = (double) freq[i] / trials;
        }
        StdStats.plotBars(normalized);

        // plot Gaussian approximation
        double mean = n / 2.0;
        double stddev = Math.sqrt(n) / 2.0;
        double[] phi = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            phi[i] = Gaussian.pdf(i, mean, stddev);
        }
        StdStats.plotLines(phi);
    }
}
