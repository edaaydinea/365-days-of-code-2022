/******************************************************************************
 *  Compilation:  javac ThreeSum.java
 *  Execution:    java ThreeSum < input.txt
 *                java Generator n | java ThreeSum
 *  Data files:   https://introcs.cs.princeton.edu/java/41analysis/8ints.txt
 *                https://introcs.cs.princeton.edu/java/41analysis/1Kints.txt
 *                https://introcs.cs.princeton.edu/java/41analysis/2Kints.txt
 *                https://introcs.cs.princeton.edu/java/41analysis/4Kints.txt
 *                https://introcs.cs.princeton.edu/java/41analysis/8Kints.txt
 *                https://introcs.cs.princeton.edu/java/41analysis/16Kints.txt
 *                https://introcs.cs.princeton.edu/java/41analysis/32Kints.txt
 *                https://introcs.cs.princeton.edu/java/41analysis/64Kints.txt
 *                https://introcs.cs.princeton.edu/java/41analysis/128Kints.txt
 *
 *  A program with cubic running time. Reads in n integers
 *  and counts the number of triples that sum to exactly 0.
 *
 *  % java ThreeSum < 8ints.txt 
 *  4
 *  30 -30 0
 *  30 -20 -10
 *  -30 -10 40
 *  -10 0 10
 *
 *  % java ThreeSum < 1Kints.txt
 *  0
 *
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *
 ******************************************************************************/

public class ThreeSum {

    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    } 

    public static void main(String[] args)  { 
        int[] a = StdIn.readAllInts();
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    } 
} 
