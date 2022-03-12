import java.io.PrintStream;
import static java.nio.charset.StandardCharsets.UTF_8;

public class DrawCards
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9","10", "J", "Q", "K", "A" };
        String[] suit = { "♣", "♦", "♥", "♠" };
        String[] deck = new String[52];

        for (int i = 0; i < 13; i++)
            for (int j = 0; j < 4; j++)
                deck[i + 13*j] = rank[i] + suit[j];
        for (int i = 0; i < N; i++)
        {
            int r = (int) (Math.random() * 52);
            PrintStream out = new PrintStream(System.out, true, UTF_8);
            System.out.print(deck[r] + " ");
        }
        System.out.println();
    }
}