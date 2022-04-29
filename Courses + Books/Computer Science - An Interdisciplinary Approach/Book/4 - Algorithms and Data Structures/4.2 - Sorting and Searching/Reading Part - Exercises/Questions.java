/******************************************************************************
 *  Compilation:  javac Questions.java
 *  Execution:    java Questions k
 *  Dependencies  StdIn.java
 *
 *  This code uses binary search to play the game of twenty questions.
 *  It takes an integer command-line argument k, asks you to think of a
 *  number between 0 and n-1, where n = 2^k, and always guesses the answer
 *  with n questions.
 *
 *  %  java Questions 7
 *  Think of an integer between 0 and 127
 *  Greater than or equal to 64?  true
 *  Greater than or equal to 96?  false
 *  Greater than or equal to 80?  false
 *  Greater than or equal to 72?  true
 *  Greater than or equal to 76?  true
 *  Greater than or equal to 78?  false
 *  Greater than or equal to 77?  true
 *  Your number is 77
 *
 ******************************************************************************/

public class Questions {

    // invariant: answer is in [lo, hi)
    public static int search(int lo, int hi) {
        if ((hi - lo) == 1) return lo;
        int mid = lo + (hi - lo) / 2;
        StdOut.printf("Grearther than or equal to %d?  ", mid);
        if (StdIn.readBoolean()) return search(mid, hi);
        else                     return search(lo, mid);
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int n = (int) Math.pow(2, k);
        StdOut.printf("Think of an integer between %d and %d\n", 0, n-1);
        int secret = search(0, n);
        StdOut.printf("Your number is %d\n", secret);
    }

}
