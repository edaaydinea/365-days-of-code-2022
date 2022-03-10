import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomMatches {
    public static void main(String[] args) {

        int T = Integer.parseInt(args[0]);
        int[] sizes = {100, 1000, 10000, 100000};

        for (int size : sizes) {
            int totalMatchedNumber = calculateTotalMatchedNumber(T, size);
            int averageMatchedNumber = totalMatchedNumber / T;

            StdOut.println("T: " + T + " size: " + size + " avg: " + averageMatchedNumber + "\n");
        }

    }

    public static int[] makeArr(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(100000, 1000000);
        }
        return a;
    }

    public static int calculateTotalMatchedNumber(int T, int size) {

        int sum = 0;

        for (int i = 0; i < T; i++) {
            int[] a1 = makeArr(size);
            int[] a2 = makeArr(size);
            int x = calculateTwoArrayMatchedNumber(a1, a2);
            sum += x;
        }

        StdOut.println("T: " + T + " size: " + size + " sum: " + sum);

        return sum;

    }

    public static int calculateTwoArrayMatchedNumber(int[] a1, int[] a2) {
        int sum = 0;
        Arrays.sort(a2);

        for (int key : a1) {
            if (rank(key, a2) != -1) {
                sum += 1;
            }
        }

        return sum;
    }

    public static int rank(int key, int[] whitelist) {

        if (key < whitelist[0] || key > whitelist[whitelist.length - 1]) {
            return -1;
        }

        int low = 0;
        int high = whitelist.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < whitelist[mid]) {
                high = mid - 1;
            } else if (key > whitelist[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }
}
