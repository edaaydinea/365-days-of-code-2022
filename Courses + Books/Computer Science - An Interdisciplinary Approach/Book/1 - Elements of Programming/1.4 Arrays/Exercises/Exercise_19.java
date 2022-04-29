import java.util.Arrays;

public class Exercise_19 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        boolean[][] a = generateMatrix(n);
        boolean[][] b = generateMatrix(n);

        printMatrix(a);
        System.out.println();
        printMatrix(b);
        System.out.println();

        boolean[][] logicalOrMul = or(a, b, n);
        printMatrix(logicalOrMul);
        System.out.println();

        boolean[][] logicalAndMal = and(a, b, n);
        printMatrix(logicalAndMal);
        System.out.println();
    }

    private static boolean[][] and(boolean[][] a, boolean[][] b, int n) {
        boolean[][] mat = new boolean[n][n];

        for (boolean[] row : mat)
            Arrays.fill(row, true);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    if (!a[i][k] || !b[k][j]) {
                        mat[i][j] = false;
                        break;
                    }

        return mat;
    }

    private static boolean[][] or(boolean[][] a, boolean[][] b, int n) {
        boolean[][] mat = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    if (a[i][k] || b[k][j]) {
                        mat[i][j] = true;
                        break;
                    }

        return mat;
    }

    private static boolean[][] generateMatrix(int n) {
        boolean[][] mat = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = Math.random() < 0.5;

        return mat;
    }

    private static void printMatrix(boolean[][] a) {
        for (boolean[] row : a) {
            for (boolean ele : row) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
    }
}
