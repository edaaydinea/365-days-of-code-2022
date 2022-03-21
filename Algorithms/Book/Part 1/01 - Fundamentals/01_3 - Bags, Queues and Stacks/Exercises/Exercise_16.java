import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class Exercise_16 {
    public static Date[] readDates() {
        Queue<Date> queue = new Queue<>();
        while (!StdIn.isEmpty()) queue.enqueue(new Date(StdIn.readString()));

        int N = queue.size();
        Date[] dates = new Date[N];
        for (int i = 0; i < N; i++) {
            dates[i] = queue.dequeue();
        }
        return dates;
    }

    public static void main(String[] args) {
        Date[] dates = readDates();
        for (Date date : dates) {
            System.out.println(date);
        }
    }
}
