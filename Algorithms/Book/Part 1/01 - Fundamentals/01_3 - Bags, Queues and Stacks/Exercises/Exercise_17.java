import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

public class Exercise_17 {
    public static Transaction[] readTransaction() {
        Queue<Transaction> queue = new Queue<>();
        while (!StdIn.isEmpty()) queue.enqueue(new Transaction(StdIn.readLine()));

        int N = queue.size();
        Transaction[] transactions = new Transaction[N];
        for (int i = 0; i < N; i++) {
            transactions[i] = queue.dequeue();
        }
        return transactions;
    }

    public static void main(String[] args) {
        Transaction[] transactions = readTransaction();
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
