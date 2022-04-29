public class Exercise_10 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        final int MAX_POKER_HANDS = 10;
        n = n < 1 ? 1 : Math.min(n, MAX_POKER_HANDS);

        String[] deck = createDeck();

        shuffle(deck);
        dealPokerHands(deck, n);
    }

    private static void dealPokerHands(String[] deck, int n) {
        final int POKER_HAND = 5;
        for (int i = 0; n > 0; i += POKER_HAND, n--) {
            System.out.println(
                    deck[i] + " " + deck[i + 1] + " "
                            + deck[i + 2] + " " + deck[i + 3] + " " + deck[i + 4]
            );
        }
    }

    private static void printDeck(String[] deck) {
        final int PER_ROW = 13;
        for (int i = 0; i < deck.length; i++) {
            System.out.println(deck[i] + "\t");
            if ((i + 1) % PER_ROW == 0)
                System.out.println();
        }
    }

    private static void shuffle(String[] deck) {
        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));

            String t = deck[i];
            deck[i] = deck[r];
            deck[r] = t;
        }
    }

    private static String[] createDeck() {
        String[] SUITS = {"♠", "♥", "♦", "♣"};
        String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] deck = new String[SUITS.length * RANKS.length];

        for (int i = 0; i < SUITS.length; i++)
            for (int j = 0; j < RANKS.length; j++)
                deck[RANKS.length * i + j] = RANKS[j] + SUITS[i];

        return deck;
    }
}
