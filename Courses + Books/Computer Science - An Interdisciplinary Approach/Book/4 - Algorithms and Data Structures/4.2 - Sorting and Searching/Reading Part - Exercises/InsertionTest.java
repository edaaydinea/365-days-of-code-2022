/******************************************************************************
 *  Compilation:  javac InsertionTest.java
 *  Execution:    java InsertionTest 10
 *  
 *  The method timeTrials() runs InsertionSort.sort() for arrays of random 
 *  double values. The first argument is the number of trials; the second
 *  argument is the length of the array. Multiple trials produce more
 *  accurate results because insertion sort's running time depends on
 *  the input and various system effects.
 *
 *  % java InsertionTest 10  
 *   1024 1.89 
 *   2048 5.00 
 *   4096 3.58 
 *   8192 4.09 
 *  16384 4.83 
 *  32768 3.96
 *
 ******************************************************************************/


public class InsertionTest {
    public static double timeTrials(int n, int trials) {
        Double[] a = new Double[n];
        double total = 0;
        for (int t = 0; t < trials; t++) { 
            for (int i = 0; i < n; i++)
                a[i] = StdRandom.uniform(0.0, 1.0);
            Stopwatch timer = new Stopwatch();
            Insertion.sort(a);
            total += timer.elapsedTime();
        }
        return total;
    }

    public static void main(String[] args) {
        int trials = Integer.parseInt(args[0]);
        double previous = timeTrials(512, trials);
        for (int n = 1024; true; n += n) {
            double current =  timeTrials(n, trials);
            StdOut.printf("%7d %4.2f\n", n, current / previous);
            previous = current;
        }
    }
} 

