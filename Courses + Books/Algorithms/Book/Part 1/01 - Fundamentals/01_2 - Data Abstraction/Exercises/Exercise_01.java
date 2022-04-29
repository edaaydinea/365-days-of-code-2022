import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/*
Write a Point2D client that takes an integer value N from the command line,
generates N random points in the unit square, and computer the distance separating
the closest pair of points.
 */
public class Exercise_01 {
    public static void main(String[] args) {
        int N;
        System.out.println("Enter the N: ");
        N = StdIn.readInt();
        Point2D[] random_points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            random_points[i] = new Point2D(x, y);
        }
        double minimum_distance = 9999;

        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j < i; j++) {
                double distance = random_points[i].distanceTo(random_points[j]);
                if (distance <= minimum_distance)
                    minimum_distance = distance;
            }
        }
        System.out.println("The Minimum Distance: " + minimum_distance);
    }
}
