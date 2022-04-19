import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class KdTree {

    private class Tree2D implements Iterable<Point2D> {
        private Node root;
        private static final int dimension = 2;

        private class Node {
            Node left, right;
            Point2D point;
            int count;

            Node(Point2D p) {
                this.point = p;
                this.count = 1;
            }
        }

        Tree2D() {
        }

        public void add(Point2D p) {
            root = put(root, p, 0);
        }

        private Node put(Node n, Point2D p, int curHeight) {
            if (n == null) return new Node(p);
            if (n.point.equals(p)) return n;

            double comp;
            if (curHeight % dimension == 0)
                // even height compares x
                comp = p.x() - n.point.x();
            else
                // odd height compares y
                comp = p.y() - n.point.y();

            if (comp < 0) n.left = put(n.left, p, curHeight + 1);
            else n.right = put(n.right, p, curHeight + 1);
            n.count = 1 + size(n.left) + size(n.right);
            return n;
        }

        private int size(Node n) {
            if (n == null) return 0;
            else return n.count;
        }

        public int size() {
            return size(root);
        }


        private boolean contains(Point2D p, Node n, int curHeight) {
            if (n == null) return false;
            if (p.equals(n.point)) return true;

            double comp;
            if (curHeight % dimension == 0)
                // even height compares x
                comp = p.x() - n.point.x();
            else
                // odd height compares y
                comp = p.y() - n.point.y();

            if (comp < 0) return contains(p, n.left, curHeight + 1);
            else return contains(p, n.right, curHeight + 1);
        }

        public boolean contains(Point2D p) {
            return contains(p, root, 0);
        }

        @Override
        public Iterator<Point2D> iterator() {
            Queue<Point2D> q = new LinkedList<>();
            inorder(root, q);
            return q.iterator();
        }

        private void inorder(Node n, Queue<Point2D> q) {
            if (n == null) return;
            inorder(n.left, q);
            q.add(n.point);
            inorder(n.right, q);
        }

        private void drawAtHeight(Node n, int curHeight, double minX, double maxX, double minY, double maxY) {
            if (n == null) return;
            if (curHeight % dimension == 0) {
                // even height draw vertical line at x
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(n.point.x(), minY, n.point.x(), maxY);
                drawAtHeight(n.left, curHeight + 1, minX, n.point.x(), minY, maxY);
                drawAtHeight(n.right, curHeight + 1, n.point.x(), maxX, minY, maxY);
            } else {
                // odd height draw horizontal line at y
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.line(minX, n.point.y(), maxX, n.point.y());
                drawAtHeight(n.left, curHeight + 1, minX, maxX, minY, n.point.y());
                drawAtHeight(n.right, curHeight + 1, minX, maxX, n.point.y(), maxY);
            }
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(n.point.x(), n.point.y());
        }

        public void draw() {
            drawAtHeight(root, 0, 0, 1, 0, 1);
        }

        public Iterable<Point2D> range(RectHV rect) {
            Queue<Point2D> result = new LinkedList<>();
            intersect(rect, root, result, 0, 0, 1, 0, 1);
            return result;
        }

        private void intersect(
                RectHV rect, Node n, Queue<Point2D> q, int curHeight,
                double minX, double maxX, double minY, double maxY
        ) {
            if (n == null) return;
            if (rect.contains(n.point)) q.add(n.point);

            RectHV nodeRect = createRectForNode(n, curHeight, minX, maxX, minY, maxY);

            // if intersects axis of point search both nodes
            if (rect.intersects(nodeRect)) {
                if (curHeight % 2 == 0) {
                    intersect(rect, n.left, q, curHeight + 1, minX, n.point.x(), minY, maxY);
                    intersect(rect, n.right, q, curHeight + 1, n.point.x(), maxX, minY, maxY);
                } else {
                    intersect(rect, n.left, q, curHeight + 1, minX, maxX, minY, n.point.y());
                    intersect(rect, n.right, q, curHeight + 1, minX, maxX, n.point.y(), maxY);
                }
                // else just search on one side of node
            } else {
                if (curHeight % 2 == 0) {
                    if (rect.xmax() < n.point.x())
                        intersect(rect, n.left, q, curHeight + 1, minX, n.point.x(), minY, maxY);
                    else
                        intersect(rect, n.right, q, curHeight + 1, n.point.x(), maxX, minY, maxY);
                } else {
                    if (rect.ymax() < n.point.y())
                        intersect(rect, n.left, q, curHeight + 1, minX, maxX, minY, n.point.y());
                    else
                        intersect(rect, n.right, q, curHeight + 1, minX, maxX, n.point.y(), maxY);
                }
            }
        }

        private RectHV createRectForNode(Node n, int curHeight, double minX, double maxX, double minY, double maxY) {
            if (curHeight % dimension == 0) {
                return new RectHV(n.point.x(), minY, n.point.x(), maxY);
            } else {
                return new RectHV(minX, n.point.y(), maxX, n.point.y());
            }
        }

        private Point2D searchNearest(Point2D p, Node n, int curHeight, double minimum) {
            if (n == null) return null;

            double curMin = p.distanceTo(n.point);
            minimum = curMin < minimum ? curMin : minimum;
            double leftMin = 1;
            double rightMin = 1;

            Point2D leftMinPoint = null;
            Point2D rightMinPoint = null;

            if (curHeight % dimension == 0) {
                // minimum distance to axis is the normal line
                double minDistToAxis = p.distanceTo(new Point2D(n.point.x(), p.y()));
                // search left or right
                if (p.x() < n.point.x()) {
                    leftMinPoint = searchNearest(p, n.left, curHeight + 1, minimum);
                    if (leftMinPoint != null) leftMin = leftMinPoint.distanceTo(p);
                    // if min on left is more than the shortest path to axis, check right also
                    if (leftMin > minDistToAxis) rightMinPoint = searchNearest(p, n.right, curHeight + 1, minimum);
                    if (rightMinPoint != null) rightMin = rightMinPoint.distanceTo(p);
                } else {
                    rightMinPoint = searchNearest(p, n.right, curHeight + 1, minimum);
                    if (rightMinPoint != null) rightMin = rightMinPoint.distanceTo(p);

                    if (rightMin > minDistToAxis) leftMinPoint = searchNearest(p, n.left, curHeight + 1, minimum);
                    if (leftMinPoint != null) leftMin = leftMinPoint.distanceTo(p);
                }
            } else {
                // search up or down
                // minimum distance to axis is the normal line
                double minDistToAxis = p.distanceTo(new Point2D(p.x(), n.point.y()));
                // search up or down
                if (p.y() < n.point.y()) {
                    leftMinPoint = searchNearest(p, n.left, curHeight + 1, minimum);
                    if (leftMinPoint != null) leftMin = leftMinPoint.distanceTo(p);
                    // if min on left is more than the shortest path to axis, check right also
                    if (leftMin > minDistToAxis) rightMinPoint = searchNearest(p, n.right, curHeight + 1, minimum);
                    if (rightMinPoint != null) rightMin = rightMinPoint.distanceTo(p);
                } else {
                    rightMinPoint = searchNearest(p, n.right, curHeight + 1, minimum);
                    if (rightMinPoint != null) rightMin = rightMinPoint.distanceTo(p);

                    if (rightMin > minDistToAxis) leftMinPoint = searchNearest(p, n.left, curHeight + 1, minimum);
                    if (leftMinPoint != null) leftMin = leftMinPoint.distanceTo(p);
                }
            }
            if (leftMin < rightMin && leftMin < curMin) return leftMinPoint;
            else if (rightMin < leftMin && rightMin < curMin) return rightMinPoint;
            else return n.point;
        }

        public Point2D nearest(Point2D p) {
            // min to 1, as no distance can be greater than 1
            return searchNearest(p, root, 0, 1);
        }
    }

    private Tree2D tree;

    // construct an empty set of points
    public KdTree() {
        tree = new Tree2D();
    }

    // is the set empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // number of points in the set
    public int size() {
        return tree.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException("point is null");

        tree.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException("point is null");

        return tree.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        tree.draw();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        return tree.range(rect);
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        return tree.nearest(p);
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

    private static final int numOfPoints = 10;

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        Point2D[] testPoints = new Point2D[numOfPoints];

        // random y
        for (int i = 0; i < numOfPoints; i++) {
            testPoints[i] = new Point2D((double) i / (double) numOfPoints, StdRandom.uniform());
        }
        StdRandom.shuffle(testPoints);

        // //linear
        // for (int i =0;i<numOfPoints;i++){
        //     double val = (double) i/ (double) numOfPoints;
        //     testPoints[i] = new Point2D(val , val);
        // }
        // StdRandom.shuffle(testPoints);

        PointSET brute = new PointSET();
        KdTree tree = new KdTree();
        for (Point2D p : testPoints) {
            tree.insert(p);
            brute.insert(p);
        }

        StdDraw.setPenRadius(0.0075);
        tree.draw();
        brute.draw();

        RectHV tRect = new RectHV(0.2, 0.2, 0.8, 0.8);
        StdDraw.setPenColor(StdDraw.CYAN);
        drawRect(tRect);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.setPenRadius(0.025);
        for (Point2D p : tree.range(tRect)) {
            drawPoint(p);
        }


        Point2D tPoint = new Point2D(0.6, 0.2);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        drawPoint(tPoint);
        Point2D nPoint = tree.nearest(tPoint);
        StdDraw.setPenColor(StdDraw.ORANGE);
        drawPoint(nPoint);

        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setPenRadius(0.0075);
        StdDraw.line(tPoint.x(), tPoint.y(), nPoint.x(), nPoint.y());
    }
}