import edu.princeton.cs.algs4.StdOut;

public class Exercise_08 {
    public static void main(String[] args) {
        int[] a = new int[10000000];
        int[] b = new int[10000000];

        StdOut.println(a);
        StdOut.println(b);

        StdOut.println();
        int t[] = a;
        a = b;
        b = t;

        StdOut.println(a);
        StdOut.println(b);
    }
}
/*
It swaps them. It could hardly be more efficient because it does so by copying
references, so that it is not necessary to copy millions of elements.
 */
