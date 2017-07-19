//Nicholas Wade
//WadeP2Proper.cpp
//Purpose:  do detemine the amount of change a person gets back after
//          paying for a pizza, calculate the number of slices in a pizza,
//          and calculate the number of pizzas someone will need for a party
//Input:  size of pizza, how much money was paid,
//        number of people for party
//Output: change due back for the customer, number of slices
//        for the pizza, number of pizzas need for party
//Assumptions:  each person eats 4 slices of pizza
//              pi is 3.14159, area per slice is 14.125
//              10" pizza costs 8.75, 14" pizza costs 12.50
//              customer has enough to pay for the bill

#include <iostream>
#include <cmath> //use power function on line 30
#include <iomanip>
using namespace std;

int main()
{
    int diam; //diameter of pizza
    float NumPizza;
    float NumSlices;
    float area;
    int NumPeople;
    float cost; //cost of the pizza
    float Change; // how much change is due to the customer
    float Paid; // how much the customer paid

    cout << "What size pizza did you order? ";
    cin >> diam;
    cout << "How many people are there? ";
    cin >> NumPeople;
    area = 3.14159 * pow(diam/2.,2); //calculates area of pizza
    NumSlices = area / 14.125;
    NumPizza = (NumPeople * 4) / NumSlices; //calculates the number of pizzas
    cout << "Your pizza will have " << setprecision(1) << fixed << NumSlices << " slices." << endl;
    cout << "You need " << setprecision(0) << fixed << NumPizza << " pizza(s)." << endl;
    cout << "How much did you pay? ";
    cin >> Paid;
    cost = (diam * .875); //calculates cost
    Change = Paid - cost; //calculates change
    cout << "your change is $" << setprecision(2) << fixed << Change << ".";

    return 0;
}
