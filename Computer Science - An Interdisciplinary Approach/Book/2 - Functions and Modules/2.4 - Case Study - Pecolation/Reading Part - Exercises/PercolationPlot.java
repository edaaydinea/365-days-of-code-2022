import edu.princeton.cs.algs4.StdDraw;

/******************************************************************************
 *  Compilation:  javac PercolationPlot.java
 *  Execution:    java PercolationPlot n
 *
 *  This recursive program draws a plot of the percolation probability
 *  (experimental observation) against the site vacancy probability
 *  (control variable).
 *
 *  % java PercolationPlot n
 *
 ******************************************************************************/

public class PercolationPlot {

    // recursive curve plotting
    public static void curve(int n, double x0, double y0, double x1, double y1) {
        double gap = 0.01;
        double err = 0.0025;
        int trials = 10000;
        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        double fxm = PercolationProbability.evaluate(n, xm, trials);
        if (x1 - x0 < gap || Math.abs(ym - fxm) < err) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }
        curve(n, x0, y0, xm, fxm);
        StdDraw.filledCircle(xm, fxm, 0.005);
        curve(n, xm, fxm, x1, y1);
    }

    // test client
    public static void main(String[] args) {
        StdDraw.setScale(-0.05, 1.05);
        int n = Integer.parseInt(args[0]);
        curve(n, 0.0, 0.0, 1.0, 1.0);
    }
}