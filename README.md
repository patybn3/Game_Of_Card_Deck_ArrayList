<h2>CIS 252 Project 1 – Deck of Cards (ARRAYLIST)</h2>

<h4>Student: Patricia Antlitz - NECC Fall 2022 <br> Computer Science II</h4>
<h5>Project 1 - Deck of Cards</h5>

This is the ArrayList version of this Project.<br>
Array and LinkedStack versions are on separate files.

<h5>Objectives:</h5>

Student should be able to:

•	Use an ArrayList<br>
•	Implement a Java interface<br>
•	Implement and utilize a stack data structure<br>

<h5>Introduction</h5>

This project has multiple parts.

Part 1 – The Card Deck

In the first part of this project you will implement a card deck in 2 ways. Each deck will implement the `CardDeckInterface`. 
A class that implements this interface must accomplish the following:

•	at any time, it can be shuffled<br>
•	the top card can be drawn<br>
•	you can count the number of remaining cards<br>

The CardDeckInterface follows:

```java
    public interface CardDeckInterface {
    //return the top card on the deck   
    public Card draw();

    //shuffle the deck
    public void shuffle();

    //the number of cards remaining in the deck   
    public int size();
}
```

You will need to create a Card class; you can create your own or use the one that follows:

```java
    public class Card { 
    
    //variables for the faces and suits would go here

    //constructor, this.something is coming from the "above" variables
    public Card(String suit, int face){
        this.suit = suit;
        this.face = face;
    }
    //methods from the interface
    public String getSuit(){
        return suit;
    }

    public void setSuit(String suit){
        this.suit = suit;
    }

    public int getFace(){
        return face;
    }

    public void setFace(int face){
        this.face = face;
    }

    public String toString(){
        return "Card{" + "suit=" + suit + ", face=" + face + '}';
    }
}

```

Using the interface and the Card class, create a class called CardDeckArrayList that implement a CardDeckInterface using an array of Cards.

Test your work using the main class that follows (assuming you used the given card class).

`CardDeckTester.java` = `CardDeckArrayList_PatriciaAntlitz.java`

```java
    EXAMPLE GIVEN BY THE ASSIGMENT INSTRUCTIONS:

//this class was not used
//instead, the main file is called CardDeck_PatriciaAntlitz.java
//it only calls one method from CardDeckArrayList, not CardDeckInterface
public class CardDeckTester {
    public static void main(String[] args) {
        //using the interface as the type for the reference varaible
        CardDeckInterface deck = new CardDeckArrayList();

        Card player1Card, player2Card;

        System.out.println("There are " + deck.size() + " cards in the deck");
        System.out.println("Deck is being shuffled");
        deck.shuffle();

        System.out.println("Player 1 draws a card");
        player1Card = deck.draw();
        System.out.println("Player 1 drew the " + player1Card);
        System.out.println("There are " + deck.size() + " cards in the deck");


        System.out.println("Player 2 draws a card");
        player2Card = deck.draw();
        System.out.println("Player 2 drew the " + player2Card);
        System.out.println("There are " + deck.size() + " cards in the deck");
    }
}
```

<h4>Specs:</h4>

File `CardDeckArrayList.java`:

<h5>variables used:</h5>
```java
    protected Card[] cardArray;
    protected int topIndex = -1;
    private final int MAXNUM = 52;
    private int playerOneCount = 0;
    private int playerTwoCount = 0;
```

This is a simpler version of the final version of this game (LinkedStack).

-   it uses an array created from the `Card.java` class. Creating an array from the Card class will allow the program to use the methods present there, the values of the `FACES` and `SUITS` lists (arrays).
-   variable `topIndex` sets top card index. `topIndex` is initiated with the value of -1, which is increased by the first method called, which uses loops to insert the cards
-   'MAXNUM' the array size, that cannot be changed. A card deck contains 52 cards, 4 SUITS, `CLUBS, HEARTS, DIAMONDS, SPADES`, and 13 FACES `A - KING`. In other words, there are 4 rows of 13 cards = 52 cards.
-   `playerOneCount` and `playerTwoCount` are variables that will hold the accumulated count of winning rounds for each player.

