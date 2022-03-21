import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Exercise_09 {
    private static String FillLeftParentheses(String string) {
        Stack<String> opstack = new Stack<>();
        Stack<String> datastack = new Stack<>();

        int N = string.length();

        for (int i = 0; i < N; i++) {
            char ch = string.charAt(i);
            if (Character.isSpaceChar(ch))
                continue;
            if (Character.isDigit(ch))
                datastack.push(Character.toString(ch));
            else if ("*+-/".contains(Character.toString(ch)))
                opstack.push(Character.toString(ch));
            else if (Character.toString(ch).equals(")")) {
                String data2 = datastack.pop();
                String data1 = datastack.pop();
                String op = opstack.pop();
                String expression = "(" + data1 + op + data2 + ")";
                datastack.push(expression);
            }
        }
        return datastack.pop();
    }

    public static void main(String[] args) {
        String input = StdIn.readLine();
        StdOut.println(input);
        String output = FillLeftParentheses(input);
        StdOut.println(output);
    }


}
