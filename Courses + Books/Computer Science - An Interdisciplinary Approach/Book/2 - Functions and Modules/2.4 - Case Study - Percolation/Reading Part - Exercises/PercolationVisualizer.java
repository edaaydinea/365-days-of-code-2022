import edu.princeton.cs.algs4.StdDraw;

/******************************************************************************
 *  Compilation:  javac PercolationVisualizer.java
 *  Execution:    java PercolationVisualizer n p trials
 *  Dependencies: Percolation.java StdDraw.java
 *
 *  Repeatedly generated n-by-n boolean matrices, where each site
 *  is true with probability p. Plot the results using standard
 *  graphics.
 *
 *  % java PercolationVisualizer 20 0.35 10
 *
 *  % java PercolationVisualizer 20 0.45 10
 *
 ******************************************************************************/


public class PercolationVisualizer {
    public static void main(String[] args) {
        int n      = Integer.parseInt(args[0]);
        double p   = Double.parseDouble(args[1]);
        int trials = Integer.parseInt(args[2]);

        // repeatedly created n-by-n matrices and display them using standard draw
        StdDraw.enableDoubleBuffering();
        for (int t = 0; t < trials; t++) {
            boolean[][] open = Percolation.random(n, p);
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Percolation.show(open, false);
            StdDraw.setPenColor(StdDraw.GRAY);
            boolean[][] full = Percolation.flow(open);
            Percolation.show(full, true);
            StdDraw.show();
            StdDraw.pause(1000);
        }
    }
}