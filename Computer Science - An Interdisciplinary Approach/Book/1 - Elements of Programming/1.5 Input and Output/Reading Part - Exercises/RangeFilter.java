import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RangeFilter {
    public static void main(String[] args) {
        // Filter out numbers not between low and high.
        int low = Integer.parseInt(args[0]);
        int high = Integer.parseInt(args[1]);
        while (!StdIn.isEmpty())
        {
            // Process one number.
            int value = StdIn.readInt();
            if (value >= low && value <= high)
                StdOut.print(value + " ");
        }
        StdOut.println();
    }
}
