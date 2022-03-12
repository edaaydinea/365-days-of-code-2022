import java.util.Arrays;

public class ArrayExercise {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(relativelyPrime(3)));
    }

    static boolean[][] relativelyPrime(int n) {
        boolean[][] primeTable = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                primeTable[i][j] = isRelativelyPrime(i + 1, j + 1);
            }
        }
        return primeTable;
    }

    private static boolean isRelativelyPrime(int param1, int param2) {
        if (param1 == 1 || param2 == 1) {
            return false;
        }
        int min = Math.min(param1, param2);
        for (int i = 2; i <= min; i++) {
            if ((param1 % i) == 0 && (param2 % i) == 0) {
                return false;
            }
        }
        return true;
    }
}

