// This program will output the circumference and area
// of the circle with a given radius.
// PLACE YOUR NAME HERE
#include <iostream>
using namespace std;
const double PI = 3.14;
const double RADIUS = 5.4;
int main()
{
float area; // definition of area of circle
int circumference; // definition of circumference
circumference = 2 * PI * RADIUS; // computes circumference
area = PI*RADIUS*RADIUS; // computes area
// Fill in the code for the cout statement that will output (with description)
// the circumference
cout<< "The circumference of the circle is "<<circumference<< endl;
// Fill in the code for the cout statement that will output (with description)
// the area of the circle
cout<< "The area of the circle is "<<area;
return 0;
}
