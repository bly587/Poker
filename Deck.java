// Deck of cards
import java.util.LinkedList;
import java.util.Random;

public class Deck{
  // Each element in the array will be a string of length 3: a number and char (for suit)
  private LinkedList<Card> cards;
  // All the cards
  private static String[][] allCards;

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

  /**
  * Chooses a card at random and removes and returns the card
  * @return Card
  */
  public Card deal(){
    int chooseCard = (int) (Math.random() * cards.size());
    return cards.remove(chooseCard);
  }

  /**
  * A void method that puts cards into the deck randomly before the start of the game
  * @param Deck (2 of them) that each represent the 2 piles of 26 cards each player starts with
  */

  public static void main(String[] args) {
    // // Convert string argument into integer using wrapper class
    // int amountOfGames = Integer.parseInt(args[0]);
    // // Simulates games
    // Simulation sim = new Simulation(amountOfGames);
    // sim.simulate();
    // sim.calculate();
    // sim.report();
    Deck d1 = new Deck();
    Card c1 = d1.cards.getLast();
    c1.printCard();
    //System.out.println(c1.printCard());
    //d1.allCards[1][1].printCard();
  }
}
