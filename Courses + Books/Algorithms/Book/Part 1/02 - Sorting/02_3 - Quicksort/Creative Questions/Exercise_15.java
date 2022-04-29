import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;

public class Exercise_15 {
    private final int[] nuts;
    private final int[] bolts;
    private int len;
    Map<Integer, Integer> pairs = new HashMap<>();

    public Exercise_15(int[] bolts, int[] nuts) {
        this.bolts = bolts;
        this.nuts = nuts;
        this.len = nuts.length - 1;
        Match(bolts, nuts);
        findmatch();

    }


    public void Match(int[] a, int[] b) {
        StdRandom.shuffle(a);
        StdRandom.shuffle(b);
        Match(a, b, 0, a.length - 1, a.length - 1);
    }

    public void Match(int[] a, int[] b, int lo, int hi, int len) {

        int j = partition(a, lo, hi, b[len]);
        if (a[j] == b[len]) {
            pairs.put(b[len], a[j]);
        }
        if (len <= 0) return;
        if (b[len - 1] > b[len]) {
            Match(a, b, j + 1, a.length - 1, len - 1);
        }
        else if (b[len - 1] < b[len]) {
            Match(a, b, 0, j - 1, len - 1);
        }


    }

    public void findmatch() {
        for (int i = 0; i < bolts.length; i++) {
            System.out.print(bolts[i]);
            System.out.print("->");
            System.out.println(pairs.containsKey(bolts[i]));
        }

    }


    private int partition(int[] a, int lo, int hi, int pivot) {
        int i = lo, j = hi;
        while (true) {

            while (less(a[i], pivot)) {
                if (i == hi) break;
                i++;
            }


            while (less(pivot, a[j])) {
                if (j == lo) break;
                j--;
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);

        }
        if (a[i] == pivot) {
            return i;
        }
        else if (a[j] == pivot) {
            return j;
        }
        else {
            return j;
        }

    }

    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    private static boolean less(int a, int b) {
        return a < b;
    }


    public static void main(String[] args) {
        int[] Bolt = { 2, 4, 6, 5, 3, 1 };
        int[] Nuts = { 3, 6, 4, 5, 1, 7 };
        Exercise_15 test = new Exercise_15(Bolt, Nuts);


    }
}
