import java.util.Arrays;
import java.util.Random;

public class Exercise_04 {

    public static void main(String[] args) {
        int n = 30;
        String[] a = new String[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = String.valueOf(r.nextInt(10));
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(dedup(a)));
    }

    private static String[] dedup(String[] a) {
        if (a.length < 2)
            return a;
        Arrays.sort(a);
        int i = 1;
        int j = 1;
        while (j < a.length - 1) {
            if (a[i].equals(a[i - 1])) {
                a[i] = a[++j];
            } else {
                a[++i] = a[++j];
            }
        }
        String[] b = new String[i];
        System.arraycopy(a, 0, b, 0, i);
        return b;
    }
}
