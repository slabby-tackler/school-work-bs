//Nicholas Wade
//WadeP4Proper
//Purpose: to calculate the total cost of a purchase
//         that includes three different types of plants
//         and the charge for the truck.
//Input:   Number of perenials, trees and shrubs to be
//         purchased.
//Output:  the total cost of all items plus the charge for
//         the trucks.
//Assumptions: the store does not accept returns
#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

int main()
{
    int shrub,tree,peren;
    float perenPrice;
    int treePrice,shrubPrice;
    float perenTruck,treeTruck,shrubTruck;
    float plantTotal;
    float truck;
    int truckPrice;
    float totalPrice;

    cout << "How many shrubs would you like to buy (we only have 40)? ";
    cin >> shrub;
    if (shrub < 0)
    {
        cout << "We do not accept returns on our merchandise.\n";
        cout << "Please restart the program and try again.";
    }
    else
    {
        if (shrub > 40)
        {
            cout << "The number you have entered exceeds our stock.\n";
            cout << "Please restart the program and try again.";
        }
        else
        {
            cout << "How many trees would you like? ";
            cin >> tree;
            if (tree < 0)
            {
                cout << "We do not accept returns on our merchandise.\n";
                cout << "Please restart the program and try again.";
            }
            else
            {
                cout << "How many Perenials would you like? ";
                cin >> peren;
                if (peren < 0)
                {
                    cout << "We do not accept returns on our merchandise.\n";
                    cout << "Please restart the program and try again.";
                }
                else
                {
                    perenPrice = peren * 10;
                    treePrice = tree * 20;
                    shrubPrice = shrub * 15;
                    if (peren > 20) perenPrice = perenPrice - (.1 * perenPrice);
                    plantTotal = perenPrice + treePrice + shrubPrice;
                    perenTruck = peren / 100.;
                    treeTruck = tree / 15.;
                    shrubTruck = shrub / 40.;
                    truck = perenTruck + treeTruck + shrubTruck;
                    truckPrice = ceil(truck) * 25;
                    totalPrice = truckPrice + plantTotal;
                    cout << "Your total is $" << setprecision(2) << fixed << totalPrice;
                }
            }
        }

    }
    return 0;
}
