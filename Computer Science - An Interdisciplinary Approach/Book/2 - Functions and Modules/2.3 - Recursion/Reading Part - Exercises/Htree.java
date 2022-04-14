import edu.princeton.cs.algs4.StdDraw;

public class Htree {
    public static void draw(int n, double x, double y, double size) {
        // draw an h-tree centred at x,y
        // of depth n and given size

        if (n == 0) return;

        // compute x- and y-coordinates of the 4 half-size H-trees
        double x0 = x - size / 2;
        double x1 = x + size / 2;
        double y0 = y - size / 2;
        double y1 = y + size / 2;

        StdDraw.line(x0, y, x1, y);
        StdDraw.line(x0, y0, x0, y1);
        StdDraw.line(x1, y0, x1, y1);

        // recursively draw 4 half-size H-trees of order n-1
        draw(n - 1, x0, y0, size / 2);    // lower left  H-tree
        draw(n - 1, x0, y1, size / 2);    // upper left  H-tree
        draw(n - 1, x1, y0, size / 2);    // lower right H-tree
        draw(n - 1, x1, y1, size / 2);    // upper right H-tree
    }

    // reads an integer command-line argument n and plots an order n H-tree
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double x = 0.5, y = 0.5;   // center of H-tree
        double size = 0.5;         // side length of H-tree
        draw(n, x, y, size);
    }
}
