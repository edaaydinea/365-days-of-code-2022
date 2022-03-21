public class ISBN {

    public static void main(String[] args) {

        // read in one command-line argument
        int n = Integer.parseInt(args[0]);

        // compute the weighted sum of the digits, from right to left
        int sum = 0;
        for (int i = 2; i <= 10; i++) {
            int digit = n % 10;                // rightmost digit
            sum = sum + i * digit;
            n = n / 10;
        }

        // print out check digit, use X for 10
        System.out.print("The full ISBN number is " + args[0]);
        if      (sum % 11 == 1) System.out.println("X");
        else if (sum % 11 == 0) System.out.println("0");
        else                    System.out.println(11 - (sum % 11));
    }
}

