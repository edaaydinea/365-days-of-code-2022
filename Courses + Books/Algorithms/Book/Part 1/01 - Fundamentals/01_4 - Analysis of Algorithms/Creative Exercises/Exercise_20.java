import java.util.Arrays;
import java.util.Random;

public class Exercise_20 {
    public static int indexOfBitonic(int[] a, int key) {
        // Find mid
        int lo = 0;
        int hi = a.length - 1;
        int midc = lo + (hi - lo) / 2;
        while (hi >= lo) {
            if (midc == 0) break;
            if (midc == a.length - 1) break;
            if (a[midc] > a[midc - 1] && a[midc] > a[midc + 1]) break;
            if (a[midc] > a[midc + 1]) hi = midc - 1;
            else lo = midc + 1;
            midc = lo + (hi - lo) / 2;
        }
        // Search left
        lo = 0;
        hi = midc;
        int mid = lo + (hi - lo) / 2;
        while (hi >= lo) {
            if (a[mid] == key) return mid;
            if (a[mid] > key) hi = mid - 1;
            else lo = mid + 1;
            mid = lo + (hi - lo) / 2;
        }
        // Search right
        lo = midc;
        hi = a.length - 1;
        mid = lo + (hi - lo) / 2;
        while (hi >= lo) {
            if (a[mid] == key) return mid;
            if (a[mid] > key) hi = mid - 1;
            else lo = mid + 1;
            mid = (lo + hi) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 100;
        int[] a = new int[n];
        double mid = Math.ceil(Math.random() * n);
        int value = 0;
        for (int i = 0; i < n; i++) {
            if (i <= mid) value += Math.ceil(Math.random() * 10);
            else value -= Math.ceil(Math.random() * 10);
            a[i] = value;
        }
        // Large key
        System.out.printf("%5d: %d\n", 10 * n, indexOfBitonic(a, 10 * n));
        // Small key
        System.out.printf("%5d: %d\n", -10 * n, indexOfBitonic(a, -10 * n));
        // Random keys
        System.out.println(Arrays.toString(a));
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int key = r.nextInt(n);
            System.out.printf("%3d: %3d\n", key, indexOfBitonic(a, key));
        }
    }
}
