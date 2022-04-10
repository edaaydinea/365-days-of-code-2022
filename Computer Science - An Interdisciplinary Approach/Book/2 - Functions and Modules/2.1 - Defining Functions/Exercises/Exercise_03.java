import edu.princeton.cs.algs4.StdOut;

public class Exercise_03 {
    public static void main(String[] args) {

        // uniformly generate 3 random boolean values
        boolean a = Math.random() < 0.3;
        boolean b = Math.random() < 0.6;
        boolean c = Math.random() < 1.0;

        StdOut.printf("(%b, %b, %b) => %b", a, b, c, majority(a, b, c));
    }

    public static boolean majority(boolean a, boolean b, boolean c) {
        return a && b || a && c || b && c;
    }
}
