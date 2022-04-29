public class Exercise_20 {
    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]); // # of hands

        // positive # of hands and
        // no more than 10 hands with standard card deck (52 cards)
        if (n < 0 || n > 10)
            return;

        String[] deck = getDeck();
        shuffle(deck);

        // draw five cards for n hands
        for (int h = 0; h < n; h++) {
            String[] hand = drawHand(deck);

            System.out.printf("=== Hand #%d ===\n", h + 1);
            print(hand);

            if (h + 1 < n) System.out.println();
        }

        // show deck after hands draw
        System.out.println("\n=== Cards left in deck ===");
        print(deck);
    }

    private static String[] drawHand(String[] deck) {
        final int FIVE_CARDS = 5;
        String[] hand = new String[FIVE_CARDS];

        // find first card that hasn't been drawn yet
        int i = 0;
        while (deck[i].equals("")) i++;

        // draw five cards from deck
        for (int j = 0; j < FIVE_CARDS; j++, i++) {
            hand[j] = deck[i];
            deck[i] = ""; // remove card from deck
        }

        return hand;
    }

    // permute deck - side effect
    private static void shuffle(String[] deck) {
        int len = deck.length;
        for (int i = 0; i < len; i++) {
            int rnd = i + (int) (Math.random() * (len - i));

            String tmp = deck[i];
            deck[i] = deck[rnd];
            deck[rnd] = tmp;
        }
    }

    private static void print(String[] deck) {
        for (String card : deck) {
            if (!card.equals("")) // don't print ""
                System.out.println(card);
        }
    }

    private static String[] getDeck() {
        final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = new String[SUITS.length * RANKS.length];
        for (int i = 0; i < SUITS.length; i++)
            for (int j = 0; j < RANKS.length; j++)
                deck[RANKS.length * i + j] = RANKS[j] + " of " + SUITS[i];

        return deck;
    }

}
