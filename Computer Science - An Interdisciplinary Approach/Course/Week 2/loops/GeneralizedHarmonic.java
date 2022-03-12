/***
 * Generalized Harmonic Numbers:
 * Write a program GenerelaizedHarmonics.java that takes two integer command-line arguments n and r and
 * used a for loop to compute the n^th generalized harmonic number of order r, which is defined by the following formula:
 *
 * H(n,r) = 1 / 1^r + 1 / 2^r + ⋯ + 1 / n^r.
 *
 * ~/Desktop/loops> java GeneralizedHarmonic 1 1
 * 1.0
 *
 * ~/Desktop/loops> java GeneralizedHarmonic 2 1
 * 1.5
 *
 * ~/Desktop/loops> java GeneralizedHarmonic 3 1
 * 1.8333333333333333
 *
 * ~/Desktop/loops> java GeneralizedHarmonic 1 2
 * 1.0
 *
 * ~/Desktop/loops> java GeneralizedHarmonic 2 2
 * 1.25
 *
 * ~/Desktop/loops> java GeneralizedHarmonic 3 2
 * 1.3611111111111112
 */

public class GeneralizedHarmonic
{
    public static void main(String[] args)
    {
        // takes two integer
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);

        // create the double variable to calculate harmonics (H)
        double h = 0;

        // compute the n^th generalized harmonic number (for loop)
        for (int i = 1; i <= n; i++)
        {
            double pow = Math.pow(i, r);
            h += 1 / pow;
        }

        // print the harmonic
        System.out.println(h);
    }
}
