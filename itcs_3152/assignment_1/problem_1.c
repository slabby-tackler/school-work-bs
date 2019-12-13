#include<stdio.h>
#include<stdlib.h>

long gcd (long a, long b);
long power (long a, long b);

int main () {
	printf ("a = 12345678");
	printf ("\nb = 9876543210");
	printf ("\nGCD = %ld\n\n", gcd (12345678, 9876543210));
	
	printf ("a = %ld", power (5, 12) - 1);
	printf ("\nb = %ld", power (7, 21) - 1);
	printf ("\nGCD = %ld\n\n", gcd (power (5, 12) - 1, power (7, 21) - 1));
	
	return 0;
}

/*
	recursive function to find gcd
*/
long gcd (long a, long b) {
	if (b == 0) {
		return a;
	} else {
		return gcd(b, a % b);
	}
}

/*
	function to calculate exponents
*/
long power (long base, long exp) {
	int i;
	long result = 1;
	
	for (i = 0; i < exp; ++i)
		result *= base;
		
	return result;	
}
