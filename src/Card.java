//You will need to create a Card class; you can create your own or use the one in the README file:
public class Card
{
    // I read this source https://fpl.cs.depaul.edu/jriely/thinkapjava/thinkapjava.array2.html
    public static final String[] SUITS = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
    public static final String[] FACES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING", "ACE"};

    private int suit;
    private int face;
    // I change the parameters from string to int
    //I think ints will facilitate the loop
    public Card(int suit, int face)
    {
        this.suit = suit;
        this.face = face;
    }

    public int getSuit()
    {
        return suit;
    }
    //I fail to understand why sets are needed, but here they are as required by the interface
    public void setSuit(int suit)
    {
        this.suit = suit;
    }

    public int getFace()
    {
        return face;
    }

    public void setFace(int face)
    {
        this.face = face;
    }

    public String toString()
    {
        //the value is passed to the array so we can print the actual value stored in the index and not the index itself
        return "Card = " + FACES[face] + " of " + SUITS[suit];
    }
}

