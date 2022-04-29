import java.util.Arrays;

public class Exercise_19 {
    public static void main(String[] args) {
        int[] a = new int[5];
        final int m = 7;
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (Math.random() * m); // [0, m-1]

        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(histogram(a, m)));
    }

    public static int[] histogram(int[] a, int m) {
        int[] b = new int[m];
        for (int value : a)
            b[value]++;

        return b;
    }

}
