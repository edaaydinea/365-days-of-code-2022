import edu.princeton.cs.algs4.Stack;

public class Exercise_11 {
    public static int EvaluatePostfix(String postfix) {
        Stack<Integer> datastack = new Stack<>();
        int N = postfix.length();
        for (int i = 0; i < N; i++) {
            char ch = postfix.charAt(i);

            if (ch == '+') {
                datastack.push(datastack.pop() + datastack.pop());
            } else if (ch == '-') {
                int data1 = datastack.pop();
                datastack.push(datastack.pop() - data1);
            } else if (ch == '*') {
                datastack.push(datastack.pop() * datastack.pop());
            } else if (ch == '/') {
                int data1 = datastack.pop();
                datastack.push(datastack.pop() - data1);
            } else if (Character.isDigit(ch)) datastack.push(Character.getNumericValue(ch));

        }
        return datastack.pop();
    }

    public static void main(String[] args) {
        String input = "12+34-56-**";
        int result = EvaluatePostfix(input);
        System.out.println(result);

    }
}
