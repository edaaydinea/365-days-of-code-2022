import edu.princeton.cs.algs4.StdOut;

public class Exercise_14 {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            long rnd = 1_000_000_000 + (long) (Math.random() * 9_000_000_000L); // [1,000,000,000, 9,999,999,999]
            StdOut.printf("#: %d => %d %d\n", rnd, rnd, checksum(rnd));
        }
    }

    public static long checksum(long n) {
        // check if number is strictly 10 digits long
        if (!isValidLength(n)) return -1;

        long checksum = 0;
        final int NUM_LENGTH = 10;

        for (int i = 0; i < NUM_LENGTH; i++) {
            long digit = n % 10;
            if (i % 2 == 0) {
                long newDigit = 2 * digit;
                if (newDigit > 9)
                    // newDigit [10, 19] slice and sum single digits
                    digit = newDigit / 10 + newDigit % 10;
            }

            checksum += digit;
            n /= 10; // remove unit digits
        }

        return checksum % 10 == 0 ? checksum : -1;

    }

    private static boolean isValidLength(long n) {
        return n >= 1_000_000_000 && n <= 9_999_999_999L;
    }
}
