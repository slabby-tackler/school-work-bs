//This program calculates the sum, product, and average of 2 numbers
//Nicholas Wade
#include <iostream>
using namespace std;

int main()
{
  float Num1; //the first number to be entered
  float Num2; //the second number to be entered
  float Sum;
  float Prod; //product
  float Avg; //Average
  cout << "Enter a number. "; cin >> Num1;
  cout << "Enter another number. "; cin >> Num2;
  Sum = Num1 + Num2;
  Prod = Num1 * Num2;
  Avg = Sum / 2.;
  cout << Num1 << " + " << Num2 << " = " << Sum << endl;
  cout << Num1 << " * " << Num2 << " = " << Prod << endl;
  cout << "The average is " << Avg;
  return 0;
}
