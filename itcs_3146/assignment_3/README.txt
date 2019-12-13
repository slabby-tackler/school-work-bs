Author:   Nicholas Wade (nwade3)
Filename: assign_3.c
Input:	choice of output
Output:   system date, calendar, or contents of current directory
Course:   ITCS-3146
Version:  1.0

This program gives the user a menu and gives them the infromation that they want to see. For this to work, the program creates a child process to execute a system call. When the child is finshed with its task it dies and the parent begins executing again. The parent pauses while the child is still working on its task, then goes on to accept another output request from the user.
