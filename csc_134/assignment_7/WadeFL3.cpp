#include<iostream>
using namespace std;

float triup(int);
float tridown(int);
float square(int);

int main(){
    int choice, size;
    float area;
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
            case 1: do{cout<<"what size would you like (3-15)";
                    cin>>size;
                    }while (size<3 || size>15);
                    triup(size);
                    area=tridown(size);
                    cout<<"the area is "<<area<<endl;
                    break;
            case 2: do{cout<<"what size would you like (3-15)";
                    cin>>size;
                    }while (size<3 || size>15);
                    tridown(size);
                    area=tridown(size);
                    cout<<"the area is "<<area<<endl;
                    break;
            case 3: do{cout<<"what size would you like (3-15)";
                    cin>>size;
                    }while (size<3 || size>15);
                    square(size);
                    area=tridown(size);
                    cout<<"the area is "<<area<<endl;
                    break;
            default: cout <<endl<<"invalid entry";
        }//end switch
    }while (choice != 0);
return 0;}

float triup(int size)
{
    int row, col;
    float area;
    //triangle point
            cout<<"triangle point-up"<<endl;
            for(row=1; row<=size; row++)
            {   for(col=1; col<=size-row; col++)cout<<" ";
                for(col=1; col<=row; col++)cout<<"*";
                cout<<endl;
            }
            area = (size*size)/2.;
    return area;
}
float tridown(int size)
{
    int row, col;
    float area;
    //triangle point-down
            cout<<"triangle point-down"<<endl;
            for(row=size; row>=1; row--)
            {
                for(col=1; col<=row; col++)cout<<"*";
                cout<<endl;
            }
            area=(size*size)/2.;
            return area;
}
float square(int size)
{
    int count1, count2, area;

    for (count2 = 1; count2 <= size; count2++)//this loop sets the height of the square
    {
        for (count1 = 1; count1 <= size; count1++) // this loop sets the width of the square
        {
            cout << "*"; //displays an "x" to follow the directions
        }
        cout << endl; //starts the next row
    }
    area=(size*size);
    return area;
}
