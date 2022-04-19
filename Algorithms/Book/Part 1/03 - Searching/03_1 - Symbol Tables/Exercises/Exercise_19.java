import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_19 {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();
        int n = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()){
            String word = StdIn.readString();
            if (word.length() < n) continue;
            if (!st.contains(word)){
                st.put(word, 1);
            }
            else
                st.put(word, st.get(word) + 1);
        }
        Queue<String> queue = new Queue<>();
        String max = "";
        st.put(max, 0);
        for (String s : st.keys()){
            if (st.get(s) > st.get(max)){
                max = s;
            }
        }
        StdOut.println("Key: " + max + "  " +max.length()+  "  " + st.get(max));
        for (String s : st.keys()){
            if (st.get(s) == st.max().length()){
                StdOut.println(s);
            }
        }
    }
}