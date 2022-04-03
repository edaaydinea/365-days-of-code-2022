import java.util.Arrays;

public class Exercise_17 {
    public static void main(String[] args) {
        int t = Integer.parseInt(args[0]); // # of tests
        int s = Integer.parseInt(args[0]); // # of students

        int[][] testsMarks = new int[s][t];

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < t; j++) {
                testsMarks[i][j] = 55 + (int) (Math.random() * 46); // [55, 100]
            }
        }

        double[] weights = {0.25, 0.25, 0.50};
        System.out.println(Arrays.toString(weights));

        for (int r = 0; r < testsMarks.length; r++) {
            System.out.print(Arrays.toString(testsMarks[r]) + " \tweighted_average = ");
            double w = 0.0;
            for (int c = 0; c < testsMarks[r].length; c++) {
                w += weights[c] * testsMarks[r][c];
            }
            System.out.println(w);
        }

    }
}

