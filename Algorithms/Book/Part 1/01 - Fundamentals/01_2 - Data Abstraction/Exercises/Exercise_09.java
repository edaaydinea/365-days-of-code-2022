import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

/*
Instrument BinarySearch to use a Counter to count the total number
of keys examined during all searches and then print the total after all searches are complete.
Hint: Create a Counter in main() and pass it as an arguments to rank()
 */
public class Exercise_09 {
    public static int rank(int key, int[] a, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                counter.increment();
                hi = mid - 1;
            } else if (key > a[mid]) {
                counter.increment();
                lo = mid + 1;
            } else {
                counter.increment();
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Counter counter = new Counter("SearchTime");
        if (rank(2, a, counter) > 0)
            StdOut.println(counter);
        else
            StdOut.println("No data!");
    }

}
