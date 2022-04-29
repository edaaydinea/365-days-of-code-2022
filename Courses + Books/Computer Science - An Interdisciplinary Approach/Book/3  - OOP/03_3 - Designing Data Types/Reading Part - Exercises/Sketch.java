/******************************************************************************
 *  Compilation:  javac Sketch.java
 *  Execution:    java Sketch k d < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/java/33design/genome20.txt
 *                https://introcs.cs.princeton.edu/java/33design/genome50.txt
 *
 *  % java Sketch 2 16 < genome20.txt
 *
 *
 ******************************************************************************/

public class Sketch {
    private final Vector profile;         // unit vector

    public Sketch(String text, int k, int d) {
        int n = text.length();
        double[] freq = new double[d];
        for (int i = 0; i < n-k+1; i++) {
            String kgram = text.substring(i, i+k);
            int hash = kgram.hashCode();
            freq[Math.abs(hash % d)] += 1;
        }
        Vector vector = new Vector(freq);
        profile = vector.direction();
    }

    public double similarTo(Sketch other) {
        return profile.dot(other.profile);
    }

    public String toString() {
        return "" + profile;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        String text = StdIn.readAll();
        Sketch sketch = new Sketch(text, k, d);
        StdOut.println(sketch);
    }
}
