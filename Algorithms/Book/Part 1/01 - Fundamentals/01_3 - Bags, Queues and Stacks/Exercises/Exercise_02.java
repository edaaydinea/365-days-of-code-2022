import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/*
    Give the output printed by java Stack for th input
    it was - the best - of times - - - it was - the - -
 */
public class Exercise_02 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stringStack.push(item);
            else if (!stringStack.isEmpty())
                StdOut.print(stringStack.pop() + " ");
        }
        StdOut.println("(" + stringStack.size() + " left on stack");
    }
}
