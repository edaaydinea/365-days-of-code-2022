import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class Exercise_11 {
    static class Pair implements Comparable<Pair> {
        int key;
        int val;

        Pair(int k, int v) {
            key = k;
            val = v;
        }

        public int compareTo(Pair that) {
            return this.key - that.key;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        int n = 20;
        Pair[] p = new Pair[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(0, i);
        }
        Insertion.sort(p);
        System.out.printf("%12s: %s\n", "Insertion", Arrays.toString(p));

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(0, i);
        }
        Selection.sort(p);
        System.out.printf("%12s: %s\n", "Selection", Arrays.toString(p));

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(0, i);
        }
        Shell.sort(p);
        System.out.printf("%12s: %s\n", "Shell", Arrays.toString(p));

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(0, i);
        }
        Merge.sort(p);
        System.out.printf("%12s: %s\n", "Merge", Arrays.toString(p));

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(0, i);
        }
        Quick.sort(p);
        System.out.printf("%12s: %s\n", "Quick", Arrays.toString(p));

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(0, i);
        }
        Heap.sort(p);
        System.out.printf("%12s: %s\n", "Heap", Arrays.toString(p));
    }
}
