public class Exercise_13 {
    public static void main(String[] args) {
        WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(10);

        // Create size 4 group
        wqu.union(0, 1);
        wqu.union(0, 2);
        wqu.union(0, 3);
        // Create size 2 group
        wqu.union(4, 5);
        // Create size 2 group, make 7 child of 6
        wqu.union(6, 7);
        System.out.printf("length(7) = %d\n", wqu.getLength(7));
        // Create size 4 group, make 6 child of 4
        wqu.union(4, 6);
        System.out.printf("length(7) = %d\n", wqu.getLength(7));
        // Create size 8 group, make 4 child of 0
        wqu.union(0, 4);
        System.out.printf("length(7) = %d\n", wqu.getLength(7));
    }

    public static class WeightedQuickUnionUF {
        private final int[] parent;   // parent[i] = parent of i
        private final int[] size;     // size[i] = number of sites in subtree rooted at i
        private int count;      // number of components

        public WeightedQuickUnionUF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            // Now with path compression
            validate(p);
            int root = p;
            while (root != parent[root]) {
                root = parent[root];
            }
            while (p != root) {
                int next = parent[p];
                parent[p] = root;
                p = next;
            }
            return p;
        }

        public int getLength(int p) {
            int length = 1;
            while (p != parent[p]) {
                p = parent[p];
                length++;
            }
            return length;
        }

        // validate that p is a valid index
        private void validate(int p) {
            int n = parent.length;
            if (p < 0 || p >= n) {
                throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n - 1));
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            // make smaller root point to larger one
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
    }
}
