public class Exercise_14 {
    public static void main(String[] args) {
        double[][] a = {
                {99.0, 85.0, 98.0},
                {98.0, 57.0, 79.0},
                {92.0, 77.0, 74.0},
                {94.0, 62.0, 81.0},
                {99.0, 94.0, 92.0},
                {80.0, 76.5, 67.0},
                {76.0, 58.5, 90.5},
                {92.0, 66.0, 91.0},
                {97.0, 70.5, 66.5},
                {89.0, 89.5, 81.0}
        };

        // Transposition is possible only for square/rectangle matrices
        for (int c = 0; c < a[0].length; c++) {
            for (int r = 0; r < a.length; r++) {
                System.out.print(a[r][c] + " \t");
            }
            System.out.println();
        }
    }
}
