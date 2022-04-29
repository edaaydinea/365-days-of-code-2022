import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise_14 {
    public static void main(String[] args) {
        StdOut.println("Enter the n reals numbers between (ctrl + d to stop): ");

        double sumSquares;
        double average;
        int median;
        double percentage;

        ArrayList<Integer> numbers = new ArrayList<>();

        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readInt());
        }

        int n = numbers.size(); // size of ArrayList

        Integer max = Collections.max(numbers);
        StdOut.printf("Maximum number: " + max);
        StdOut.println();

        Integer min = Collections.min(numbers);
        StdOut.printf("Minimum number: " + min);
        StdOut.println();

        sumSquares = (n * (n + 1) * (2 * n + 1)) / 6.0;
        StdOut.printf("Sum of n Square Numbers: " + sumSquares);
        StdOut.println();

        average = n * (n + 1) / 2.0;
        StdOut.printf("Average of n numbers: " + average);
        StdOut.println();

        if (n % 2 == 1)
            median = numbers.get((n + 1) / 2 - 1);
        else
            median = (numbers.get(n / 2 - 1) + numbers.get(n / 2)) / 2;

        StdOut.printf("Median of n numbers: " + median);
        StdOut.println();

        int count = 0;

        for (Integer number : numbers) {
            if (number > average)
                count++;
        }

        percentage = (count * 100.0) / n;
        StdOut.printf("Percentage is: " + percentage);
        StdOut.println();

        Collections.sort(numbers);
        StdOut.printf("Ascending order: " + numbers);
        StdOut.println();

        Collections.shuffle(numbers);
        StdOut.printf("Random order: " + numbers);
        StdOut.println();

    }
}
