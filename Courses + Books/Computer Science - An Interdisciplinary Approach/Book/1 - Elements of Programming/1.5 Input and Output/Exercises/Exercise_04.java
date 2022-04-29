import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_04 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double sum = 0;
        double squaresSum = 0;
        double[] nums = new double[n];
        StdOut.printf("Enter %d floating-point #'s\n", n);

        // get sum and power of 2 sums
        for (int i = 0; i < n; i++) {
            double value = StdIn.readDouble(); // collect numbers for further use
            nums[i] = value;
            sum += value;
            squaresSum += Math.pow(value, 2);
        }

        // calculate mean and standard deviations
        double mean = sum / n;
        double ssd = Math.sqrt((squaresSum - 2 * mean * sum + n * Math.pow(mean, 2)) / (n - 1)); // simplification
        StdOut.printf("mean = %.2f, standard deviation = %.2f", mean, ssd);

        double d = 1.5;
        StdOut.printf("\nValues that are %.2f away standard deviations: ", d);
        for (int i = 0; i < n; i++) {
            double diff = Math.abs(nums[i] - mean) / ssd;
            if (diff > d) StdOut.print(nums[i] + " ");
        }
    }
}
