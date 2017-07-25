//Nicholas Wade
//WadeP5RandomNumber.cpp
//input:  user's guess
//output: a winning statement, or a try again statement
//assumption: the user may use a number with a decimal
#include <iostream>
#include <ctime>
#include <cstdlib> //to use rand
using namespace std;

int main()
{
    unsigned seed = time(0);
    float guess; //user's guess, floated so truncation does not
                 //cause a wrong guess to be correct
    int actual; //generated number
    int guessNum = 1; //user has to start with first guess

    srand(seed);
    actual = 1 + rand() % 10; //creates a random number for the user to guess

    cout << "Random Number Guessing Game!"; //title of the game
    cout << endl << endl<< "Guess a number between 1 and 10. ";
    cin >> guess;// users initial guess
    do
    {
        guessNum++; //adds 1 to the number of guesses
        if (actual < guess)
        {
            cout << "too high, try again. ";
            cin >> guess;
        }
        else
        {
            cout << "too low, try again. ";
            cin >> guess;
        }
    }
    while (guess != actual);
    cout << "You Win!" << endl; //tells the user when they get the number right
    cout << "You guessed "<< guessNum << " times."; //displays the number of guesses the user used

    return 0;
}
