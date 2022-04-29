/**
 |-------------------------------------------------------------------------------
 | FastCollinearPoints.java
 |-------------------------------------------------------------------------------
 |
 | Author:       Alwin Tareen
 | Created:      Nov 07, 2021
 | Compilation:  javac-algs4 FastCollinearPoints.java
 | Execution:    java-algs4 FastCollinearPoints input8.txt
 |
 | This program determines whether 4 points all lie on the same line segment.
 |
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.ArrayList;

public class FastCollinearPoints
{
    private int count;
    private final LineSegment[] chunks;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points)
    {
        // check for corner cases
        if (points == null)
            throw new IllegalArgumentException("argument to FCP constructor is null");

        for (Point point : points) {
            if (point == null)
                throw new IllegalArgumentException("array contains null Point");
        }

        for (int i = 0; i < points.length - 1; i++)
        {
            for (int j = i+1; j < points.length; j++)
            {
                if (points[i].compareTo(points[j]) == 0)
                    throw new IllegalArgumentException("array contains duplicate Points");
            }
        }

        // determine whether 4 or more points lie on the same line segment
        count = 0;
        ArrayList<LineSegment> pieces = new ArrayList<>();
        Point[] coords = new Point[points.length];
        System.arraycopy(points, 0, coords, 0, points.length);

        for (Point current : points) {
            Arrays.sort(coords, current.slopeOrder());
            //System.out.println(Arrays.toString(coords));
            int limit = 0;
            for (int j = 0; j < coords.length - 2; j++) {
                if (coords[j].slopeTo(coords[j + 1]) == coords[j].slopeTo(coords[j + 2]))
                    limit = j + 2;
                else
                    break;
            }
            if (limit > 0) {
                Arrays.sort(coords, 0, limit + 1);
                pieces.add(new LineSegment(coords[0], coords[limit]));
                count++;
            }

        }
        chunks = pieces.toArray(new LineSegment[0]);
    }

    // the number of line segments
    public int numberOfSegments()
    {
        return count;
    }

    // the line segments
    public LineSegment[] segments()
    {
        LineSegment[] result = new LineSegment[chunks.length];
        System.arraycopy(chunks, 0, result, 0, chunks.length);
        return result;
    }

    // the test bench
    public static void main(String[] args)
    {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
