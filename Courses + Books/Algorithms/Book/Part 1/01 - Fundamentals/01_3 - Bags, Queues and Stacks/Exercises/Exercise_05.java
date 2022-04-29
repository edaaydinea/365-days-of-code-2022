import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Exercise_05 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        Stack<Integer> stack = new Stack<>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) {
            System.out.print(d);
        }
        System.out.println();
    }
}