The methods are:
```java
    public CardDeckArrayList();         //constructor, created the array object and calls the method that inserts the cards into the stack

    public void insertIntoDeck();   // this method will use 2 loops (inner loops) to create the 4 rows of suits, 
                                    // and the 13 cards for the faces. It will use the Card.java class to insert the elements
    //The following 3 methods are from the interface class
    @Override
    public Card draw();             //returns the top card, as long as the list is not empty (topIndex is greater or equal to 0)
       
    @Override
    public void shuffle()           //uses a loop to shuffle the cards and select a random index to use as a card next
       
    @Override
    public int size()               //this method can give the updated size of the list
       
    public void playCards()         //this is the method that plays the game. It will calls the other methods and use 
                                    //a while loop to have 6 rounds.
```

<h5>How its played:</h5>

This game is automatically generated by the applications. No user intake is used.

There are 2 players and 6 rounds. Each player draws one card per round. The cards are compared. 6 rounds were given to allow ties.

<h5>Hierarchy:</h5>

SUITS = The lowest suit is CLUBS, followed by DIAMONDS, HEARTS and SPADES. SPADES being the highest. Getting Spades would mean an automatic point, unless if the other player also gets one.

FACES = 2, 3, 4, 5, 6, 7, 8, 9, 10, JACK, QUEEN, KING and ACE. ACE being the highest.

<h5>Comparison:</h5>

It will compare the `SUITS` of each card first. If they are equal to each other, it will compare the value of the `FACES`.<br>
If the `FACES` are also equal, the round is a tie, and both players get a point. I not, the player with the highest FACE is the winner of that round (Ex. `JACK` is greater than `9`, etc.).

If the `SUITS` are NOT equal, it will check if the SUIT value of `PLAYER 1` is greater than the SUI` of player 2 (Ex.: `SPADES` are higher than `DIAMOND`)<br>
If so, player 1 is automatically the winner of the round, and gets a point.

Else, if `PLAYER 2` has a higher SUIT, then player 2 wins the round and gets a point.

Last, the method will compare which player has a higher count of points to pick a winner, or a tie.

`playTheGame()` from `CardDeckArrayList.java` is the only method called in the main method. This method is the one calling all other methods that haven't been called until this point, `draw()`, `shuffle()`, `size()`, and the values from `Card.java`

<hr>
<h5>Problems:</h5>

I had problems using the Card.java file to initiate the array. I knew right away that was going to be necessary in order to use the elements and methods from the Card.java class. Similiar to the LLNode class, correct?

I had to change the layout of the strings, for the faces and the suits.<br>
The class given (Card.java), had separate string variables for each suit, and numbers for the faces. I dont understand how that would work with this game. So I thought two arrays would make the most sense. They were originally a string, and an int array, but I wanted to have the name of the cards for the faces too, not only the numbers (JACK, not 11, for example).<br>

Creating the loop and inner loop for the faces, and the suits took me a while too, and some research was necessary.<br>
Long story short the problem was that the loop wouldn't allow me to enter a index number into the Card constructor as a parameter, because the parameter for suit was a String.<br>
So, I changed the parameter of the Card constructor to ints.

draw() was not difficult to code. Like shuffle() it uses a second array to store the information. I am particularly not crazy about temporary arrays, so I wonder if there is a better solution to those.

I had problems with the game logic, it seems pretty straight forward, but I was getting some errors while testing. I was getting the incorrect output.
The problem was, I was comparing both the suits and the faces, when I should compare the suits first, and if they were different, check which one was higher, etc.

In the future I would like to give double points for ACE of SPADES

<hr>

<h5>Technologies</hr>
- JAVA 15.0.1


<hr>

<h3>To run:</h3>
<hr>

IDE:<br>
Build the project and run the CardDeckArrayList_PatriciaAntlitz.java file

CLI:<br>
* Navigate to the correct directory ....../CardDeckArrayList_PatriciaAntlitz/src <br>
* Run on terminal:
    * javac CardDeckArrayList_PatriciaAntlitz.java => compile
    * java CardDeckArrayList_PatriciaAntlitz.java => run

by [Patricia Antlitz - GitHub](https://github.com/patybn3)