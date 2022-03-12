import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.InputMismatchException;

public class SortingThreeNumbers {
    public static void main(String[] args) {

        for (boolean test = false; !test; ) {
            try {
                StdOut.println("Enter three integers:");

                int a = StdIn.readInt();
                int b = StdIn.readInt();
                int c = StdIn.readInt();
                test = true;
                int temp;

                if (a > b) {
                    temp = a;
                    a = b;
                    b = temp;
                }
                if (a > c) {
                    temp = a;
                    a = c;
                    c = temp;
                }
                if (b > c) {
                    temp = b;
                    b = c;
                    c = temp;
                }

                StdOut.printf("Ascending order: %d, %d, %d", a, b, c);

            } catch (InputMismatchException e) {
                StdOut.println("Invalid input");
                test = false;
            }
        }


    }
}
