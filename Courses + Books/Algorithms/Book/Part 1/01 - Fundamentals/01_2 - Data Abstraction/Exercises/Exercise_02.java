import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

/*
Write an Interval1D client that takes an int value N as command-line argument,
reads N intervals (each defined by a pair of double values) from standard input,
and prints all pairs that intersect.
 */
public class Exercise_02 {
    public static void main(String[] args) {
        System.out.println("Enter the N: ");
        int N = StdIn.readInt();
        Interval1D[] interval1D = new Interval1D[N];

        for (int i = 0; i < N; i++) {
            double low = StdIn.readDouble();
            double high = StdIn.readDouble();
            interval1D[i] = new Interval1D(low, high);
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (interval1D[i].intersects(interval1D[j]))
                    System.out.println(interval1D[i] + " " + interval1D[j]);
            }
        }
    }
}
