package pack1;

public class Main {

    public static String[] suitsArray = {"Spades", "Hearts", "Diamonds", "Clubs"};
    public static String[] ranksArray = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static int[][] playerCards = new int[4][13]; //Rows in Order (North, South, East, West)
    public static int[] deck = new int[52];

    public static void main(String[] args) {

        initDeck(); // Initialize the Deck
        shuffleDeck(); // Shuffle the Deck
        dealDeck(); // Deal the Deck to the Players
        dispCards(); // Display Cards
    }

    public static void initDeck() {
        // Initialize cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
    }

    public static void shuffleDeck() {
        // Shuffle the cards
        for (int i = 0; i < deck.length; i++) {
            // Generate an index randomly
            int index = (int)(Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }

    public static void dealDeck() {
        for (int i = 0, k = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++, k++) {
                playerCards[i][j] = deck[k];
            }
        }
    }

    public static void dispCards() {
        for (int each : deck) System.out.println(each);
        for (int[] eachRow : playerCards) for (int eachElement : eachRow) System.out.println(eachElement);
        for (int i = 0; i < 4; i++) {
            String suit = suitsArray[deck[i] / 13];
            String rank = ranksArray[deck[i] % 13];
            System.out.println("Card Number " + deck[i] + ": " + rank + " of " + suit);
        }
    }
}
