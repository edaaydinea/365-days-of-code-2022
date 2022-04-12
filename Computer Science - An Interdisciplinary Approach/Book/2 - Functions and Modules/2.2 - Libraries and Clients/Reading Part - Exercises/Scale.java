import edu.princeton.cs.algs4.StdStats;

public class Scale {

    public static double[] linearScale(double ymin, double ymax, double[] a) {
        double rmin = StdStats.min(a);
        double rmax = StdStats.max(a);

        double[] scaled = new double[a.length];
        for (int i = 0; i < a.length; i++)
            scaled[i] = ((a[i] - rmin) / (rmax - rmin)) * (ymax - ymin) + ymin;

        return scaled;
    }

    private static void validateArray(double[] a) {
        if (a == null) throw new IllegalArgumentException("Array is null");
    }
}