/**
 * Write a program RandomWalkers.java that takes two integer command-line arguments
 * r and trials. In each of trials independent experiments, simulate a random walk
 * until the random walker is at Manhattan distance r from the starting point.
 * Print the average number of steps.
 *
 * ~/Desktop/loops> java RandomWalkers 5 1000000
 * average number of steps = 14.98188
 *
 * ~/Desktop/loops> java RandomWalkers 5 1000000
 * average number of steps = 14.93918
 *
 * ~/Desktop/loops> java RandomWalkers 10 100000
 * average number of steps = 59.37386
 */

public class RandomWalkers
{
    public static void main (String[] args)
    {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int steps = 0;

        for (int n = 0; n <trials; n++)
        {
            int i = 0;
            int j = 0;

            while(Math.abs(i) + Math.abs(j) != r)
            {
                steps ++;
                double randomStep = Math.random();
                if (randomStep < 0.25) j--;
                else if (randomStep < 0.5) i--;
                else if (randomStep < 0.75) j++;
                else i++;
            }
        }
        double average = (double) steps / (double) trials;
        System.out.println("Average number of steps= " + average);
    }
}
