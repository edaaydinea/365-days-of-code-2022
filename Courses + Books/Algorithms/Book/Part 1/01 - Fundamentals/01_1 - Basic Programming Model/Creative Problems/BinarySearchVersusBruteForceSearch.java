import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class BinarySearchVersusBruteForceSearch {
    public static void main(String[] args) {

        // make white list
        In in1 = new In(args[0]);
        int[] whitelist = in1.readAllInts();
        in1.close();

        // make sorted white list
        int[] whitelist_sorted = new int[whitelist.length];
        System.arraycopy(whitelist, 0, whitelist_sorted, 0, whitelist_sorted.length);
        Arrays.sort(whitelist_sorted);

        // make test list
        In in2 = new In(args[1]);
        int[] test = in2.readAllInts();
        in2.close();

        // calculate time using binary search
        double time_binary = calculateBinaryTime(whitelist_sorted, test);
        StdOut.println("Binary search time: " + time_binary);

        // calculate time using brute-force search
        double time_bruteforce = calculateBruteTime(whitelist, test);
        StdOut.println("Brute-force search time: " + time_bruteforce);

    }

    public static double calculateBinaryTime(int[] w, int[] t) {

        int n = 0;

        Stopwatch watch_binary = new Stopwatch();

        for (int j : t) {
            if (rankBinary(j, w) == -1) {
                n += 1;
            }
        }

        double time_binary = watch_binary.elapsedTime();

        StdOut.println(n + " not in sorted whitelist");

        return time_binary;

    }

    public static double calculateBruteTime(int[] w, int[] t) {

        int n = 0;

        Stopwatch watchBruteforce = new Stopwatch();

        for (int j : t) {
            if (rankBruteforce(j, w) == -1) {
                n += 1;
            }
        }

        double timeBruteforce = watchBruteforce.elapsedTime();

        StdOut.println(n + " not in whitelist");

        return timeBruteforce;

    }

    public static int rankBinary(int key, int[] a) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }

    public static int rankBruteforce(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
