/**
 * A Java programmer begins walking aimlessly.
 * At each time step, she takes one step in a random direction
 * (either north, east, south, or west), each with probability 25%.
 * She stops once she is at Manhattan distance r from the starting point.
 * How many steps will the random walker take?
 * This process is known as a two-dimensional random walk.
 *
 * Write a program RandomWalker.java that takes an integer command-line argument
 * r and simulates the motion of a random walk until the random walker is at
 * Manhattan distance r from the starting point.
 *
 * Print the coordinates at each step of the walk
 * (including the starting and ending points), treating the starting point as (0, 0).
 * Also, print the total number of steps taken.
 */
public class RandomWalker
{
    public static void main (String[] args)
    {
        // take an integer
        int r = Integer.parseInt(args[0]);
        int steps = 0;

        int i = 0;
        int j = 0;

        while (Math.abs(i) + Math.abs(j) != r)
        {
            System.out.println("(" + i + ", " + j + ")");
            steps++;
            double randomStep = Math.random();
            if (randomStep < 0.25) j--;
            else if (randomStep < 0.5) i--;
            else if (randomStep < 0.75) j++;
            else i++;
        }
        System.out.println("(" + i + ", " + j + ")");
        System.out.println("steps = " + steps);
    }
}
