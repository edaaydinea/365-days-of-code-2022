import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private final int[] id; // access to component id
    private int count; // number of components

    public UF(int N) {
        // Initialize component id array
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        // Solve dynamic connectivity problem on StdIn
        int n = StdIn.readInt();                    // Read number of sites.
        UF uf = new UF(n);                          // Initialize N components
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();                // Read pair to connect.
            if (uf.connected(p, q)) continue; // Ignore if connected
            uf.union(p, q);                         // Combine components.
            StdOut.println(p + " " + q);            // and print connection.
        }
        StdOut.println(uf.count() + " components");
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // Put p and q into the same component.
        int pID = find(p);
        int qID = find(q);

        // Nothing to do if p and q are already in the same component.
        if (pID == qID) return;

        // Change values from id[p] to id[q].
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }
        count--;
    }


}
