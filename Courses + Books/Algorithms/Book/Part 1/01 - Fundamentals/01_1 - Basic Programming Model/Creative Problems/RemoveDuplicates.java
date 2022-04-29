import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        Integer[] noDuplicateWhitelist = removeDuplicates(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(noDuplicateWhitelist, key) == -1) {
                StdOut.println(key);
            }
        }
    }

    private static int rank(Integer[] whitelist, int key) {
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

    private static Integer[] removeDuplicates(int[] whitelist) {
        Set<Integer> set = new TreeSet<>();
        Arrays.stream(whitelist).forEach(set::add);
        Integer[] noDuplicateWhitelist = set.toArray(Integer[]::new);
        return noDuplicateWhitelist;
    }
}
