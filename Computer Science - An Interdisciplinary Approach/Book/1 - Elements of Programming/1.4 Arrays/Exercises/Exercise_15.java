public class Exercise_15 {
    public static void main(String[] args) {

        // create random n-by-n matrix
        int n = 1 + (int) (Math.random() * 10); // [1, 10]
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = (int) (Math.random() * 21);

        printMatrix(mat);

        System.out.println();

        // In-place Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }
        }

        printMatrix(mat);

    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int ele : row) {
                System.out.print(ele + " \t");
            }
            System.out.println();
        }
    }
}
