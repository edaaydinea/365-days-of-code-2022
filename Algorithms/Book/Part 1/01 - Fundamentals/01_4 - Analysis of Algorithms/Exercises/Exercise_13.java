import edu.princeton.cs.algs4.Date;

import java.util.Comparator;

public class Exercise_13 {
    public static void main(String[] args) {
        new Accumulator();
        new Transaction();
        new FixedCapacityStackOfStrings();
        new Point2D();
        new Interval1D();
        new Interval2D();
    }

    // For reference only
    public static class Accumulator {
        private double m;
        private double s;
        private int N;
    }

    public static class Transaction {
        private String who;
        private Date when;
        private double amount;
    }

    public static class FixedCapacityStackOfStrings {
        private String[] a;  // holds the items
        private int N;       // number of items in stack
    }

    public static class Point2D {
        public Comparator<Point2D> X_ORDER;
        public Comparator<Point2D> Y_ORDER;
        public Comparator<Point2D> R_ORDER;
        private double x;    // x coordinate
        private double y;    // y coordinate
    }

    public static class Double {
        public static final double POSITIVE_INFINITY = 1.0 / 0.0;
        public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
        public static final double NaN = 0.0d / 0.0;
        public static final double MAX_VALUE = 0x1.fffffffffffffP+1023; // 1.7976931348623157e+308
        public static final double MIN_NORMAL = 0x1.0p-1022; // 2.2250738585072014E-308
        public static final double MIN_VALUE = 0x0.0000000000001P-1022; // 4.9e-324
        public static final int MAX_EXPONENT = 1023;
        public static final int MIN_EXPONENT = -1022;
        public static final int SIZE = 64;
        public static final int BYTES = SIZE / Byte.SIZE;
    }

    public static class Interval1D {
        public Comparator<Interval1D> MIN_ENDPOINT_ORDER;
        public Comparator<Interval1D> MAX_ENDPOINT_ORDER;
        public Comparator<Interval1D> LENGTH_ORDER;
        private double min;
        private double max;
    }

    public static class Interval2D {
        private Interval1D x;
        private Interval1D y;
    }
}
