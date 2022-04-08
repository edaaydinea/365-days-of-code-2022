import java.util.Arrays;
import java.util.Random;

public class Exercise_16 {
    public static void sortGood(Comparable[] a) {
        Arrays.sort(a);
    }
    public static void sortBad(Comparable[] a) {
        Comparable c = a[0];
        for (int i = 0; i < a.length; i++) {
            a[i] = c;
        }
    }
    public static boolean checkGood(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        sortGood(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    public static boolean checkBad(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        sortBad(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Integer[] a = new Integer[100];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
        }
        System.out.println(checkGood(a));
        System.out.println(checkBad(a));
    }
}
