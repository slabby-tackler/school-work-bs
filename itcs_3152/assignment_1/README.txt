Author:	Nicholas Wade (nwade3)
Date:	24/9/2016
Version:	1.0
Course:	ITCS-3152
Files:	problem_1.c, problem_2.c, problem_3.c problem_4.c

*NOTE: all files must be compiled and run independently

********************
*	Problem 1     *
********************

Filename: 	problem_1.c
Input:		none
Output:		the gcd of two hard coded numbers, and the gcd of two numbers with large exponents
Compilation:	run the following command in the assignment directory
	Linux:	gcc problem_1.c
	Unix:	gcc problem_1.c
	Windows:	cl problem_1.c
	OS X:	gcc problem_1.c
Algorithm:
	This algorithm works recursively. The end case for this function is when the modulus of a and b is equal to zero. This works by the remainder of the two being divided gives the GCD. This function has to be recursive to ensure that the two have a common divisor, and to ensure the largest is found if the smaller number were to get passed second.

********************
*	Problem 2     *
********************

Filename: 	problem_2.c
Input:		none
Output:		prime factors and the exponent they are raised to for two seperate large numbers
Compilation:	run the following command in the assignment directory
	Linux:	gcc problem_2.c
	Unix:	gcc problem_2.c
	Windows:	cl problem_2.c
	OS X:	gcc problem_2.c
Algorithm:
	This algorithm iterates from 2 until the square root of the the number to be factored (factorable). If the factorable is divisble by the current number, it is diveded and added to the prime factor output. While the new number is divisible by this number, it continues to divide the number. The count of the exponent (the total number of times it was divided) is then added to the output. If factorable is not divisible by a number the loop continues to the next number. 

********************
*	Problem 3     *
********************

Filename: 	problem_3.c
Input:		none
Output:		The two given matricies, the product of the two, and the sum of the two
Compilation:	run the following command in the assignment directory
	Linux:	gcc problem_3.c
	Unix:	gcc problem_3.c
	Windows:	cl problem_3.c
	OS X:	gcc problem_3.c
Algorithm:
	Given two matricies, the goal is to find the sum and the product of the two. Inorder to find the sum, all elements are iterated through for A and added to the corresponding B value. The result is stored, and eventually printed.
	
	To find the product of the two matricies, iterate through all possible elements for the resulting square matrix. Multiply the corresponding column values of A with the row values of B and add them. the result is placed in the resulting matrix.

********************
*	Problem 4     *
********************

Filename: 	problem_4.c
Input:		none
Output:		the two sets, the intersection of the two sets, and the union of the two sets
Compilation:	run the following command in the assignment directory
	Linux:	gcc problem_4.c
	Unix:	gcc problem_4.c
	Windows:	cl problem_4.c
	OS X:	gcc problem_4.c
Algorithm:
	Given two sets the goal is to intersect them (find the common elements between the two) and find the union (combining the sets without duplicates). For intersecting the sets the algoritm starts by iterating through all the terms in x. It then compares the values in x to those in y to determine which are in common. To combat that a set can have a value shows up twice, the index of y is marked in a seperate variable, so it is not counted twice in the intersection. If the values match, they are then printed.
	
	For the union of the two sets, both sets are iterated as before to determine which values show up in both x and y. The indexes of y are marked for the values they have in common. After these values are marked, the values from x are printed then the values of y that are not in the duplicate list.
