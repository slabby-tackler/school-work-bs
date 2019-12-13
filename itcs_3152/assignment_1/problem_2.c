#include<stdio.h>
#include<stdlib.h>

void factor (long a);

long power (int base, int exp);

int main () {
	printf ("a = 8856433488048011");
	printf ("\nfacotrization = ");
	
	factor (8856433488048011);
	printf ("\n\n");
	
	printf ("a = %ld", power (5, 32) - 7);
	printf ("\nfacotrization = ");
	factor (power (5, 32) - 7);
	printf ("\n\n");
	
	return 0;
}

/*
	function to calculate exponents
*/
long power (int base, int exp) {
	int i;
	long result = 1;
	
	for (i = 0; i < exp; ++i)
		result *= base;
		
	return result;	
}

void factor (long a) {
	// first prime number
	long start = 2;
	
	// if number is one, that is the prime factorization
	if (a == 1) {
		printf (" 1 ");
	}
	
	if ( a > 1) {
		// boolean for if the number is a prime factor;
		int prime_factor = 0;
		
		while (a > 1 && start * start <= a) {
			// check if number is divisble by a value
			if (a % start == 0) {
				++prime_factor;
				
				// determine when to place multiplication symbol
				if (prime_factor > 1)
					printf (" * ");
				
				// print the prime factor
				printf(" %ld ", start);
				
				// divide by prime number
				a /= start;
				
				// iterator for exponents
				int exponent = 1;
				
				// determine to what power the prime factor is
				while (a % start == 0) {
					a /= start;
					++exponent;
				}
				
				// print the exponent if needed
				if (exponent > 1) {
					printf ("^ %d", exponent);
				}
			}
			
			// move to next value
			++start;
		}
		
		// print mulitiplication symbol when necessary
		if (a > 1 && prime_factor >= 1)
			printf (" * ");
			
		// print the final value if it is prime
		if (a > 1)
			printf (" %ld ", a);
	}
}
