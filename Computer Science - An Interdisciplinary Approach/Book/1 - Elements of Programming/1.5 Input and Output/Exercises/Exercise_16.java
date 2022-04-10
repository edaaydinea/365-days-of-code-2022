import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_16 {
    public static void main(String[] args) {
        double m = 0.0, x = 0.0, y = 0.0;

        StdOut.printf("Enter the sequence of objects x,y, m (ctrl + d to stop) \n");
        while (!StdIn.isEmpty()) {
            double xi = StdIn.readDouble();
            double yi = StdIn.readDouble();
            double mi = StdIn.readDouble();

            m += mi;
            x += mi * xi;
            y += mi * yi;
        }

        StdOut.printf("Centroid of objects is (%.3f, %.3f) with total mass of %.3fkg",
                x / m, y / m, m);
    }
}
