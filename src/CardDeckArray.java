/*
Using the interface and the Card class, create a class called CardDeckArray that implement a
CardDeckInterface using an array of Cards.
 */
public class CardDeckArray implements CardDeckInterface
{
    protected Card[] cardArray;
    protected int topIndex = -1;
    //There are 52 cards in a deck
    private final int MAXNUM = 52;
    //collects points to find a winner
    private int playerOneCount = 0;
    private int playerTwoCount = 0;

    public CardDeckArray()
    {
        cardArray = new Card[MAXNUM];
        //using the interface as the type for the reference variable
        insertIntoDeck();
    }

    public void insertIntoDeck()
    {
        int i = 0;
        //A-King, there are 13 cards each suit
        while( i < 13 )
        {
            //suits, hearts, diamond, spade and clubs = 4
            for(int j = 0; j < 4; j++)
            {
                topIndex++;
                //calls the constructor from Card.java, each element is passed to the arrays
                cardArray[topIndex] = new Card(j, i);
            }
            i++;
        }
    }
    //draws to the top card in the deck
    @Override
    public Card draw()
    {
        //if there are elements in the deck
        if(topIndex >= 0)
        {
            Card holder = cardArray[topIndex];
            topIndex--;
            return holder;
        }
        return null;
    }

    @Override
    public void shuffle()
    {
        //we are looping through the cards in the deck
        for (int i = 0; i < topIndex + 1; i++)
        {
            //we get a random number
            int randomNum = (int)(Math.random() * i);
            //we get the card and replaced with the random number
            Card holder = cardArray[randomNum];
            cardArray[randomNum] = cardArray[i];
            cardArray[i] = holder;
        }
    }

    @Override
    public int size()
    {
        return topIndex +1;
    }

    //this method will start a game of 6 rounds, each player will draw their cards, randomly
    //the cards will be compared to each other, face and suit, and a winner will be picked.
    public void playCards()
    {
        //create two players
        Card player1Card, player2Card;
        int i = 0;
        
        System.out.println("There are "+ size() + " cards in the deck");
        //6 rounds, even number to allow ties
        while(i < 6)
        {
            System.out.println("Deck is being shuffled\n");
            shuffle();
            //player 1 gets a card
            player1Card = draw();
            System.out.print("Player 1 drew the " + player1Card);
            System.out.println(" - " + size() + " cards left in the deck");
            //player 2 gets a card
            player2Card =  draw();
            System.out.print("Player 2 drew the " + player2Card);
            System.out.println(" - " + size() + " cards left in the deck\n");

            // order suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
            //comparison
            if(player1Card.getSuit() == player2Card.getSuit()) //when the suits of each player are equal, ex. HEARTS $ HEARTS
            {
                //if the face (number) is also equal
                if(player1Card.getFace() == player2Card.getFace())
                {
                    System.out.println("Its a tie!! \n- Player 1 with " + player1Card);
                    System.out.println("- Player 2 with " + player2Card + "\n");
                    //both players get points
                    playerOneCount++;
                    playerTwoCount++;
                }
                else if(player1Card.getFace() > player2Card.getFace()) //if the value of player 1 is greater, Player 1 is the winner
                {
                    System.out.println("Round Winner = PLayer 1 with " + player1Card + "\n");
                    playerOneCount++;
                }
                else
                {   //if player 2 is greater, player 2 is the winner
                    System.out.println("Round Winner = Player 2 with " + player2Card + "\n");
                    playerTwoCount++;
                }

            }
            else if (player1Card.getSuit() > player2Card.getSuit()) //when the value of player 1 suit is greater than player 2
            {
                //player 1 is the winner
                System.out.println("Round Winner = PLayer 1 with " + player1Card + "\n");
                playerOneCount++;
            }
            else
            {
                //if not greater (player 2 is greater), then player two is the winner
                System.out.println("Round Winner = Player 2 with " + player2Card +  "\n");
                playerTwoCount++;
            }
            //loops 6 times
            i++;
        }

        //counting points
        if(playerOneCount == playerTwoCount) //points are equal, its a tir
        {
            System.out.println("Player 1 points: " + playerOneCount + " vs. Player 2 points: " + playerTwoCount);
            System.out.println("\nWe have a tie!!!");
        }
        else if(playerOneCount > playerTwoCount) //player 1 is the winner
        {
            System.out.println("Player 1 points: " + playerOneCount + " vs. Player 2 points: " + playerTwoCount);
            System.out.println("\nWINNER = Player 1");
        }
        else //player 2 is the winner
        {
            System.out.println("Player 1 points: " + playerOneCount + " vs. Player 2 points: " + playerTwoCount);
            System.out.println("\nWINNER = Player 2");
        }
    }
}
