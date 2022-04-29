import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class EqualKeys {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] arr = in.readAllInts();
        Arrays.sort(arr);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (indexOf(key, arr) != -1) {
                StdOut.println(key);
            } else {
                StdOut.println("Key value not found : " + key);
            }
            int rankValue = rank(key, arr);
            int countValue = count(key, arr);
            StdOut.println("rankValue:" + rankValue + " countValue:" + countValue);
        }
    }

    static int count(int key, int[] arr) {
        int indexOfRank = rank(key, arr);
        if (indexOfRank != -1) {
            int counter = 1;
            for (int i = indexOfRank + 1; i < arr.length; i++) {
                if (arr[i] == key) {
                    counter++;
                }
            }
            return counter;
        }
        return -1;
    }

    static int rank(int key, int[] arr) {
        int indexOf = indexOf(key, arr);
        if (indexOf != -1) {
            for (int i = indexOf - 1; i >= 0; i--) {
                if (arr[i] == key) {
                    indexOf--;
                }
            }
        }
        return indexOf;
    }

    private static int indexOf(int element, int[] arr) {
        int ho = arr.length;
        int lo = 0;
        while (ho >= lo) {
            int mid = lo + (ho - lo) / 2;
            if (arr[mid] > element) {
                ho = mid - 1;
            } else if (arr[mid] < element) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
