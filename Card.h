#include <iostream>
#include <string>

using namespace std;

class Card{
  public:
    string value;
    char suit;
    string symbol;

    //constructor
    Card();
    //overload
    Card(string newValue, char newSuit);
    //Setters
    void setValue(string newValue);
    void setSuit(char newSuit);
    void setSymbol(char suit);
    //Getters
    string getValue();
    char getSuit();
    string getSymbol();
    //Print Cards
    void printCard();
    //checks if value is one or 2 characters
    bool isSingle();
};

Card::Card()
{
  value = "0";
  suit = 'v';
  symbol = "void";
}

Card::Card(string newValue, char newSuit)
{
  value = newValue;
  suit = newSuit;
  setSymbol(suit);
}

void Card::setValue(string newValue){
  value = newValue;
}
void Card::setSuit(char newSuit){
  suit = newSuit;
}
void Card::setSymbol(char suit){

  if(suit == 's')
  {
    symbol = "♠";
  }
  else if(suit == 'h')
  {
    symbol = "♥";
  }
  else if(suit == 'c')
  {
    symbol = "♣";
  }
  else if(suit == 'd')
  {
    symbol = "♦";
  }
}
//Getters
string Card::getValue(){
  return value;
}
char Card::getSuit(){
  return suit;
}

string Card::getSymbol(){
  return symbol;
}

bool Card::isSingle(){
  if(value.length() == 1)
  {
    return true;
  }
  else
  {
    return false;
  }
}

void Card::printCard(){
  if(isSingle() == true)
  {
    cout << " -------" << endl;
    cout << "| " <<getValue() << "     |" << endl;
    cout << "| " << getSymbol() << "     |" << endl;
    cout << "|       |" << endl;
    cout << "|     " << getSymbol() << " |" << endl;
    cout << "|     " << getValue() << " |" << endl;
    cout << " -------" << endl;
  }
  else
  {
    cout << " -------" << endl;
    cout << "|" <<getValue() << "     |" << endl;
    cout << "| " << getSymbol() << "     |" << endl;
    cout << "|       |" << endl;
    cout << "|     " << getSymbol() << " |" << endl;
    cout << "|     " << getValue() << "|" << endl;
    cout << " -------" << endl;
  }
  //  -------
  // | K     |
  // | ♠     |
  // |       |
  // |     ♠ |
  // |     K |
  //  -------
  //
  //  -------
  // | K     |
  // | ♣     |
  // |       |
  // |     ♣ |
  // |     K |
  //  -------
  //
  //  -------
  // | K     |
  // | ♥     |
  // |       |
  // |     ♥ |
  // |     K |
  //  -------
  //
  //  -------
  // | K     |
  // | ♦     |
  // |       |
  // |     ♦ |
  // |     K |
  //  -------

}
