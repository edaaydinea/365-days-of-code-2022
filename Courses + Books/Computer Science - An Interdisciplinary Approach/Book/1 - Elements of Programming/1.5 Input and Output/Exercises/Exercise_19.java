import edu.princeton.cs.algs4.StdDraw;

public class Exercise_19 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]); // [0, 1]

        double cx = .5, cy = .5, r = .5; // unit circle

        StdDraw.setCanvasSize(800, 800);

        // Calculate points placement
        double[] xPoints = new double[n];
        double[] yPoints = new double[n];
        double avgAngle = 360.0 / n;

        for (int i = 0; i < n; i++) {
            double arc = (i * avgAngle * Math.PI) / 180;
            double dx = r * Math.cos(arc);
            double dy = r * Math.sin(arc);

            xPoints[i] = cx + dx;
            yPoints[i] = cy + dy;
        }

        // Plot points
        StdDraw.setPenRadius(0.02);
        for (int i = 0; i < n; i++)
            StdDraw.point(xPoints[i], yPoints[i]);

        // Connect pair points with probability p
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (Math.random() < p)
                    StdDraw.line(xPoints[i], yPoints[i], xPoints[j], yPoints[j]);
            }
        }
    }
}
