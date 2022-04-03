import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Random;

public class Exercise_17 {
    public static void main(String[] args) {
        for (int n = 100; n < 100000; n += n) {
            int count = 0;
            for (int i = 0; i < 10; i++)
                count += ErdosRenyi.count(n);
            System.out.printf("%5d %8d %8d\n", n, count / 10, (int) (n * Math.log(n) / Math.log(Math.E) / 2));
        }
    }

    public static class ErdosRenyi {
        private ErdosRenyi() {
        }

        public static int count(int n) {
            int result = 0;
            WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
            Random r = new Random();
            while (uf.count() > 1) {
                result++;
                int a = r.nextInt(n);
                int b = r.nextInt(n);
                if (uf.connected(a, b)) continue;
                uf.union(a, b);
            }
            return result;
        }
    }
}
