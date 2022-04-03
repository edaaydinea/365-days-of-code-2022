import edu.princeton.cs.algs4.In;

import java.util.Objects;

public class Exercise_07 {
    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        In in = new In(Objects.requireNonNull(cl.getResource("data/mediumUF.txt")).getFile());
        int n = in.readInt();
        QuickFindUF qf = new QuickFindUF(n);
        QuickUnionUF qu = new QuickUnionUF(n);
        System.out.printf("%12s%12s\n", "QuickFind", "QuickUnion");
        int errors = 0;
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            boolean cqf = false;
            boolean cqu = false;
            if (!qf.connected(p, q)) {
                qf.union(p, q);
                System.out.printf("%6d %4d ", p, q);
                cqf = true;
            }
            if (!qu.connected(p, q)) {
                qu.union(p, q);
                System.out.printf("%5d %4d", p, q);
                cqu = true;
            }
            if (cqf && cqu) System.out.println();
            else if (cqf || cqu) errors++;
        }
        System.out.printf("%d discrepancies\n", errors);
    }

    public static class QuickUnionUF {
        private final int[] id;

        public QuickUnionUF(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            p = find(p);
            q = find(q);
            if (p == q) return;
            id[q] = p;
        }
    }

    public static class QuickFindUF {
        int[] id;
        int count;

        public QuickFindUF(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
            count = n;
        }

        public int find(int p) {
            return id[p];
        }

        public boolean connected(int p, int q) {
            return id[p] == id[q];
        }

        public void union(int p, int q) {
            int idp = id[p];
            int idq = id[q];
            if (idp == idq) return;
            for (int i = 0; i < id.length; i++) {
                if (id[i] == idp) id[i] = idq;
            }
            count--;
        }
    }
}
