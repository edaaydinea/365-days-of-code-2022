import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_17 {
    public static void main(String[] args) {
        String[] a = {"abc", "my name", "what is this", "cs1 is great"};
        StdOut.println(Arrays.toString(reverse(a)));

        StdOut.println(Arrays.toString(a));
        reverseInPlace(a);
        StdOut.println(Arrays.toString(a));
    }

    public static String[] reverse(String[] a) {
        String[] result = new String[a.length];
        for (int i = 0; i < a.length; i++)
            result[i] = reverseString(a[i]);

        return result;
    }

    private static String reverseString(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            reversed.append(s.charAt(i)); // use StringBuilder to optimize space

        return reversed.toString();
    }

    // reversing the order of the strings in the argument array.
    public static void reverseInPlace(String[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            exchange(a, i, a.length - 1 - i);
        }
    }

    private static void exchange(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
