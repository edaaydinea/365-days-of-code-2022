/******************************************************************************
 *  Compilation:  javac DoublingTest.java
 *  Execution:    java DoublingTest
 *
 *  % java DoublingTest 
 *      512 6.48
 *     1024 8.30
 *     2048 7.75
 *     4096 8.00
 *     8192 8.05
 *   ... 
 *
 ******************************************************************************/

public class DoublingTest {

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(2000000) - 1000000;
        }
        Stopwatch s = new Stopwatch();
        ThreeSum.count(a);
        return s.elapsedTime();
    }


    public static void main(String[] args) { 
        StdOut.printf("%7s %7s %4s\n", "size", "time", "ratio");
        double previous = timeTrial(256);
        for (int n = 512; true; n += n) {
            double current = timeTrial(n);
            StdOut.printf("%7d %7.2f %4.2f\n", n, current, current / previous);
            previous = current;
        } 
    } 
} 

