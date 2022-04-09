import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac RandomSurferHistogram.java
 *  Execution:    java RandomSurferHistogram T
 *  Data files:   https://introcs.cs.princeton.edu/java/16pagerank/tinyG.txt
 *                https://introcs.cs.princeton.edu/java/16pagerank/mediumG.txt
 *
 *  % java Transition < tinyG.txt | java RandomSurferHistogram 1000000
 *   0.27297 0.26583 0.14598 0.24729 0.06793
 *
 ******************************************************************************/

public class RandomSurferHistogram {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();

        int trials = Integer.parseInt(args[0]);   // number of moves
        int n = StdIn.readInt();                  // number of pages
        StdIn.readInt();                          // ignore integer required by input format

        // Read transition matrix.
        double[][] p = new double[n][n];          // p[i][j] = prob. that surfer moves from page i to page j
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                p[i][j] = StdIn.readDouble();


        int[] freq = new int[n];                  // freq[i] = # times surfer hits page i

        // Start at page 0. 
        int page = 0;

        for (int t = 0; t < trials; t++) {

            // Make one random move. 
            double r = Math.random();
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                // Find interval containing r. 
                sum += p[page][j];
                if (r < sum) {
                    page = j;
                    break;
                }
            }
            freq[page]++;

            // plot histogram of frequencies
            StdDraw.clear();
            StdDraw.setXscale(-1, n);
            StdDraw.setYscale(0, trials);
            for (int k = 0; k < n; k++) {
                StdDraw.filledRectangle(k, freq[k]/2.0, 0.25, freq[k]/2.0);
            }
            StdDraw.show();
            StdDraw.pause(20);
        }




        // Print page ranks. 
        for (int i = 0; i < n; i++) {
            StdOut.printf("%8.5f", (double) freq[i] / trials);
        }
        StdOut.println();
    }
} 