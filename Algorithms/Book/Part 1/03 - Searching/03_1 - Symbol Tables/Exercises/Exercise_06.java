import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_06 {
    private static int countOfWForPut;
    private static int countOfWForGet;
    private static int countOfDForPut;
    private static int countOfDForGet;
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<>();
        while (!StdIn.isEmpty()){
            String word = StdIn.readString();
            if (word.length() < N) continue;
            if (!st.contains(word)) {
                countOfWForPut++;
                countOfDForPut++;
                st.put(word, 1);
            }
            else {
                countOfWForPut++;
                st.put(word, st.get(word) + 1);
            }
        }

        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()){
            if (st.get(word) > st.get(max)){
                countOfDForGet += 2;
                countOfWForGet += 2;
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
        StdOut.println("The number of calls for Put in w: " + countOfWForPut);
        StdOut.println("The number of calls for Get in w: " + countOfWForGet);
        StdOut.println("The number of calls for Put in D: " + countOfDForGet);
        StdOut.println("The number of calls for Put in D: " + countOfDForPut);
    }

}
