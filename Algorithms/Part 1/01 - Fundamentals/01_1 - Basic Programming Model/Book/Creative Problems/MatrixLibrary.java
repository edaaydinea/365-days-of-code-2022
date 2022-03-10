import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

interface Matrix {
    double dot(double[] x, double[] y);             //vector dot product

    double[][] mult(double[][] a, double[][] b);    // matrix - matrix product

    double[][] transpose(double[][] a);             // transpose

    double[] mult(double[][] a, double[] x);        // matrix - vector product

    double[] mult(double[] y, double[][] a);        // vector - matrix product
}

public class MatrixLibrary implements Matrix {
    public static void main(String[] args) {
        Matrix matrix = new MatrixLibrary();

        //vector dot product
        double[] x = {1, 2, -5};
        double[] y = {4, -2, -1};
        StdOut.println(matrix.dot(x, y));

        // matrix - matrix product
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}};
        for (double[] row : matrix.mult(a, b)) {
            StdOut.println(Arrays.toString(row));
        }

        // transpose
        double[][] aT = matrix.transpose(a);
        for (double[] row : aT) {
            StdOut.println(Arrays.toString(row));
        }

        // matrix - vector product
        StdOut.println(Arrays.toString(matrix.mult(a, x)));

        // vector - matrix product
        StdOut.println(Arrays.toString(matrix.mult(y, a)));

    }

    @Override
    public double dot(double[] x, double[] y) {
        if (x.length != y.length)
            throw new IllegalArgumentException("arguments array size must be equal for dot product");
        double sum = 0;
        for (int i = 0; i < x.length; i++)
            sum += (x[i] * y[i]);

        return sum;
    }

    @Override
    public double[][] mult(double[][] a, double[][] b) {
        if (a.length != b[0].length)
            throw new IllegalArgumentException("first matrix row number is not equal to second matrix column number");
        double[][] c = new double[a.length][b[0].length];
        double[][] bT = transpose(b);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i][j] = dot(a[i], bT[j]);
            }
        }
        return c;
    }

    @Override
    public double[][] transpose(double[][] a) {
        double[][] aT = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                aT[j][i] = a[i][j];
            }
        }
        return aT;
    }

    @Override
    public double[] mult(double[][] a, double[] x) {
        if (a[0].length != x.length)
            throw new IllegalArgumentException("matrix column number is not equal to vector column number");
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            double acc = 0;
            for (int j = 0; j < a[0].length; j++) {
                acc = acc + (a[i][j] * x[j]);
            }
            result[i] = acc;
        }
        return result;
    }

    @Override
    public double[] mult(double[] y, double[][] a) {
        return mult(a, y);
    }
}
