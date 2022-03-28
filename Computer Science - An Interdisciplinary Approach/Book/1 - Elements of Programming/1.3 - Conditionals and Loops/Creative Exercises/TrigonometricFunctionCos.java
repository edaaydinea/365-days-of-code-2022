import java.util.Scanner;

public class TrigonometricFunctionCos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number to find out Cos Series: ");
        double x = s.nextInt();
        x = x % (2 * Math.PI);
        double n, sum = 1;
        System.out.println("Enter the limit: ");
        n = s.nextInt();
        n = n * 2 - 2;
        int count = 1;
        for (double i = 2; i <= n; i = i + 2) {
            if (count % 2 != 0)
                sum = sum - (power(x, i) / factorial(i));
            else
                sum = sum + (power(x, i) / factorial(i));
            count++;
        }
        System.out.println("Cos(" + x + ") = " + sum);

        s.close();
    }

    private static double factorial(double i) {
        double fact = 1;
        while (i > 0) {
            fact = fact * i;
            i--;
        }
        return fact;
    }

    private static double power(double x, double i) {
        double pow = 1;
        while (i > 0) {
            pow = pow * x;
            i--;
        }
        return pow;
    }
}
