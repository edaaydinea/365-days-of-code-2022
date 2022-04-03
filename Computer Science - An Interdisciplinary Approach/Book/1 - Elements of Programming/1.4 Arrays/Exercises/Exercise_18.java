public class Exercise_18 {
    public static void main(String[] args) {

        // 1st matrix dimensions
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        // 2nd matrix dimensions
        int p = Integer.parseInt(args[2]);
        int q = Integer.parseInt(args[3]);

        if (n != p)
            throw new IllegalArgumentException("A(m,n) x B(p,q) iff n = q, " + n + " != " + p);

        int[][] a = generateMatrix(m, n);
        int[][] b = generateMatrix(p, q);

        printMatrix(a);
        System.out.println();
        printMatrix(b);
        System.out.println();

        // Matrix multiplication
        int[][] product = new int[m][q];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < q; j++)
                for (int k = 0; k < n; k++) // Dot product of row i and column j
                    product[i][j] += a[i][k] * b[k][j];

        printMatrix(product);
    }

    private static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int ele : row) {
                System.out.print(ele + " \t");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int m, int n) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = (int) (Math.random() * 21) - 10; // [-10, 10]

        return mat;
    }
}
