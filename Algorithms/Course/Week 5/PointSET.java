import java.util.ArrayList;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class PointSET {
    private TreeSet<Point2D> pointsTreeSet;

    // construct an empty set of points
    public PointSET() {
        pointsTreeSet = new TreeSet<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return pointsTreeSet.isEmpty();
    }

    // number of points in the set
    public int size() {
        return pointsTreeSet.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException("point is null");

        pointsTreeSet.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException("point is null");

        return pointsTreeSet.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        for (Point2D p : pointsTreeSet) {
            StdDraw.point(p.x(), p.y());
        }
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException("rectangle is null");

        ArrayList<Point2D> result = new ArrayList<>();
        for (Point2D p : pointsTreeSet) {
            if (rect.contains(p))
                result.add(p);
        }
        return result;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException("point is null");

        if (pointsTreeSet.isEmpty()) return null;

        Point2D nearest = pointsTreeSet.first();
        for (Point2D curP : pointsTreeSet) {
            if (curP.distanceTo(p) < nearest.distanceTo(p)) nearest = curP;
        }
        return nearest;
    }

    private static void drawRect(RectHV r) {
        StdDraw.line(r.xmin(), r.ymin(), r.xmin(), r.ymax());
        StdDraw.line(r.xmin(), r.ymax(), r.xmax(), r.ymax());
        StdDraw.line(r.xmax(), r.ymax(), r.xmax(), r.ymin());
        StdDraw.line(r.xmax(), r.ymin(), r.xmin(), r.ymin());
    }

    private static void drawPoint(Point2D p) {
        StdDraw.point(p.x(), p.y());
    }

    private static final int numOfPoints = 100;

    // unit testing of the methods (optional)
    public static void main(String[] args) {

        Point2D[] testPoints = new Point2D[numOfPoints];

        // // random y
        // for (int i =0;i<numOfPoints;i++){
        //     testPoints[i] = new Point2D((double) i/ (double) numOfPoints, StdRandom.uniform());
        // }
        // StdRandom.shuffle(testPoints);

        //linear
        for (int i = 0; i < numOfPoints; i++) {
            double val = (double) i / (double) numOfPoints;
            testPoints[i] = new Point2D(val, val);
        }
        StdRandom.shuffle(testPoints);

        PointSET pSet = new PointSET();
        for (Point2D p : testPoints) {
            pSet.insert(p);
        }

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.01);
        pSet.draw();

        //nearest
        Point2D tPoint = new Point2D(StdRandom.uniform(), StdRandom.uniform());
        StdOut.println("test point:" + tPoint.toString());
        Point2D nearest = pSet.nearest(tPoint);
        StdOut.println("nearest point:" + nearest.toString());
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(tPoint.x(), tPoint.y(), nearest.x(), nearest.y());

        //rect
        RectHV tRect = new RectHV(0.4, 0.4, 0.6, 0.6);
        StdOut.println("test rect:" + tRect.toString());
        StdDraw.setPenColor(StdDraw.GREEN);
        drawRect(tRect);
        int numOfPointsInRect = 0;
        // StdOut.println("points in rect: ");
        StdDraw.setPenColor(StdDraw.RED);
        for (Point2D p : pSet.range(tRect)) {
            numOfPointsInRect++;
            drawPoint(p);
        }
        StdOut.printf("num points in rect: %d\nw", numOfPointsInRect);
    }
}