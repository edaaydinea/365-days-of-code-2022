import edu.princeton.cs.algs4.StdOut;

public class Exercise_23 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = collectCoupons(n);
        StdOut.printf(
                """
                        To get all %d coupons (one is rare)
                        You should collect total of %,d coupons.
                        Good Luck!""", n, count);
    }

    private static int collectCoupons(int n) {
        boolean[] isCollected = new boolean[n];
        int count = 0, distinct = 0;
        int rare = (int) (Math.random() * n);  // choose random rare coupon
        while (distinct < n) {
            int r = getCoupon(n, rare);
            count++;

            if (!isCollected[r])  // new coupon to collection
                distinct++;

            isCollected[r] = true;
        }

        return count; // total # of coupons collected
    }

    private static int getCoupon(int n, int rareCoupon) {
        double p = Math.random();
        if (p < 1.0 / (1000 * n)) return rareCoupon;

        if (p < 0.5) return (int) (Math.random() * rareCoupon);                               // [0, rare)
        else return (rareCoupon + 1) + (int) (Math.random() * (n - rareCoupon - 1));  // [rare + 1, n)

    }
}
