import edu.princeton.cs.algs4.StdDraw;

public class Exercise_18 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        StdDraw.setXscale(0, n); // default scale [0, 1]
        StdDraw.setYscale(0, n);

        StdDraw.enableDoubleBuffering();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StdDraw.setPenColor((i + j) % 2 == 0 ? StdDraw.RED : StdDraw.BLACK);
                StdDraw.filledSquare(i + .5, j + .5, .5);
            }
        }

        StdDraw.show();
    }
}
