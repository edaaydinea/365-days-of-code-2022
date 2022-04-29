import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac RandomSurfer.java
 *  Execution:    java RandomSurfer trials
 *  Data files:   https://introcs.cs.princeton.edu/java/16pagerank/tinyG.txt
 *                https://introcs.cs.princeton.edu/java/16pagerank/mediumG.txt
 *
 *  % java Transition < tinyG.txt | java RandomSurfer 1000000
 *   0.27297 0.26583 0.14598 0.24729 0.06793
 *
 ******************************************************************************/

public class RandomSurfer {
    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);   // number of moves
        int m = StdIn.readInt();                  // number of pages  - ignore since m = n
        int n = StdIn.readInt();                  // number of pages
        if (m != n) {
            StdOut.println("m does not equal n");
            return;
        }

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
        }


        // Print page ranks. 
        for (int i = 0; i < n; i++) {
            StdOut.printf("%8.5f", (double) freq[i] / trials);
        }
        StdOut.println();
    }
} 