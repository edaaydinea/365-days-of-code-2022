public class Exercise_13 {
    public static void main(String[] args) {

        int n = 5;
        int[][] a = create2dArray(n, n);
        printArray(a);

        System.out.println();

        int[][] b = new int[n][];
        copyArray(a, b);
        printArray(b);

        System.out.println("*".repeat(20));


        int m = 3;
        a = create2dArray(n, m);
        printArray(a);

        System.out.println();

        b = new int[n][];
        copyArray(a, b);
        printArray(a);

        System.out.println("*".repeat(20));


        a = createRagged2dArray(n);
        printArray(a);
        b = new int[a.length][];

        System.out.println();

        copyArray(a, b);
        printArray(a);

    }

    private static int[][] createRagged2dArray(int rows) {
        int[][] arr = new int[rows][];
        final int MAX_COLS = 11;

        for (int i = 0; i < rows; i++) {
            int cols = (int) (Math.random() * MAX_COLS);

            arr[i] = new int[cols];
            for (int j = 0; j < cols; j++) {
                arr[i][j] = 1 + (int) (Math.random() * 21); // [1, 21]
            }
        }

        return arr;
    }

    private static void copyArray(int[][] src, int[][] dest) {
        for (int i = 0; i < src.length; i++) {
            int columns = src[i].length;
            dest[i] = new int[columns];

            for (int j = 0; j < columns; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }

    private static int[][] create2dArray(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = (int) (Math.random() * 21);

        return arr;
    }

    private static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int ele : row) {
                System.out.print(ele + " \t");
            }
            System.out.println();
        }
    }
}
