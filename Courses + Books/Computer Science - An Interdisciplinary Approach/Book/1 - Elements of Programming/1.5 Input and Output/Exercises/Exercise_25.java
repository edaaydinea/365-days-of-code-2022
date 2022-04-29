import edu.princeton.cs.algs4.StdDraw;

public class Exercise_25 {
    public static void main(String[] args) {

        // 1st shape

        /*
        StdDraw.filledSquare(.5, .5, .5);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledPolygon(new double[]{0, .5, 1, .5}, new double[]{.5, 0, .5, 1});
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledPolygon(new double[]{0, .25, .25}, new double[]{.25, 0, .25});
        StdDraw.filledPolygon(new double[]{0, .25, .25}, new double[]{.75, .75, 1});
        StdDraw.filledPolygon(new double[]{.75, .75, 1}, new double[]{1, .75, .75});
        StdDraw.filledPolygon(new double[]{.75, .75, 1}, new double[]{.25, 0, .25});
        */

        // 2nd shape
        /*
        StdDraw.filledSquare(.5, .5, .5);
        StdDraw.setPenColor(StdDraw.WHITE);
        double[] x = {0, .25, .5, .75, 1, .75, 1, .75, .5, .25, 0, .25};
        double[] y = {.25, 0, .25, 0, .25, .5, .75, 1, .75, 1, .75, .5};
        StdDraw.filledPolygon(x, y);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledPolygon(new double[]{0, .5, 1, .5}, new double[]{.5, 0, .5, 1});
        */


        // 3rd shape

        double[] x = {.25, .75, .75, .25};
        double[] y = {0, 0, 1, 1};
        /*
        StdDraw.filledPolygon(x, y); // | shape
        StdDraw.filledPolygon(y, x); // - shape
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledPolygon(new double[]{0, .5, 1, .5}, new double[]{.5, 0, .5, 1});
        */

        // 4th shape - should use x and y from 3rd shape
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(.5, .5, .5);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledPolygon(x, y); // | shape
        StdDraw.filledPolygon(y, x); // - shape
        double[] xT1 = {0, 0, .25};
        double[] yT1 = {.75, .25, .5};
        double[] xT2 = {.75, 1, 1};
        double[] yT2 = {.5, .25, .75};
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledPolygon(xT1, yT1);
        StdDraw.filledPolygon(yT1, xT1);
        StdDraw.filledPolygon(xT2, yT2);
        StdDraw.filledPolygon(yT2, xT2);
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledPolygon(new double[]{0, .5, 1, .5}, new double[]{.5, 0, .5, 1});


    }
}
