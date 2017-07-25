//Nicholas Wade
//WadeP6n23.cpp
//input: a value that is positive but no greater
//       than 15
//output: a square with side length
//        of the number provided by
//        the user
//Assumptions: user can follow directions
#include <iostream>
using namespace std;

int main()
{
    int x; //store number provided by user
    int count1, count2; //used for counter purposes

    cout << "Please provide a positive integer that is no greater than 15. "; //shows assumption
    //and asks the user input
    cin >> x;

    for (count2 = 1; count2 <= x; count2++)//this loop sets the height of the square
    {
        for (count1 = 1; count1 <= x; count1++) // this loop sets the width of the square
        {
            cout << "x "; //displays an "x" to follow the directions
        }
        cout << endl; //starts the next row
    }

    return 0;
}
