import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Histogram {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double low = Double.parseDouble(args[1]);
        double high = Double.parseDouble(args[2]);
        drawHistogram(n, low, high);
    }

    private static void drawHistogram(int n, double low, double high) {
        double[] arr = StdIn.readAllDoubles();
        int[] frequencyArray = new int[n];
        double intervalValue = (high - low) / n;
        for (double po : arr) {
            if (po <= high && po >= low) {
                int frequencyIndex = (int) ((po - low) / intervalValue);
                frequencyArray[frequencyIndex] = frequencyArray[frequencyIndex] + 1;
            }
        }
        StdOut.println(Arrays.toString(frequencyArray));
        for (int k = 0; k < frequencyArray.length; k++) {
            StdDraw.filledRectangle(k * 0.1, frequencyArray[k] * 0.1, 0.1, frequencyArray[k] * 0.1);
        }
    }
}
