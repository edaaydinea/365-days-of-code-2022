import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_06 {
    public static void main(String[] args) {
        StdOut.println("Enter the sequence of numbers (Ctrl + d to stop)");

        int prev = StdIn.readInt();
        String filter = prev + " ";

        while (!StdIn.isEmpty()) {
            int current = StdIn.readInt();
            if (prev != current) {
                filter += current + " ";
                prev = current;
            }
        }

        StdOut.println(filter);
    }
}