import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

public class Exercise_15 {
    public static Queue<String> queue = new Queue<>();

    public static String count_backwards_K(int k) {
        int N = queue.size();
        if (k > N) throw new NoSuchElementException();
        String result;
        for (int i = 0; i < N - k; i++) {
            queue.dequeue();
        }
        result = queue.dequeue();
        return result;
    }

    public static void main(String[] args) {
        System.out.println("输入参数 k :");
        int K = StdIn.readInt();

        System.out.println("输入大于k个字符串：");
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            queue.enqueue(item);
        }
        String result = count_backwards_K(K);
        System.out.println(result);

    }
}
