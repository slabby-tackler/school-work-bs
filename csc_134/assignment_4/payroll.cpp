//Nicholas Wade
//payroll.cpp
//this program is the visual logic payroll
//input:   hours
//         possible overtime
//         pay rate
//output:  amount a person works in a week
#include <iostream>
using namespace std;

int main()
{
    int payRate; //persons rate of pay
    int hours; //number of hours worked
    char overTime; //Y or N, yes/no overtime pay
    int OTHours; //hours of overtime
    int OTPay; //overtime pay
    int weekPay; //amount paid in week

    cout << "What is your pay rate? ";
    cin >> payRate;
    cout << "How many hours did you work this week? ";
    cin >> hours;
    if (hours > 40)
        {
            cout << "Does your employer pay OT at time and a half (Y or N) ";
            cin >> overTime;
            if (overTime == 'Y'||'y')
                {
                    OTHours = hours - 40;
                    OTPay = OTHours * (payRate + (payRate / 2));
                    weekPay = OTPay + (payRate * 40);
                }
            else weekPay = payRate * hours;
        }
    else weekPay = payRate * hours;
    cout << "Your pay this week is $" << weekPay;

    return 0;
}
