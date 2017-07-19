//Nicholas Wade
//Program Name: WadeP2Hout
//Purpose: To calculate the sum, difference, and product
//         of two numbers and put them within a table
//Input:   numbers that will be added, subtracted,
//         and multiplied together
//Output:  The sum, difference, and product of the inputed
//         numbers

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    float Num1;//all nums are the numbers to be entered
    float Num2;
    float Num3;
    float Num4;
    float Num5;
    float Num6;
    float Num7;
    float Num8;
    float Sum;//the sum of the entered numbers
    float Diff;//difference of numbers
    float Prod;//product of numbers

    cout << "enter two numbers seperated by a space between 0 and 100. ";
    cin >> Num1 >> Num2;
    cout << "enter two numbers seperated by a space between 0 and 100. ";
    cin >> Num3 >> Num4;
    cout << "enter two numbers seperated by a space between 0 and 100. ";
    cin >> Num5 >> Num6;
    cout << "enter two numbers seperated by a space between 0 and 100. ";
    cin >> Num7 >> Num8;

    cout << endl << setw(6) << left << "Num1" << setw(10) << left << "Num2";
    cout << setw(7) << left << "Sum" << setw(15) << left << "Diff" << setw(10) << left << "Prod" << endl;
    Sum = Num1 + Num2;
    Diff = Num1 - Num2;
    Prod = Num1 * Num2;
    cout << setw(6) << setprecision(1) << fixed << Num1;
    cout << setw(10) << left << setprecision(3) << fixed << Num2;
    cout << setw(7) << setprecision(0) << fixed << Sum;
    cout << setw(15) << setprecision(2)<< left << fixed << showpoint << Diff;
    cout << setw(10) << setprecision(7) << Prod << endl;
    Sum = Num3 + Num4;
    Diff = Num3 - Num4;
    Prod = Num3 * Num4;
    cout << setw(6) << setprecision(1) << fixed << Num3;
    cout << setw(10) << left << setprecision(3) << fixed << Num4;
    cout << setw(7) << setprecision(0) << fixed << Sum;
    cout << setw(15) << setprecision(2)<< left << fixed << showpoint << Diff;
    cout << setw(10) << setprecision(7) << Prod << endl;
    Sum = Num5 + Num6;
    Diff = Num5 - Num6;
    Prod = Num5 * Num6;
    cout << setw(6) << setprecision(1) << fixed << Num5;
    cout << setw(10) << left << setprecision(3) << fixed << Num6;
    cout << setw(7) << setprecision(0) << fixed << Sum;
    cout << setw(15) << setprecision(2)<< left << fixed << showpoint << Diff;
    cout << setw(10) << setprecision(7) << Prod << endl;
    Sum = Num7 + Num8;
    Diff = Num7 - Num8;
    Prod = Num7 * Num8;
    cout << setw(6) << setprecision(1) << fixed << Num7;
    cout << setw(10) << left << setprecision(3) << fixed << Num8;
    cout << setw(7) << setprecision(0) << fixed << Sum;
    cout << setw(15) << setprecision(2)<< left << fixed << showpoint << Diff;
    cout << setw(10) << setprecision(7) << Prod;

    return 0;
}
