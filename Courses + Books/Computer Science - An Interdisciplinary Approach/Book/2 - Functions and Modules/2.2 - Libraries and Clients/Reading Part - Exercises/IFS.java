import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/******************************************************************************
 *  Compilation:  javac IFS.java
 *  Execution:    java IFS trials < input.txt
 *  Dependencies: StdDraw.java
 *
 *  Here are some sample data files:
 *
 *  https://introcs.cs.princeton.edu/java/22library/barnsley.txt
 *  https://introcs.cs.princeton.edu/java/22library/binary.txt
 *  https://introcs.cs.princeton.edu/java/22library/culcita.txt
 *  https://introcs.cs.princeton.edu/java/22library/cyclosorus.txt
 *  https://introcs.cs.princeton.edu/java/22library/dragon.txt
 *  https://introcs.cs.princeton.edu/java/22library/fern-sedgewick.txt
 *  https://introcs.cs.princeton.edu/java/22library/fishbone.txt
 *  https://introcs.cs.princeton.edu/java/22library/floor.txt
 *  https://introcs.cs.princeton.edu/java/22library/koch.txt
 *  https://introcs.cs.princeton.edu/java/22library/sierpinski.txt
 *  https://introcs.cs.princeton.edu/java/22library/spiral.txt
 *  https://introcs.cs.princeton.edu/java/22library/swirl.txt
 *  https://introcs.cs.princeton.edu/java/22library/tree.txt
 *  https://introcs.cs.princeton.edu/java/22library/zigzag.txt
 *
 ******************************************************************************/

public class IFS {
    public static void main(String[] args) {

        // number of iterations
        int trials = Integer.parseInt(args[0]);

        // probability distribution for choosing each rule
        double[] dist = StdArrayIO.readDouble1D();

        // update matrices
        double[][] cx = StdArrayIO.readDouble2D();
        double[][] cy = StdArrayIO.readDouble2D();

        // current value of (x, y)
        double x = 0.0, y = 0.0;

        // do trials iterations of the chaos game
        StdDraw.enableDoubleBuffering();
        for (int t = 0; t < trials; t++) {

            // pick a random rule according to the probability distribution
            int r = StdRandom.discrete(dist);

            // do the update
            double x0 = cx[r][0] * x + cx[r][1] * y + cx[r][2];
            double y0 = cy[r][0] * x + cy[r][1] * y + cy[r][2];
            x = x0;
            y = y0;

            // draw the resulting point
            StdDraw.point(x, y);

            // for efficiency, display only every 100 iterations
            if (t % 100 == 0) {
                StdDraw.show();
                StdDraw.pause(10);
            }
        }

        // ensure everything gets drawn
        StdDraw.show();
    }
}

