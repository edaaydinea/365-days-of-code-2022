import java.util.Scanner;

public class ExponentialFunction {
    static float exponential(int n, float x)
    {
        float sum = 1;
        for (int i = n-1; i > 0; --i) {
            sum = 1 + x * sum / i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        float x = scanner.nextFloat();

        System.out.println("e^x= " + exponential(n,x));
    }
}
