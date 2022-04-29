/*
Write a program DiscreteDistribution.java that takes an integer command-line argument m, followed by a
sequence of positive integer command-line arguments a1, a2, .... an and prints m random indices
(separated by whitespace), choosing each index i with probability proportional to ai.
*/

public class DiscreteDistribution
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int cum_sum = 0;
        int[] s = new int[args.length + 1];

        for (int i = 1; i < args.length; i++)
        {
            cum_sum += Integer.parseInt(args[i]);
        }

        s[0] = 0;

        for (int i = 1; i < args.length; i++)
        {
            s[i] = Integer.parseInt(args[i]) + s[i - 1];
        }

        s[args.length] = s[args.length - 1] + 1;
        for (int i = 0; i < m; i++)
        {
            double random = cum_sum * Math.random();
            int randi = (int) random;

            for (int j = 0; j < args.length; j++)
            {
                if (randi >= s[j] && randi < s[j + 1]) {
                    System.out.print(j + 1 + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
}