import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class Exercise_14 {
    public static int FourSum(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (BinarySearch.indexOf(a, -a[i] - a[j] - a[k]) > k) {
                        cnt++;
                    }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i - a.length / 10;
        }
        System.out.println(FourSum(a));
    }
}
