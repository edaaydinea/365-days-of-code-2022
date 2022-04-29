public class Factors
{
    public static void main(String[] args)
    {
        long n = Long.parseLong(args[0]);
        // need to start at 2 since 0 and 1 are not factors
        for(int i = 2; i < n/i; i++)
        {
            while (n % i == 0)
            {
                System.out.print(i + " ");
                n = n / i;
            }
        }
        if (n > 1) System.out.println(n);
        else       System.out.println();
    }
}
