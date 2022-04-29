public class Exercise_21 {
    public static void main(String[] args) {
        double[][] a = {{1, 2, 3}, {4, 5, 6}};   // 2x3
        double[][] b = {{2, 1}, {1, 2}, {3, 5}}; // 3x2

        print(a);
        System.out.println();
        print(b);
        System.out.println();
        print(multiply(a, b));

    }

    private static void print(double[][] a) {
        // case where multiplication was not possible to avoid NullPointerException
        if (a == null) return;

        for (double[] doubles : a) {
            for (int j = 0; j < doubles.length; j++) {
                System.out.print(doubles[j]);
                if (j + 1 < doubles.length) System.out.print(" \t");
            }
            System.out.println();
        }

    }

    // two matrix a(m,n) and b(p,q)
    // n x b is valid only if n = p and product matrix is c(m, q)
    public static double[][] multiply(double[][] a, double[][] b) {

        // multiplication is not possible
        if (a[0].length != b.length) return null;

        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[i].length; j++)
                for (int k = 0; k < b.length; k++)
                    c[i][j] += a[i][k] * b[k][j];

        return c;
    }
}
