import edu.princeton.cs.algs4.StdOut;

/*
Collatz function of N:
- If N is 1, stop.
- If N is even, divide by 2.
- If N is odd, multiply by 3 and add 1.
 */
public class Collatz {
    public static void collatz(int N) {
        StdOut.print(N + " ");
        if (N == 1) return;
        if (N % 2 == 0) collatz(N / 2);
        collatz(3 * N + 1);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        collatz(N);
    }
}
