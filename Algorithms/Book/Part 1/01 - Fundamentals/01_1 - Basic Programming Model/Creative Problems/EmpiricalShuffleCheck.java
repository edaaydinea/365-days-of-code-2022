import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class EmpiricalShuffleCheck {
    public static void main(String[] args) {
        StdOut.print("Enter the number of shuffle: ");
        int N = StdIn.readInt();
        StdOut.print("Enter the array size: ");
        int M = StdIn.readInt();

        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = i;
        }

        int[][] position_dist = new int[M][M];

        StdRandom.setSeed(123456);
        for (int i = 0; i < N; i++) {
            shuffle(arr);
            calculate_position_dist(arr, position_dist);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                StdOut.printf("%-5d", position_dist[i][j]);
            }
            StdOut.print("\n");
        }
    }

    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void calculate_position_dist(int[] a, int[][] d) {
        for (int i = 0; i < a.length; i++) {
            d[a[i]][i] += 1;
        }
    }
}
