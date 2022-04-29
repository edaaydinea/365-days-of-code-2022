import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.io.File;
import java.util.Arrays;

public class Filtering {
    public static void main(String[] args) {
        StdOut.print("Enter the file name:");
        String file = String.valueOf(new File(StdIn.readLine()));

        // Print the maximum and minimum numbers
        MaxMinNumbers(file);

        // Print the median of the numbers
        MedianOfNumbers(file);

        // Print the kth smallest, for k less than 100.
        KthSmallest(file, StdRandom.uniform(101));

        // Print the sum of the squares of the numbers.
        SumOfSquares(file);

        // Print the average of the N numbers.
        AverageOfNNumbers(file);

        // Print the percentage of numbers greater than the average.
        PercentageOfNumbers(file);

        // Print the N numbers in increasing order.
        NNumbersIncreasingOrder(file);

        // Print the N numbers in random order.
        NNumbersRandomOrder(file);

    }

    private static void MaxMinNumbers(String file) {
        In in = new In(file);
        double n = 0;
        double x = in.readDouble();
        double min = x;
        double max = x;

        while (!in.isEmpty()) {
            x = in.readDouble();
            if (x < min) min = x;
            if (x > max) max = x;
            n += 1;
        }
        in.close();
        StdOut.println("Min: " + min);
        StdOut.println("Max: " + max);
    }

    private static void MedianOfNumbers(String file) {
        In in = new In(file);
        double[] arr = in.readAllDoubles();
        in.close();
        Arrays.sort(arr);

        int medianIndexBaseZero = arr.length / 2;
        int medianIndexBaseOne = medianIndexBaseZero + 1;
        if (arr.length % 2 == 1)
            StdOut.println("Median at: " + medianIndexBaseOne + " value: " + arr[medianIndexBaseZero]);
        else {
            StdOut.println("Median at: " + (medianIndexBaseOne - 1) + " value: " + arr[medianIndexBaseZero - 1]);
            StdOut.println("Median at: " + medianIndexBaseOne + " value: " + arr[medianIndexBaseZero]);
        }
    }

    private static void KthSmallest(String file, int k) {
        In in = new In(file);
        double[] result = new double[k];

        for (int i = 0; i < k; i++) {
            result[i] = in.readDouble();
        }
        Arrays.sort(result);

        while (!in.isEmpty()) {
            double x = in.readDouble();
            result = NewArray(result, x);
        }

        in.close();

        StdOut.println(k + "th smallest: " + result[k - 1]);
    }

    private static double[] NewArray(double[] arr, double x) {

        int len = arr.length;

        double[] arr1 = new double[len + 1];
        System.arraycopy(arr, 0, arr1, 0, len);
        arr1[len] = x;
        Arrays.sort(arr1);

        double[] arr2 = new double[len];
        System.arraycopy(arr1, 0, arr2, 0, len);

        return arr2;
    }

    private static void SumOfSquares(String file) {
        In in = new In(file);
        double sum = 0;
        while (!in.isEmpty()) {
            double x = in.readDouble();
            sum += x * x;
        }
        in.close();
        StdOut.println("Sum of Squares: " + sum);
    }

    private static void AverageOfNNumbers(String file) {
        In in = new In(file);
        double sum = 0;
        int N = 0;
        while (!in.isEmpty()) {
            double x = in.readDouble();
            sum += x;
            N += 1;
        }
        in.close();
        StdOut.println("Average of N Numbers: " + sum / N);
    }

    private static void PercentageOfNumbers(String file) {
        In in = new In(file);
        double[] arr = in.readAllDoubles();
        in.close();
        Arrays.sort(arr);

        int N = arr.length;
        double sum = 0;

        for (double v : arr) {
            sum += v;
        }

        double avg = sum / N;

        int c = 0;

        for (double v : arr) {
            if (v > avg) {
                c += 1;
            }
        }

        StdOut.println("The percentage of numbers greater than the average: " + (double) c * 100 / N + "%");
    }

    private static void NNumbersIncreasingOrder(String file) {
        In in = new In(file);
        double[] arr = in.readAllDoubles();
        in.close();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                StdOut.print(arr[i] + "\n");
            } else {
                StdOut.print(arr[i] + ", ");
            }
        }
    }

    private static void NNumbersRandomOrder(String file) {
        In in = new In(file);
        double[] arr = in.readAllDoubles();
        in.close();

        StdRandom.setSeed(123456789);
        StdRandom.shuffle(arr);

        for (int i = 0; i < arr.length; i++) {
            StdOut.println((i + 1) + "th: " + arr[i]);
        }

    }

}
