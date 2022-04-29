import edu.princeton.cs.algs4.StdOut;

import static java.util.Arrays.sort;

public class Exercise_16 {

    public static int[] best(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        best(a, 0, n -1);
        return a;
    }

    private static void best(int[] a, int low, int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        best(a, low, mid - 1);
        best(a, mid + 1, high);
        exch(a, low, mid);
    }

    private static void exch(int[] a, int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }

    public static void main(String[] args) {
        int[] a = Exercise_16.best(10);
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        sort(a);
        for (int j = 0; j < 10; j++){
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

}
