import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
    Program 1.5.3 - Averaging a stream of numbers
 */
public class Average {
    public static void main(String[] args) {
        // Average the numbers on standard input.
        double sum = 0.0;
        int n = 0;
        while (!StdIn.isEmpty()){
            // Read a number from standard input and add to sum.
            double value = StdIn.readDouble();
            sum += value;
            n++;
        }
        double average = sum / n;
        StdOut.println("Average is " + average);
    }
}
