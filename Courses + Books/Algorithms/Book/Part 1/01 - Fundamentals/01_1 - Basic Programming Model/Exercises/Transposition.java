import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Transposition {

    public static int[][] transposition(int[][] array) {
        int[][] transposed = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                transposed[i][j] = array[j][i];
            }
        }
        return transposed;
    }

    public static void main(String[] args) {
        StdOut.println("Enter 2D array size: ");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        StdOut.println("Enter array elements: ");

        int[][] twoD = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                twoD[i][j] = scanner.nextInt();
            }
        }

        StdOut.println(transposition(twoD));
    }
}
