import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

public class Exercise_10 {
    public static String InfixToPostfix(String infix) {
        Stack<Character> opstack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char ch = infix.charAt(i);
            if (ch == ' ' || ch == '(')
                continue;
            else if (Character.isDigit(ch))
                postfix.append(ch);
            else if ("*+/-".contains(String.valueOf(ch)))
                opstack.push(ch);
            else if (ch == ')') {
                postfix.append(opstack.pop());
            }
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        String input = StdIn.readLine();
        System.out.println(input);
        String output = InfixToPostfix(input);
        System.out.println(output);
    }
}
