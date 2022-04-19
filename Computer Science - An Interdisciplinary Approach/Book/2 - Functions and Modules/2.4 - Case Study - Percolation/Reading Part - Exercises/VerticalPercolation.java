import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/******************************************************************************
 *  Compilation:  javac VerticalPercolation.java
 *  Execution:    java VerticalPercolation < input.txt
 *  Dependencies: StdArrayIO.java StdOut.java
 *  Data files:   https://introcs.cs.princeton.edu/java/24percolation/test5.txt
 *                https://introcs.cs.princeton.edu/java/24percolation/test8.txt
 *                https://introcs.cs.princeton.edu/java/24percolation/testD.txt
 *                https://introcs.cs.princeton.edu/java/24percolation/testV.txt
 *                https://introcs.cs.princeton.edu/java/24percolation/testT.txt
 *                https://introcs.cs.princeton.edu/java/24percolation/testF.txt
 *                https://introcs.cs.princeton.edu/java/24percolation/testTiny.txt
 *                https://introcs.cs.princeton.edu/java/24percolation/testV.txt
 *
 *  % java VerticalPercolation < test5.txt 
 *  5 5
 *  0 1 1 0 1 
 *  0 0 1 0 1 
 *  0 0 0 0 1 
 *  0 0 0 0 1 
 *  0 0 0 0 1 
 *  true
 *
 *  % java VerticalPercolation < testD.txt 
 *  8 8
 *  0 0 0 1 1 1 0 1 
 *  0 0 0 0 0 1 0 1 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 0 0 0 
 *  0 0 0 0 0 0 0 0 
 *  0 0 0 0 0 0 0 0 
 *  false
 *
 *  % java VerticalPercolation < testV.txt
 *  8 8
 *  0 0 0 1 1 1 0 1 
 *  0 0 0 0 0 1 0 1 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  true
 *
 ******************************************************************************/

public class VerticalPercolation {

    // given an n-by-n matrix of open sites, return an n-by-n matrix
    // of sites reachable from the top via a vertical path of open sites
    public static boolean[][] flow(boolean[][] isOpen) {
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];

        // identify full sites in row 0
        System.arraycopy(isOpen[0], 0, isFull[0], 0, n);

        // update remaining rows
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isFull[i][j] = isOpen[i][j] && isFull[i-1][j];
            }
        }

        return isFull;
    }


    // does the system percolate?
    public static boolean percolates(boolean[][] isOpen) {
        int n = isOpen.length;
        boolean[][] isFull = flow(isOpen);
        for (int j = 0; j < n; j++) {
            if (isFull[n-1][j]) return true;
        }
        return false;
    }

    // draw the n-by-n boolean matrix to standard draw
    public static void show(boolean[][] a, boolean which) {
        int n = a.length;
        StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1, n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, n-i-1, 0.5);
    }

    // return a random n-by-n boolean matrix, where each entry is
    // true with probability p
    public static boolean[][] random(int n, double p) {
        boolean[][] a = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }

    // test client
    public static void main(String[] args) {
        boolean[][] isOpen = StdArrayIO.readBoolean2D();
        StdArrayIO.print(flow(isOpen));
        StdOut.println(percolates(isOpen));
    }

}