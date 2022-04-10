import edu.princeton.cs.algs4.StdDraw;

public class Exercise_26 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double minR = Double.parseDouble(args[2]);
        double maxR = Double.parseDouble(args[3]);

        for (int i = 1; i <= n; i++) {
            // set circle color
            StdDraw.setPenColor(Math.random() < p ? StdDraw.BLACK : StdDraw.WHITE);

            // pick random position
            double x = Math.random();
            double y = Math.random();

            // pick random radius and draw circle
            StdDraw.filledCircle(x, y, Math.random() < 0.5 ? minR : maxR);
        }
    }
}
