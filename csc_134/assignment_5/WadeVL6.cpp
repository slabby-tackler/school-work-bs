#include <iostream>
using namespace std;

int main()
{
    int num;

    cout << "Please insert an odd number. ";
    cin >> num;

    while ((num % 2) == 0)
    {
        cout << "That number is not odd." << endl;
        cout << "Please insert an odd number. ";
        cin >> num;
    }
    cout << "thank you.";

    return 0;
}
