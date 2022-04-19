import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_01 {
    public static void main(String[] args) {
        ST<String, Double> st = new ST<>();
        while (!StdIn.isEmpty())
            st.put(StdIn.readString(), StdIn.readDouble());

        for (String s : st.keys())
            StdOut.printf("%3s %3s", s, "|");

        StdOut.println();

        for (String s : st.keys())
            StdOut.printf("%1.2f", st.get(s), "|");

        StdOut.println();

    }
}
