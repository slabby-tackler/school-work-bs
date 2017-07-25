#include<iostream>
using namespace std;
void triup()
{
    int row, col;
    //triangle point
            cout<<"triangle point-up"<<endl;
            for(row=1; row<=5; row++)
            {   for(col=1; col<=5-row; col++)cout<<" ";
                for(col=1; col<=row; col++)cout<<"*";
                cout<<endl;
            }
}
void tridown()
{
    int row, col;
    //triangle point-down
            cout<<"triangle point-down"<<endl;
            for(row=5; row>=1; row--)
            {
                for(col=1; col<=row; col++)cout<<"*";
                cout<<endl;
            }
}
void square()
{
    int count1, count2;

    for (count2 = 1; count2 <= 5; count2++)//this loop sets the height of the square
    {
        for (count1 = 1; count1 <= 5; count1++) // this loop sets the width of the square
        {
            cout << "*"; //displays an "x" to follow the directions
        }
        cout << endl; //starts the next row
    }
}
int main(){
    int choice;
    do{ //loop at least once
        do{
            cout<<"what would you like to see"<<endl;
            cout<<"0. quit\n"
            <<"1. triangle pointing up\n2. triangle pointing down\n3. a square\n";
            cin>>choice;
            }while(choice < 0);
        switch(choice){
            case 0: cout<<"have a great day!"<<endl;
                break;
            case 1: triup();
                    break;
            case 2: tridown();
                    break;
            case 3: square();
                    break;
            default: cout << "invalid entry";

        }//end switch
    }while (choice != 0);
return 0;}
