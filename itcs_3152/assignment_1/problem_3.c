#include <stdlib.h>
#include <stdio.h>
int main () {
	// iterators
	int i, j, k;
	
	int A[6][6] = {{824, -65, -814, -741, -979, -764},
				{216, 663, 880, 916, 617, -535},
				{597, -245, 79, 747, 477, -535},
				{-906, -905, -266, -8, 765, 448},
				{-348, 470, -608, -686, 702, 61},
				{-49, -433, 966, 902, -942, 712}};
				
	int B[6][6] = {{761, -892, -564, -826, 251, -414},
				{-44, -214, 235, -781, 421, -340},
				{881, 444, 360, 932, 700, 725},
				{-750, -637, -915, 192, 617, 41},
				{509, -167, 127, 628, 51, 837},
				{-28, 57, -13, -436, -720, 222}};
				
	int C[6][6] = {0};
				
	// print A
	printf ("A = \n");
	for (i = 0; i < 6; ++i) {
		for (j = 0; j < 6; ++j) {
			printf ("%d ", A[i][j]);
		}
		printf ("\n");
	}
	printf("\n");
	
	// print B
	printf ("B = \n");
	for (i = 0; i < 6; ++i) {
		for (j = 0; j < 6; ++j) {
			printf ("%d ", B[i][j]);
		}
		printf ("\n");
	}
	printf ("\n");
	
	// calculate sum
	for (i = 0; i < 6; ++i) {
		for (j = 0; j < 6; ++j) {
			C[i][j] = A[i][j] + B[i][j];
		}
	}
	
	// print sum
	printf ("Sum = \n");
	for (i = 0; i < 6; ++i) {
		for (j = 0; j < 6; ++j) {
			printf ("%d ", C[i][j]);
		}
		printf ("\n");
	}
	printf ("\n");
	
	// calculate product
	for (i = 0; i < 6; ++i) {
		for (j = 0; j < 6; ++j) {
			C[i][j] = 0;
			for (k = 0; k < 6; ++k) {
				C[i][j] += A[i][k] * B[k][j];
			}
		}
	}
	
	// print product
	printf ("Product = \n");
	for (i = 0; i < 6; ++i) {
		for (j = 0; j < 6; ++j) {
			printf ("%d ", C[i][j]);
		}
		printf ("\n");
	}
	printf ("\n");
	
	return 0;
}
