public class Exercise_12 {
    public static void main(String[] args) {
        QuickUnionUF qu = new QuickUnionUF(10);
        System.out.printf("    length(0) = %d\n", qu.getLength(0));
        for (int i = 0; i < 3; i++) {
            qu.union(i, i + 1);
            System.out.printf("%d-%d length(0) = %d\n", i, i + 1, qu.getLength(0));
        }
    }

    public static class QuickUnionUF {
        private final int[] id;
        private int count;

        public QuickUnionUF(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
            count = n;
        }

        public int getLength(int p) {
            int length = 1;
            while (p != id[p]) {
                p = id[p];
                length++;
            }
            return length;
        }

        public int find(int p) {
            // Now with path compression
            int root = p;
            while (root != id[root]) {
                root = id[root];
            }
            while (p != root) {
                int prev = p;
                p = id[p];
                id[prev] = root;
            }
            return root;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            id[rootP] = rootQ;
            count--;
        }
    }
}
