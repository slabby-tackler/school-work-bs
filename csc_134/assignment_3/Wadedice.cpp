//Nicholas Wade
//wadedice.cpp
//purpose:  this program simulates the roll of
//          a pair of dice
//input: none
//output: the numbers that appear on both of the
//        dice

#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main()
{
    int die1; //one of the dice rolled
    int die2; //the other dice rolled
    unsigned seed = time (0); //causes a random number
    //                          every time

    srand(seed);
    die1 = 1 + rand() % 12; //creates random for die1
    //die2 = 1 + rand() % 6; //creates random for die2

    cout << "the values on the dice are: ";
    cout << die1; //<< " and " << die2;

    return 0;
}
