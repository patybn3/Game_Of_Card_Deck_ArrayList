/*
In the first part of this project you will implement a card deck in 2 ways.
Each deck will implement the CardDeckInterface. A class that implements this
interface must accomplish the following:
•	at any time, it can be shuffled
•	the top card can be drawn
•	you can count the number of remaining cards
 */
public interface CardDeckInterface {
    //return the top card on the deck
    public Card draw();

    //shuffle the deck
    public void shuffle();

    //the number of cards remaining in the deck
    public int size();
}
