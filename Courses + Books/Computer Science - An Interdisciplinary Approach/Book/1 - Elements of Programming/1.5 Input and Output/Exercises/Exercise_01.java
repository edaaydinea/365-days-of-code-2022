import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Exercise_01 {
    public static void main(String[] args) {

        // first value read initialized min and max
        int max = StdIn.readInt();
        int min = max;

        // read in the data, keep track of min and max
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value > max) max = value;
            if (value < min) min = value;
        }

        // output
        StdOut.println("maximum  = " + max + ", minimum = " + min);
    }
}
