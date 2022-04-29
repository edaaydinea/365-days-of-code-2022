import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;
/*
Write a code fragment that prints the contents of a two-dimensional boolean array,
using * to present true and as space to represent false. Include row and column numbers.
 */

public class TwoDimensionalBooleanArray {
    public static void printArray(boolean[][] array) {
        for (boolean[] booleans : array) {
            for (boolean aBoolean : booleans) {
                StdOut.print(aBoolean ? "*" : " ");
            }
            StdOut.print("\n");
        }
        StdOut.printf("Array contains %d rows and %d columns\n", array.length, array[0].length);
    }

    public static void main(String[] args) {
        StdOut.println("Enter 2D array size: ");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        StdOut.println("Enter array elements: ");

        boolean[][] twoD = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                twoD[i][j] = scanner.nextBoolean();
            }
        }

        printArray(twoD);
    }
}
