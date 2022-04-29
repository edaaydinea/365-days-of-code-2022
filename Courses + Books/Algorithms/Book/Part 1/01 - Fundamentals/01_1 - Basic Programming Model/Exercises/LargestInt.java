import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class LargestInt {
    private static int lg(int n) {
        int count = 0;
        while (n > 0) {
            n /= 2;
            ++count;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        StdOut.print("Enter the n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        StdOut.print(lg(n));
    }
}
