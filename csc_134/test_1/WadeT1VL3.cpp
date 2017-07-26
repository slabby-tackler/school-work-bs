//this program calculates pay rate
//Nicholas Wade
#include <iostream>
using namespace std;

int main()
{
    char name[11];
    float pay_rate;
    int hours_worked;
    float pay;
    cout << "What is your name? "; cin >> name;
    cout << "What is your pay rate? "; cin >> pay_rate;
    cout << "How many hours did you work? "; cin >> hours_worked;
    cout << "Rate of pay: $" << pay_rate << endl;
    cout << "Hours this week: " << hours_worked << endl;
    pay = pay_rate * hours_worked;
    cout << name << ", your pay is $" << pay << " this week";
    return 0;
}
