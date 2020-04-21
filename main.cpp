#include <iostream>
#include <stdio.h>
#include <ctype.h>
#include <list>
#include <string>
#include "Card.h"
#include "GenStack.h"
using namespace std;

void getPCards(list<Card>& cards){
}

int main(int argc, char *argv[])
{
  // GenStack<Card> river = new GenStack<Card>(5);
  //create list with 2
  Card player_cards[2];
  //Enter both cards
  string typeOCard[14] = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
  string value;
  int check = 0;
  string name;
  char suit;
  for(int i = 0; i < 2; ++i)
  {
    //get user's cards input
    cout << "Enter card name (10, J, K): " << endl;
    cin >> name;
    while(check != 13)
    {
      //check if entered name is in array
      for(int i = 0; i < 14; ++i)
      {
        if(typeOCard[i] != name)
        {
          check++;
        }
      }
      if(check != 13)
      {
        cout << check << endl;
        cout << "Invalid name... try again!";
        check = 0;
        cout << "Enter card name (10, J, K): " << endl;
        cin >> name;
      }
    }
    value = name;

    cout << "Enter suit (S, C, H, D): " << endl;
    cin >> suit;
    suit = tolower(suit);
    player_cards[i] = Card(value, suit);
  }

  player_cards[0].printCard();

}
