/*
This program takes as an integer command-line argument n and computes the value of the nth harmonic number.
The value is known from mathematical analysis to be about ln(n) + 0.57721 for large n.
Note that ln(1,000,000) + 0.57721 ~ 14.39272.
 */
public class HarmonicNumber {
    public static void main(String[] args) {
        // Compute the nth harmonic number
        int n = Integer.parseInt(args[0]);
        double sum = 0.0;
        for (int i = 0; i <= n; i++) {
            // Add the ith term to the sum
            sum += 1.0 / i;
        }
        System.out.println(sum);
    }
}
