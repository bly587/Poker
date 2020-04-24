// Deck of cards
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Deck{
  // Each element in the array will be a string of length 3: a number and char (for suit)
  private LinkedList<Card> cards;

  /**
  * Empty Constructor that creates an ArrayList of cards
  */
  public Deck(){
    this.cards = new LinkedList<Card>();
    // Iterates through every suit
    for (int j = 0; j < 4; j++){
      // declare variable
      String suit = "";
      // Iterates through every numeric value
      for (int i = 2; i < 15; i++){
        // declare variable
        String cardValue = "";
        // If statements that determine when to add face cards and also determines suit
        if (j == 0){
          suit = "♥";
        }
        else if (j == 1){
          suit = "♣";
        }
        else if (j == 2){
          suit = "♦";
        }
        else if (j == 3){
          suit = "♠";
        }

        if (i == 11){
          cardValue = "J";
        }
        else if (i == 12){
          cardValue = "Q";
        }
        else if (i == 13){
          cardValue = "K";
        }
        else if (i == 14){
          cardValue = "A";
        }
        else{
          cardValue = Integer.toString(i);
        }

        cards.add(new Card(cardValue, suit, i));
      }
    }
  }

  public Card findCard(String suit, String value){
    int value_int = 0;
    int suit_int = 0;
    //included boolean to make sure both loops ran
    boolean suit_found = false;
    //determine start of index value in list
    while(suit_found == false){
      if (suit.equals("h")){
        suit_int = 0;
        suit_found = true;
      }
      else if (suit.equals("c")){
        suit_int = 13;
        suit_found = true;
      }
      else if (suit.equals("d")){
        suit_int = 26;
        suit_found = true;
      }
      else if (suit.equals("s")){
        suit_int = 39;
        suit_found = true;
      }
    }
    //find value of card
    if (value == "J"){
      value_int = 11;
    }
    else if (value == "Q"){
      value_int = 12;
    }
    else if (value == "K"){
      value_int = 13;
    }
    else if (value == "A"){
      value_int = 14;
    }
    else{
      value_int = Integer.parseInt(value);
    }

    //13 = 2 of clubs
    // 0-12 hearts
    // 13-25 clubs
    // 26-38 diamonds
    // 39-51 spades
    //subtracting 2 because that bring us to the first index since
    //we are adding the first value as 2 because that's the first card
    int real_index = suit_int + value_int - 2;
    // System.out.println(real_index);
    return cards.remove(real_index);
  }
  public Card findCard1(Card c1){
    if(cards.remove(c1) == false)
    {
      System.out.println("No card found in deck");
      return null;
    }
    else
    {
      return c1;
    }
  }
  /**
  * Chooses a card at random and removes and returns the card
  * @return Card
  */
  public Card deal(){
    int chooseCard = (int) (Math.random() * cards.size());
    return cards.remove(chooseCard);
  }

  public static int toValue(String value){
    int value_int = 0;
    if (value == "J"){
      value_int = 11;
    }
    else if (value == "Q"){
      value_int = 12;
    }
    else if (value == "K"){
      value_int = 13;
    }
    else if (value == "A"){
      value_int = 14;
    }
    else{
      value_int = Integer.parseInt(value);
    }
    return value_int;
  }
  //calculate what our hand is worth
  public static void isTwoPair(Card[] player_cards, Card[] river){
    //got it
    boolean gotIt = false;
    String threePair = "0";
    String pairValue = "";
    boolean threePairFound = false;
    //length -3 since we are only checking the first 3 cards
    for(int i = 0; i < river.length - 2; ++i)
    {
      for(int j = 0; j < player_cards.length; ++j)
      {
        if(player_cards[j].getValue().equals(river[i].getValue()))
        {
          if(threePair.equals(player_cards[j].getValue()))
          {
            System.out.println("Found");
            threePairFound = true;
            pairValue = player_cards[j].getValue();
          }
          else
          {
            pairValue = player_cards[j].getValue();
            gotIt = true;
            threePair = player_cards[j].getValue();
            //let them know which cards they have pairs with?
          }
        }
      }
    }
    if(threePairFound == true)
    {
      System.out.println("Got a three of a kind");
      System.out.println("Three of a kind is of " +pairValue+ "'s");
    }
    else if(gotIt == true)
    {
      System.out.println("Got a pair");
      System.out.println("Pair is of " +pairValue+ "'s");
    }
    //dont got it
    else if(gotIt == false)
    {
      System.out.println("No pair found.");
    }
    else
    {
      System.out.println("Literally not possible");
    }
    //close need a card
    //It's a freaking pair of course you're close
  }

  /**
  * A void method that puts cards into the deck randomly before the start of the game
  * @param Deck (2 of them) that each represent the 2 piles of 26 cards each player starts with
  */

  public static void main(String[] args) {
    // create an object of Scanner
    Scanner input = new Scanner(System.in);

    Deck d1 = new Deck();
    System.out.println(d1.cards.size());
    Card c1 = d1.cards.getLast();
    System.out.println(d1.cards.size());
    c1.printCard();
    // System.out.println("Enter a suit: ");
    // String suit = input.nextLine();
    // System.out.println("Enter a value(2-10, J, Q, K, A): ");
    // String value = input.nextLine();
    // Card c2 = d1.findCard(suit, value);
    // c2.printCard();

    System.out.println("Enter your cards");
    System.out.println("1) Enter suit: ");
    String suit1 = input.next();
    System.out.println("1) Enter value: ");
    String value1 = input.next();
    Card pc1 = new Card(value1, suit1, toValue(value1));
    System.out.println("2) Enter suit: ");
    String suit2 = input.next();
    System.out.println("2) Enter value: ");
    String value2 = input.next();
    Card pc2 = new Card(value2, suit2, toValue(value2));

    //Player's cards
    Card[] player_cards = {pc1, pc2};
    //enter river
    Card[] river = new Card[5];
    //Tell user that they are entering river
    System.out.println("Now Enter the River");
    //get first 3 cards
    for(int i =0; i < 3; ++i)
    {
      System.out.println(+i+1+ ") Enter suit: ");
      String rsuit = input.next();
      System.out.println(+i+1+ ")Enter value: ");
      String rvalue = input.next();
      river[i] = new Card(rvalue, rsuit, toValue(rvalue));
    }
    System.out.println("Player cards");
    player_cards[0].printCard();
    player_cards[1].printCard();
    System.out.println("River cards");
    river[0].printCard();
    river[1].printCard();
    river[2].printCard();
    isTwoPair(player_cards, river);
    // player_cards[0].printCard();
    // player_cards[1].printCard();

  }
}
