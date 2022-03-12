/*
Write a program ThueMorse.java that takes an integer command-line argument n and
prints an n-by-n pattern like the ones below. Include two space characters between each + and - character.
 */
public class ThueMorse
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int[] seq = new int[n];
        seq[0] = 0;

        for(int i = 1; i < n; i++)
        {
            if (i % 2 == 0)
                seq[i] = seq[i / 2];
            else
                seq[i] = 1 - seq[i - 1];
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (seq[i] == seq[j])
                    System.out.print("+ ");
                else
                    System.out.print("- ");
            }
            System.out.println();
        }
    }
}
