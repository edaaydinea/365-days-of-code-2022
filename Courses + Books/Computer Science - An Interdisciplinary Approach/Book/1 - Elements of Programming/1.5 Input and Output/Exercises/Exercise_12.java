import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_12 {
    public static void main(String[] args) {
        StdOut.println("Enter name and two integer values");

        String[] lines = new String[0];
        while (!StdIn.isEmpty())
            lines = StdIn.readAllStrings();

        for (int i = 0; i < lines.length - 2; i += 3) {
            String name = lines[i];
            int n1 = Integer.parseInt(lines[i + 1]);
            int n2 = Integer.parseInt(lines[i + 2]);

            StdOut.printf("%-15s%-5d%-5d%-5.3f\n", name, n1, n2, 1.0 * n1 / n2);
        }
    }
}
