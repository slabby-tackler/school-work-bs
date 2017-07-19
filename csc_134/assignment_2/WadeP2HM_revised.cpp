// Nicholas Wade
// WadeP2HM
// Purpose: This is used to show the correctness of the answers to 3.17, 3.18,
//         and 3.19
#include <iostream>
using namespace std;

/* 3.17
What I put: const float E = 2.71828
            const float MIN_IN_YEAR = 5.256e5
            const float GRAV_ACCEL_FEET = 32.2
            const float GRAV_ACCEL_METER = 9.8
            const int METER_IN_MILE = 1609

3.18
What I put: #define EU 2.71828
            #define MINU_IN_YEAR 5.256e5
            #define GRAVI_ACCEL_FEET 32.2
            #define GRAVI_ACCEL_METER 9.8
            #define METERS_IN_MILE 1609

3.19
The output would be: This program calculates the number of candy pieces sold.
                     How many jars of candy have you sold?
                     The number of pieces sold: 11160
                     candy pieces you get for commission: 2232
3.23
What I put: 3
            11
            1   */

//3.18
#define EU 2.71828
#define MINU_IN_YEAR 5.256E5
#define GRAVI_ACCEL_FEET 32.2
#define GRAVI_ACCEL_METER 9.8
#define METERS_IN_MILE 1609

//3.19
#define GREETING1 "This program calculates the number "
#define GREETING2 "of candy pieces sold."
#define QUESTION "How many jars of candy have you sold? "
#define RESULTS "The number of pieces sold: "
#define YOUR_COMMISSION "Candy pieces you get for commission: "
#define COMMISSION_RATE .20

int main()
{
    //3.17
    const float E = 2.71828;
    const float MIN_IN_YEAR = 5.256e5;
    const float GRAV_ACCEL_FEET = 32.2;
    const float GRAV_ACCEL_METER = 9.8;
    const int METER_IN_MILE = 1609;
    cout << "Section 3.17: "; //shows question in program
    cout << E << endl;
    cout << "              " << MIN_IN_YEAR << endl;//spaces to get in column
    cout << "              " << GRAV_ACCEL_FEET << endl;
    cout << "              " << GRAV_ACCEL_METER << endl;
    cout << "              " << METER_IN_MILE << endl;
    //after running it displays the appropriate numbers

    //3.18
    cout << endl << "Section 3.18: "; //shows question in program
    cout << EU << endl;
    cout << "              " << MINU_IN_YEAR << endl;//spaces to get in column
    cout << "              " << GRAVI_ACCEL_FEET << endl;
    cout << "              " << GRAVI_ACCEL_METER << endl;
    cout << "              " << METERS_IN_MILE << endl;
    //after running it displays the appropriate numbers

    //3.19
    const int PER_JAR = 1860;
    int jars, pieces;
    double commission;

    cout << endl << "Section 3.19:" << endl; //shows question in program
    cout << GREETING1;
    cout << GREETING2 << endl;
    cout << QUESTION;
    cin >> jars;
    pieces = jars * PER_JAR;
    cout <<RESULTS << pieces << endl;
    commission = pieces * COMMISSION_RATE;
    cout << YOUR_COMMISSION << commission << endl << endl;
    //after running it should display what was put up top

    //3.22
    x += 6;
    amount -= 4;
    y *= 4;
    total /= 27;
    x %= 7;
    x += y *=5;
    total -= discount *= 4;
    increase *= salesRep *= 5;
    profit /= shares -= 1000;


    //3.23
    int unus, duo, tres;

    unus = duo = tres = 5;
    unus += 4;
    duo *= 2;
    tres -= 4;
    unus /= 3;
    duo += tres;
    cout << unus << endl;
    cout << duo << endl;
    cout << tres << endl;//after running it displays what I put

    /*some fun
    1) will work; values: x = 7, y = 7
    2) will not work
    3) will work; values: x = 1/24, y = 2, z = 1/12 */

    return 0;
}
/*Extra credit: I think that peopole still use "#define" because
                it creates a short cut if someone were to be using
                the same phrase several times in a program.  Unlike
                the constants "#define" can hold any type of value;
                with constants are considered as a variable which will
                hold a number.*/
