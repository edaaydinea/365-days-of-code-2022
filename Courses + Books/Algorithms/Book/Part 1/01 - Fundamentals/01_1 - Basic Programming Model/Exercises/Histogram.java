import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class Histogram {

    private static String histogram(int[] array, int M) {
        int[] mArray = new int[M];
        for (int i = 0; i < M; i++) {
            mArray[i] = 0;
        }
        for (int j = 0; j < array.length; j++) {
            mArray[array[j]]++;
        }
        int sum = 0;

        for (int k = 0; k < M; k++) {
            sum += mArray[k];
            StdOut.print(mArray[k] + " ");
        }
        StdOut.print("\n");
        return ("Sum is " + sum + " and array length is " + array.length);
    }

    public static void main(String[] args) {
        Random random = new Random(20);
        int x = StdIn.readInt();
        int[] array = new int[x];
        int M = 10;

        for (int i = 0; i < x; i++) {
            int r = random.nextInt(9);
            array[i] = r;
        }
        StdOut.print(histogram(array, M));
    }


}
