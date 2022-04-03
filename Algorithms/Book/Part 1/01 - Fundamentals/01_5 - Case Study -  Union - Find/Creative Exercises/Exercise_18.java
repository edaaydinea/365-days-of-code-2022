import java.util.Random;

public class Exercise_18 {
    public static void main(String[] args) {
        RandomGrid grid = new RandomGrid();
        RandomGrid.main(10);
    }

    public static class RandomGrid {
        public static void main(int n) {
            RandomGrid grid = new RandomGrid();
            Connection[] cons = grid.generate(n);
            for (Connection con : cons)
                System.out.printf("%d %d\n", con.p, con.q);
        }

        // Generate connections between neighbors in an n x n grid.
        // Indices start at 1.
        private Connection[] generate(int n) {
            Exercise_34.RandomBag<Connection> b = new Exercise_34.RandomBag();
            Random r = new Random();
            int m = n * n;
            for (int i = 1; i <= m; i++) {
                // Try to connect to right neighbor
                if (i % n > 0) {
                    if (r.nextBoolean()) b.add(new Connection(i, i + 1));
                    else b.add(new Connection(i + 1, i));
                }
                // Try to connect to bottom neighbor
                if (m - i >= n) {
                    if (r.nextBoolean()) b.add(new Connection(i, i + n));
                    else b.add(new Connection(i + n, i));
                }
            }
            Connection[] cons = new Connection[b.size()];
            int i = 0;
            for (Connection con : b) {
                cons[i++] = con;
            }
            return cons;
        }

        private static class Connection {
            int p;
            int q;

            public Connection(int p, int q) {
                this.p = p;
                this.q = q;
            }
        }
    }
}
