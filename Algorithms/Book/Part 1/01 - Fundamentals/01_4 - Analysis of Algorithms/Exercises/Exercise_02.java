import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.math.BigInteger;

public class Exercise_02 {

    // Bruce force implementation taken from text
    public static int count(int[] a) {
        // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    BigInteger sum = BigInteger.valueOf(0);
                    sum = sum.add(BigInteger.valueOf(a[i]));
                    sum = sum.add(BigInteger.valueOf(a[j]));
                    sum = sum.add(BigInteger.valueOf(a[k]));
                    if (sum.equals(BigInteger.valueOf(0))) {
                        StdOut.printf("%d %d %d\n", a[i], a[j], a[k]);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String file = "8Kints.txt";
        int[] a = new In(file).readAllInts();
        StdOut.println(count(a));

    }
}
