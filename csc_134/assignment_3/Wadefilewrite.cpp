//Nick Wade
//Wadefilewrite.cpp
//Purpose: write information about a user
//         to a file
//input: favorite city, mother's name,
//       father's name, and favorite number
//output: users info put in file myfile.txt

#include <iostream>
#include <fstream>
#include <iomanip>
using namespace std;

int main()
{
    char city[21]; //city name and state
    int number; //users favorite number
    char parent1[11]; //father's name
    char parent2[11]; //mother's name
    ofstream myfile;

    cout << "What is your favorite city and state (use comma to seperate, no spaces)? ";
    cin.getline(city,21);
    cout << "What is your favorite number? ";
    cin >> number;
    cout << "What are your parent's names (seperate with a space)? ";
    cin >> parent1 >> parent2;

    cout << endl << city << endl;
    cout << number << endl;
    cout << parent1 << endl;
    cout << parent2 << endl;

    myfile.open("myfile.txt");
    myfile << city;
    myfile << " " << number;
    myfile << " " << parent1;
    myfile << " " << parent2;
    myfile.close();

    return 0;
}
