import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Coupon.java
 *  Execution:    java Coupon n
 *
 *  % java Coupon 1000 
 *  6522 
 *
 *  % java Coupon 1000 
 *  6481 
 *
 *  % java Coupon 1000000 
 *  12783771
 *
 ******************************************************************************/

public class Coupon {

    // return a random coupon between 0 and n-1
    public static int getCoupon(int n) {
        return (int) (Math.random() * n);
    }

    // return number of cards you collect before obtaining one of each of the n types
    public static int collect(int n) {
        boolean[] isCollected = new boolean[n];  // isCollected[i] = true if card type i already collected
        int count = 0;                           // number of cards collected
        int distinct  = 0;                       // number of distinct card types collected

        // repeat until you've collected all n card types
        while (distinct < n) {
            int value = getCoupon(n);            // pick a random card 
            count++;                             // one more card
            if (!isCollected[value]) {           // discovered a new card type
                distinct++;
                isCollected[value] = true;
            }
        }
        return count;
    }

    // test client
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = collect(n);
        StdOut.println(count);
    }
} 