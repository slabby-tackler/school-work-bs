#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    int count = 0;
    float price;
    float total = 0;

    while (true)
        {
           cout << "Enter the price of the item please or 0 to quit. ";
           cin >> price;
           if (price != 0)
           {
               total = total + price;
               count = count + 1;
           }
           else break;
        }
    cout << "The bill for those " << count;
    cout << " items is $" << setprecision(2) << fixed << total;

    return 0;
}
