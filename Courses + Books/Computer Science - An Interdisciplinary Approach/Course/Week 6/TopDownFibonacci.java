import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac TopDownFibonacci.java
 *  Execution:    java TopDownFibonacci n
 *
 *  Computes and prints the first n Fibonacci numbers.
 *  This program uses top-down dynamic programming.
 *
 *   % java TopDownFibonacci 7
 *   1: 1
 *   2: 1
 *   3: 2
 *   4: 3
 *   5: 5
 *   6: 8
 *   7: 13
 *
 *   Remark: The 93rd Fibonacci number would overflow a long.
 *
 ******************************************************************************/

public class TopDownFibonacci {
    private static long[] f = new long[92];

    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        // return cached value (if previously computed)
        if (f[n] > 0) return f[n];

        // compute and cache value
        f[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return f[n];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++)
            StdOut.println(i + ": " + fibonacci(i));
    }

}
