import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;

import java.util.Arrays;
import java.util.Objects;

public class Exercise_08 {

    private static class Pair implements Comparable<Pair> {
        int count;
        String item;

        Pair(int n, String s) {
            count = n;
            item = s;
        }

        public int compareTo(Pair other) {
            return this.count - other.count;
        }
    }

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        args = new String[]{Objects.requireNonNull(classLoader.getResource("algs4-data/tinyTale.txt")).getFile()};
        In in = new In(args[0]);

        String[] s = in.readAllStrings();
        Arrays.sort(s);
        MaxPQ<Pair> q = new MaxPQ<>();
        for (int i = 0, count = 1; i < s.length; i++) {
            if (i == s.length - 1) {
                q.insert(new Pair(count, s[i]));
            } else if (s[i].equals(s[i + 1])) {
                count++;
            } else {
                q.insert(new Pair(count, s[i]));
                count = 1;
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.delMax();
            System.out.printf("%3d %s\n", p.count, p.item);
        }
    }

}
