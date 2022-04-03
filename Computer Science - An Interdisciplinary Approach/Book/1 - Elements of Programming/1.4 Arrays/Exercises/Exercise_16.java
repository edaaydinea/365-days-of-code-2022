public class Exercise_16 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[][] a = new boolean[n + 1][n + 1];

        printArray(a);

        for (int i = 1; i <= n / i; i++) { // FIXME
            for (int j = 1; j <= n / j; j++) {
                if (areCoPrimes(i, j)) {
                    for (int k = 1; j * k <= n && i * k <= n; k++) {
                        a[i][j * k] = true;
                        a[j][i * k] = true;
                    }
                }
            }
        }

        System.out.println();

        printArray(a);
    }

    private static void printArray(boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("(" + i + "," + j + ")=>" + a[i][j] + " \t");
            }
            System.out.println();
        }
    }

    /**
     * Euclidean algorithm to find HCF of 2 numbers
     */
    private static boolean areCoPrimes(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }

        return a == 1;
    }
}
