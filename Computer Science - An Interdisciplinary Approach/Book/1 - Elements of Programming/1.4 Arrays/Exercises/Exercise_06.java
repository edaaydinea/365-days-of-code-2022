import java.util.Random;

public class Exercise_06 {
    public static void main(String[] args) {
        outputArray(fillInArray(5, 5));
    }

    private static boolean[][] fillInArray(int m, int n) {
        boolean[][] array = new boolean[m][n];
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextBoolean();
            }
        }

        return array;
    }

    private static void outputArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("   ");

                for (int j = 0; j < array.length; j++) {
                    System.out.print(j);
                }

                System.out.println();
            }

            System.out.print((i + 1) + "  ");

            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] ? '*' : ' ');
            }

            System.out.println();
        }
    }
}
