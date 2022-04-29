import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_02 {
    public static void main(String[] args) {
        StdOut.println("Enter positive numbers:(ctrl + d to stop");

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value < 0) StdOut.println("Only positive values are allowed, try again");
            else {
                if (value > max) max = value;
                if (value < min) min = value;
            }
        }

        StdOut.printf("Maximum #: %d, Minimum #: %d", max, min);
    }
}