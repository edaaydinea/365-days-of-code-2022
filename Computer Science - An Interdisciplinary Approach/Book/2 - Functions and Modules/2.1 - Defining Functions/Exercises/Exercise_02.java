import edu.princeton.cs.algs4.StdOut;

public class Exercise_02 {
    public static void main(String[] args) {
        boolean a = Math.random() < 0.3;
        boolean b = Math.random() < 0.6;
        boolean c = Math.random() < 1.0;

        StdOut.printf("(%b, %b, %b) => %b", a, b, c, odd(a, b, c));
    }

    public static boolean odd(boolean a, boolean b, boolean c) {
        int count = 0;
        if (a) count++;
        if (b) count++;
        if (c) count++;

        return count % 2 == 1;
    }
}
