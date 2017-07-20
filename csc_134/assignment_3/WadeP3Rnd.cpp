//Nick Wade
//WadeP3Rnd.cpp
//Puprose: gives a random number that fits
//         a certain criteria
//input: none
//output: random number that fits a criteria

#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main()
{
    int first; //first number, criteria-between 10 and 30
    int secon; //second number, criteria-between -1 and -10
    int third; //third number, criteria-between -100 and 0
    int fourth; //fourth number, criteria-between 99 and 101
    unsigned seed = time(0);

    first=secon=third=fourth=0;
    srand (seed);
    first = 10 + rand() % 20;
    secon = -1 - rand() % 10;
    third = -rand() % 100;
    fourth = 99 + rand() % 3;

    cout << "random 1: " << first << endl;
    cout << "random 2: " << secon << endl;
    cout << "random 3: " << third << endl;
    cout << "random 4: " << fourth << endl;

    return (0);
}
