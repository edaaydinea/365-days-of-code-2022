import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_15 {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);

        double bestx = Double.NaN;
        double besty = Double.NaN;
        double bestz = Double.NaN;
        double bestDist2 = Double.POSITIVE_INFINITY;

        while (!StdIn.isEmpty()) {
            double xi = StdIn.readDouble();
            double yi = StdIn.readDouble();
            double zi = StdIn.readDouble();
            double dist2 = (x - xi) * (x - xi) + (y - yi) * (y - yi) + (z - zi) * (z - zi);
            if (dist2 < bestDist2) {
                bestx = xi;
                besty = yi;
                bestz = zi;
                bestDist2 = dist2;
            }
        }

        // output
        StdOut.printf("Closest point = (%f, %f, %f)\n", bestx, besty, bestz);
    }
}