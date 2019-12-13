#include<stdio.h>
#include<stdlib.h>

int main() {
	// holds values for x and y (given)
	int x[] = {1, 2, 3, 4, 7};
	int y[] = {0, 2, 4, 5, 6};
	
	// maintains indexes of values in both
	int z[5] = {0};
	
	// iterators
	int i;
	int j;
	
	// print values in x
	printf ("X = ");
	for (i = 0; i < 5; ++i) {
		printf("%d ", x[i]);
	}
	printf ("\n");
	
	//print values in y
	printf ("Y = ");
	for (i = 0; i < 5; ++i) {
		printf("%d ", y[i]);
	}
	printf ("\n\n");
	
	// print the intersection of the two
	printf ("X intersect Y = ");
	
	// iterate all values of x
	for (i = 0; i < 5; ++i) {
		//iterate all values of y
		for (j = 0; j < 5; ++j) {
			// skip if index is already used (removes duplicates in one and not the other)
			if (!z[j]) {
				// determine if the values are the same
				if (x[i] == y[j]) {
					// mark index
					z[j] = 1;
					// print value
					printf ("%d ", x[i]);
					// move to next value of x
					break;
				}
			}
		}
	}
	printf ("\n\n");
	
	// reset z for union
	for (i = 0; i < 5; ++i)
		z[i] = 0;
	
	// print the union of the two
	printf ("X union Y = ");
	// iterate all values of x
	for (i = 0; i < 5; ++i) {
		// iterate all values of y
		for (j = 0; j < 5; ++j) {
			// skip if index is marked
			if (!z[j]) {
				// determine equality
				if (x[i] == y[j]) {
					// mark index
					z[j] = 1;
					// move to next value of x
					break;
				}
			}
		}
	}
	
	// print values of x
	for (i = 0; i < 5; ++i)
		printf ("%d ", x[i]);
		
	// print y values not in x
	for (i = 0; i < 5; ++i)
		if (!z[i])
			printf ("%d ", y[i]);
	printf ("\n\n");
	
	return 0;
}
