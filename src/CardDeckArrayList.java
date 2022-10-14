/*
Using the interface and the Card class, create a class called CardDeckArray that implement a
CardDeckInterface using an array of Cards.
 */
import java.util.ArrayList;
import java.util.Collections;

public class CardDeckArrayList implements CardDeckInterface
{
    protected ArrayList<Card> cardArray;
    private int playerOneCount = 0;
    private int playerTwoCount = 0;

    public CardDeckArrayList()
    {
        cardArray = new ArrayList<>();
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
                //calls the constructor from Card.java, each element is passed to the arrays
                cardArray.add(new Card(j, i));
            }
            i++;
        }
    }
    //draws to the top card in the deck
    @Override
    public Card draw()
    {
        //if there are elements in the deck
        if(cardArray.size() > 0)
        {
            Card holder = cardArray.get(cardArray.size() - 1);
            cardArray.remove(holder);
            return holder;
        }
        return null;
    }

    @Override
    public void shuffle()
    {
        //https://www.geeksforgeeks.org/shuffle-or-randomize-a-list-in-java/
        Collections.shuffle(cardArray);
    }

    @Override
    public int size()
    {
        return cardArray.size();
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
