import java.util.ArrayDeque;
import java.util.Arrays;

public class Exercise_02 {
    private static String[] compountWords(String[] a) {
        Arrays.sort(a);
        String prev = a[0];
        ArrayDeque<String> q = new ArrayDeque<>();
        for (String value : a) {
            if (value.length() > prev.length() && value.startsWith(prev))
                q.add(value);
            prev = value;
        }
        String[] words = new String[q.size()];
        int i = 0;
        for (String s : q)
            words[i++] = s;

        return words;
    }

    public static void main(String[] args) {
        String[] s = {"as", "df", "asdf", "qw", "q", "w", "asdfqw"};
        System.out.println(Arrays.toString(compountWords(s)));
    }
}
