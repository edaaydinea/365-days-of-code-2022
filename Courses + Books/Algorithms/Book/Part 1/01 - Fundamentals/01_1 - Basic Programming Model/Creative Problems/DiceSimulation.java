import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DiceSimulation {

    public static void main(String[] args) {

        double[] dist = calculate_dist();
        StdOut.print("Enter the experiment times: ");
        int experiment_times = StdIn.readInt();
        double[] experiment_dist = validate_dist(experiment_times);

        for (int i = 2; i <= 12; i++) {
            StdOut.println("sum " + i);
            StdOut.println("cal: " + dist[i]);
            StdOut.println("exp: " + experiment_dist[i]);
            StdOut.println("");
        }

    }

    public static double[] calculate_dist() {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }

        return dist;
    }

    public static double[] validate_dist(int times) {

        double[] dist = new double[13];

        for (int i = 0; i < times; i++) {
            int dice_a = StdRandom.uniform(1, 7);
            int dice_b = StdRandom.uniform(1, 7);
            dist[dice_a + dice_b] += 1.0;
        }

        for (int k = 2; k <= 12; k++) {
            dist[k] /= times;
        }

        return dist;
    }

}
