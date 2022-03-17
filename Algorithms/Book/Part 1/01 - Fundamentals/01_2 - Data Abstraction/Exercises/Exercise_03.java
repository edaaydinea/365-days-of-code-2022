import edu.princeton.cs.algs4.*;

/*
Write an Interval2D client that takes command-line arguments N, min, and max and
generates N random 2D intervals whose width and height are un,formly distributed
between min and max in the unit square. Draw them on StdDraw and print the number
of pairs of intervals that intersect and the number of intervals that are contained
in one another.
 */
public class Exercise_03 {
    public static void main(String[] args) {
        System.out.println("Enter the N: ");
        int N = StdIn.readInt();
        System.out.println("Enter the min and max: ");
        double min = StdIn.readDouble();
        double max = StdIn.readDouble();

        StdDraw.setXscale(0.0, 1.0);
        StdDraw.setYscale(0.0, 1.0);

        Interval2D[] boxes = new Interval2D[N];
        Point2D[] leftbottom = new Point2D[N];
        Point2D[] righttop = new Point2D[N];

        for (int i = 0; i < N; i++) {
            double xmin = StdRandom.uniform(min, max);
            double xmax = StdRandom.uniform(min, max);
            double ymin = StdRandom.uniform(min, max);
            double ymax = StdRandom.uniform(min, max);

            if (xmin > xmax) {
                double temp = xmax;
                xmax = xmin;
                xmin = temp;
            }
            if (ymin > ymax) {
                double temp = ymax;
                ymax = ymin;
                ymin = temp;
            }
            Interval1D xinterval = new Interval1D(xmin, xmax);
            Interval1D yinterval = new Interval1D(ymin, ymax);
            leftbottom[i] = new Point2D(xmin, ymin);
            righttop[i] = new Point2D(xmax, ymax);
            boxes[i] = new Interval2D(xinterval, yinterval);
            boxes[i].draw();
        }
        int countintersects = 0;
        int countcontains = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (boxes[i].intersects(boxes[j])) countintersects++;
                if (boxes[i].contains(leftbottom[j]) && boxes[i].contains(righttop[j])) countcontains++;
            }

        }
        System.out.println("Number of count intersects: " + countintersects);
        System.out.println("Number of count-contains: " + countcontains);
    }
}
