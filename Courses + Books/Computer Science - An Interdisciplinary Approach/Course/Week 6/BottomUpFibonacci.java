import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac BottomUpFibonacci.java
 *  Execution:    java BottomUpFibonacci n
 *
 *  Computes and prints the first n Fibonacci numbers.
 *  This program uses bottom-up dynamic programming.
 *
 *   % java BottomUpFibonacci 7
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

public class BottomUpFibonacci {

    public static long fibonacci(int n) {
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++)
            StdOut.println(i + ": " + fibonacci(i));
    }

}