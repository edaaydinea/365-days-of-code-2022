import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_10 {
    public static void main(String[] args) {
        final int FROM = 0, TO = 99;

        final int PER_LINE = 10;
        int counter = 0;

        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();

            if (value >= FROM && value <= TO) {
                StdOut.printf("%-4d", value); // left alignment

                counter++;
                if (counter < PER_LINE)
                    StdOut.printf(" ");
                else {
                    counter = 0;
                    StdOut.println();
                }
            }
        }
    }

}
