/**
 |-------------------------------------------------------------------------------
 | BruteCollinearPoints.java
 |-------------------------------------------------------------------------------
 |
 | Author:       Alwin Tareen
 | Created:      Nov 07, 2021
 | Compilation:  javac-algs4 BruteCollinearPoints.java
 | Execution:    java-algs4 BruteCollinearPoints input8.txt
 |
 | This program determines whether 4 points all lie on the same line segment.
 |
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.ArrayList;

public class BruteCollinearPoints
{
    private int count;
    private final LineSegment[] chunks;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points)
    {
        // check for corner cases
        if (points == null)
            throw new IllegalArgumentException("argument to BCP constructor is null");

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

        // determine whether 4 points lie on the same line segment
        count = 0;
        ArrayList<LineSegment> pieces = new ArrayList<>();
        Point[] coords = new Point[points.length];
        System.arraycopy(points, 0, coords, 0, points.length);
        Arrays.sort(coords);

        for (int i = 0; i < coords.length - 3; i++)
        {
            for (int j = i+1; j < coords.length - 2; j++)
            {
                for (int k = j+1; k < coords.length - 1; k++)
                {
                    for (int l = k+1; l < coords.length; l++)
                    {
                        //Arrays.sort(coords, i, l+1, coords[i].slopeOrder());
                        if (coords[i].slopeTo(coords[j]) == coords[i].slopeTo(coords[k]) && coords[i].slopeTo(coords[k]) == coords[i].slopeTo(coords[l]))
                        {
                            pieces.add(new LineSegment(coords[i], coords[l]));
                            count++;
                        }
                    }
                }
            }
        }
        //System.out.println(pieces);
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
        for (int i = 0; i < chunks.length; i++)
            result[i] = chunks[i];
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}