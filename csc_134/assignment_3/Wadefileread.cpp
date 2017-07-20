#include <iostream>
#include <fstream>
using namespace std;

int main()
{
    char city[21];
    int number;
    char parent1[11];
    char parent2[11];
    ifstream myfile;

    myfile.open("myfile.txt");

    myfile >> city;
    cout << city << endl;
    myfile >> number;
    cout << number << endl;
    myfile >> parent1;
    cout << parent1 << endl;
    myfile >> parent2;
    cout << parent2 << endl;
    myfile.close();

    return 0;
}
