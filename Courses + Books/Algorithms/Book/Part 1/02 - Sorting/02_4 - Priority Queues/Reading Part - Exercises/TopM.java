import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

import java.util.Stack;

public class TopM {
    public static void main(String[] args) {
        // print the top M lines in the input stream.
        int m = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<>(m + 1);

        while (StdIn.hasNextLine()){
            // Create an entry from the next line and put on the PQ.
            String line = StdIn.readLine();
            Transaction transaction = new Transaction(line);
            pq.insert(transaction);

            // remove minimum if m+1 entries on the PQ
            if(pq.size() > m)
                pq.delMin();
        }

        // top m entries are on the PQ

        // print entries on PQ in reverse order
        Stack <Transaction> stack = new Stack<>();
        for(Transaction transaction : pq)
            stack.push(transaction);
        for(Transaction transaction : stack)
            StdOut.println(transaction);
    }
}
