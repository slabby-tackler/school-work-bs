//Nicholas Wade
//WadeP5FileRead.cpp
//input: none
//output: numbers from file random.txt
#include <iostream>
#include <fstream>
using namespace std;

int main()
{
   int num; //number to be read from file
   int num2; //holds the sum of numbers
   int count = 0; //counts number of items in file
   int avg; //holds avgerage of numbers
   ifstream text("random.txt"); //opens file to read data from

   do
   {
      count++; //adds 1 to count to keep track of number of items in file
      num2 += num; //calculates sum
      text >> num; //takes a number from file
      cout << num << endl; //displays numbers from file
   }
   while (text >> num);

   avg = num2/count; //calculates average
   cout << endl << "There are " << count << " numbers in the file.";
   cout << endl << "The sum of all the numbers is " << num2 << ".";
   cout << endl << "The average of all the numbers is " << avg << ".";

   return 0;
}
