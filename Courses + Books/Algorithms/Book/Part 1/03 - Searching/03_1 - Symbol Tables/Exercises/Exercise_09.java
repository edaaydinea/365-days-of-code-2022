import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_09 {
    public static void main(String[] args) {
        int number = 0;
        ST<String, Integer> st = new ST<>();
        int N = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()){
            String word = StdIn.readString();
            if (word.length() < N) continue;
            if (!st.contains(word)){
                st.put(word, 1);
                if (StdIn.isEmpty()){
                    StdOut.println("Last word inserted: " + word);
                    break;
                }
            }
            else {
                st.put(word, st.get(word) + 1);
                if (StdIn.isEmpty()){
                    StdOut.println("Last word inserted: " + word);
                    break;
                }
            }
        }
        for (String s : st.keys()){
            number += st.get(s);
        }
        StdOut.println("The number of words: " + (number - 1));
    }
}
