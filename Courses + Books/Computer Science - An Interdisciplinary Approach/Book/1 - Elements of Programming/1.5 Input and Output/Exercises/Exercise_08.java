import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Exercise_08 {
    public static void main(String[] args) {
        StdOut.print("Enter positive floating-point numbers (ctrl + d to stop): ");

        double geoMean;
        double harmonicMean;
        double sum = 0.0;

        ArrayList<Double> numbers = new ArrayList<>();

        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }

        int n = numbers.size(); // size of ArrayList

        double multiplication = numbers.get(0);

        for (Double number : numbers) {
            multiplication *= number;
        }

        geoMean = (Math.pow(multiplication, 1.0 / n));
        StdOut.println("Geometric mean: " + geoMean);

        for (Double number : numbers) {
            sum = 1.0 / number;
        }

        harmonicMean = n / sum;
        StdOut.println("Harmonic mean: " + harmonicMean);
    }
}
