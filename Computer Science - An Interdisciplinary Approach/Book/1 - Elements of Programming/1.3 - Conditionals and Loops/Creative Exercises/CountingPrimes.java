import java.io.IOException;
import java.util.Scanner;

public class CountingPrimes {
    static boolean isPrime(int n){
        if (n<=1)
            return false;

        for(int i = 2; i < n; i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static void printPrime(int n){
        for (int i = 2; i <=n; i++){
            if (isPrime(i))
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPrime(n);
    }
}
