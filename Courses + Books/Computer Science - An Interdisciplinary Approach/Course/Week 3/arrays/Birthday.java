/*
Write a program Birthday.java that takes two integer command-line arguments n and trials and
performs the following experiment, trials times:

- Choose a birthday for the next person, uniformly at random between 0 and n−1.
- Have that person enter the room.
- If that person shares a birthday with someone else in the room, stop; otherwise repeat.

In each experiment, count the number of people that enter the room.
Print a table that summarizes the results (the count i, the number of times that exactly i people
enter the room, and the fraction of times that i or fewer people enter the room) for each possible
value of i from 1 until the fraction reaches (or exceeds) 50%.
 */
public class Birthday
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] count = new int[n];
        double[] fraction = new double[n];
        fraction[0] = 0;

        for (int t = 0; t < trials; t++)
        {
            boolean[] room = new boolean[n];
            for (int i = 0; i < n; i++)
            {
                int birthday = (int) (Math.random() * (n - 1));
                if (!room[birthday])
                {
                    room[birthday] = true;
                } else
                {
                    count[i]++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++)
        {
            if (i > 0)
            {
                fraction[i] = fraction[i - 1] + ((double) count[i] / (double) trials);
            }
            System.out.println((i + 1) + "\t" + count[i] + "\t" + fraction[i]);
            if (fraction[i] >= 0.5) break;
        }
    }
}
