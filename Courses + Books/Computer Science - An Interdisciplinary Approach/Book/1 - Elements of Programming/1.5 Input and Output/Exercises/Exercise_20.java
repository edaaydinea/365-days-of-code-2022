import edu.princeton.cs.algs4.StdDraw;

public class Exercise_20 {
    public static void main(String[] args) {

        // Diamond
        StdDraw.setPenColor(StdDraw.RED);
        double[] x = new double[]{.10, .15, .20, .15};
        double[] y = new double[]{.85, .75, .85, .95};
        StdDraw.filledPolygon(x, y);

        // Heart
        StdDraw.setPenColor(StdDraw.BLACK);
        double[] hx = new double[]{.50, .75, .99, .75};
        double[] hy = new double[]{.85, .75, .85, .95};
        StdDraw.filledPolygon(hx, hy);
    }
}
