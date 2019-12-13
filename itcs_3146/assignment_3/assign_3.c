/*
	Author:   Nicholas Wade (nwade3)
	Filename: assign_3.c
	Input:	choice of output
	Output:   system date, calendar, or contents of current directory
	Course:   ITCS-3146
	Version:  1.0
*/

#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

void printChoices ();

int main (int argc, char *argv[]) {
	int choice = 0;
	pid_t child_pid = 0;
	
	printf ("process id: %d; parent process id: %d\n", getpid (), getppid ()); //displays 
	printChoices (); //prints choices
	scanf ("%d", &choice);
	
	while (choice != 4) { //while user has not quit
		switch (choice) {
			case 1:
				if (child_pid = fork () == 0) { //creates a new proccess and gives code to the child to execute
					printf ("\nprocess id: %d; parent process id: %d\n", getpid (), getppid ());
					system ("date"); //uses system call to display date
					
					abort (); //kills child process
				} else {
					while (wait(NULL) > 0); //parent waits till child is done
				}
						
				//reprint choices and get new choice
				printf ("\nprocess id: %d; parent process id: %d\n", getpid (), getppid ());
				printChoices ();
				scanf ("%d", &choice);
				break;
			case 2:
				if (child_pid = fork () == 0) { //creates a new proccess and gives code to the child to execute
					printf ("\nprocess id: %d; parent process id: %d\n", getpid (), getppid ());
					system ("cal"); //uses system call to display calendar
					
					abort (); //kills child process
				} else {
					while (wait(NULL) > 0); //parent waits till child is done
				}
						
				//reprint choices and get new choice
				printf ("\nprocess id: %d; parent process id: %d\n", getpid (), getppid ());
				printChoices ();
				scanf ("%d", &choice);
				break;
			case 3:
				if (child_pid = fork () == 0) { //creates a new proccess and gives code to the child to execute
					printf ("\nprocess id: %d; parent process id: %d\n", getpid (), getppid ());
					system ("ls -l"); //uses system call to display current directory contents
					
					abort (); //kills child process
				} else {
					while (wait(NULL) > 0); //parent waits till child is done
				}
						
				//reprint choices and get new choice
				printf ("\nprocess id: %d; parent process id: %d\n", getpid (), getppid ());
				printChoices ();
				scanf ("%d", &choice);
				break;
			default: //calls out the user for not putting in appropriate output
				printf ("\nprocess id: %d; parent process id: %d\n", getpid (), getppid ());
				printf ("you must enter an integer between 1 and 4 inclusive\n");
				
				//reprint choices and get new choice
				printChoices ();
				scanf ("%d", &choice);
		}
	}
	
	return 0;
	
}

void printChoices () {
	printf ("please choose one:\n");
	printf ("1. print date\n");
	printf ("2. print calendar\n");
	printf ("3. print directory\n");
	printf ("4. quit\n");
}
