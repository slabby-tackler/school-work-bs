/*
	Author:	Nicholas Wade
	Filename:	path.c
	Input:	lenght and width of field, file containing field
	Output:	field with attempted path, if an exit was found
	Course:	ITCS 3146
	Version:	1.1
	Date:	9-Sep-2015
 */

#include <stdio.h>
#include <stdlib.h>

int main ()
{
	//number type variables
	short current_x, current_y;	//current position
	int x, y;					//user field values
	short start_x, start_y;		//start of the maze
	short exit_x, exit_y;
	short exit = 0;			//determines if exit exists
	short entrance = 0;			//true if entrance was found
	short i, j;				//indecies for looping
	short first = 1;
	short space_turn = 0;
	
	//alpha type variables
	char direction;
	char field[200][200];
	char filename[50];
	char c;					//character from files
	
	FILE *fptr;
	
	//get input from user
	printf ("What is the size of the field? (l w)\n");
	scanf ("%d %d", &x, &y);
	
	printf ("Where is the file located\n");
	scanf ("%s", filename);
	
	//iterating through the file
	fptr = fopen(filename, "r");
	
	for (i = 0; i < x; ++i)
	{
		for (j = 0; j < y; ++j)
		{
			c = fgetc(fptr);
			while ( !((c == '1') || (c == '0')))
			{
				c = fgetc(fptr);
			}
			field[i][j] = c;
		};
	}
	
	fclose(fptr);
	
	//find entrance to maze
	for (i = 0; i < y; ++i)
	{
		if (field[0][i] == '0')
		{
			start_x = 0;
			start_y = i;
			current_x = 0;
			current_y = i;
			entrance = 1;
			direction = 'S';
		}
	}
	
	for (i = 0; i < y; ++i)
	{
		if (field[x - 1][i] == '0')
		{
			if (!entrance)
			{
				start_x = x - 1;
				start_y = i;
				current_x = x - 1;
				current_y = i;
				entrance = 1;
				direction = 'N';
			}
			else
			{
				exit_x = x - 1;
				exit_y = i;
			}
		}	
	}
	
	for (i = 0; i < x; ++i)
	{
		if (field[i][0] == '0')
		{
			if (!entrance)
			{
				start_x = i;
				start_y = 0;
				current_x = i;
				current_y = 0;
				entrance = 1;
				direction = 'E';
			}
			else
			{
				exit_x = i;
				exit_y = 0;
			}
		}
	}

	for (i = 0; i < x; ++i)
	{
		if (field[i][y - 1] == '0')
		{
			if (!entrance)
			{
				start_x = i;
				start_y = y - 1;
				current_x = i;
				current_y = y - 1;
				entrance = 1;
				direction = 'W';
			}
			else
			{
				exit_x = i;
				exit_y = y - 1;
			}
		}
	}	
	
	//if entrance was not found
	if (!entrance)
	{
		printf("Program could not determine an entrance.\n");
		return 0;
	}
	
	//moving through the field
	while (!exit)
	{
		if (first)
		{
			field[current_x][current_y] = 'X';
			switch (direction)
			{
				case 'N':
					if (field[current_x - 1][current_y] != '1' && !(current_x - 1 < 0))
					{
						first = 0;
						current_x -= 1;
					}
					else
					{
						space_turn++;
						direction = 'W';
					}
				case 'W':
					if (field[current_x][current_y - 1] != '1' && !(current_y - 1 < 0))
					{
						first = 0;
						current_y -= 1;
					}
					else
					{
						space_turn++;
						direction = 'S';
					}
				case 'S':
					if (field[current_x + 1][current_y] != '1' && current_x + 1 != x)
					{
						first = 0;
						current_x += 1;
					}
					else
					{
						space_turn++;
						direction = 'E';
					}
				case 'E':
					if (field[current_x][current_y + 1] != '1' && current_y + 1 != y)
					{
						first = 0;
						current_y += 1;
					}
					else
					{
						space_turn++;
						direction = 'N';
					}
			}		
		}
		else if (current_x == exit_x && current_y == exit_y)
		{
			exit = 1;
		}
		else if (current_x == start_x && current_y == start_y)
		{
			break;
		}
		else
		{
			switch (direction)
			{
				case 'N':
					if (field[current_x][current_y - 1] != '1')
					{
						direction = 'W';
						current_y -= 1;
					}
					else
					{
						if (field[current_x - 1][current_y] != '1')
						{
							current_x -= 1;
						}
						else
						{
							direction = 'E';
						}
					}
					break;
				case 'E':
					if (field[current_x - 1][current_y] != '1')
					{
						direction = 'N';
						current_x -= 1;
					}
					else
					{
						if (field[current_x][current_y + 1] != '1')
						{
							current_y += 1;
						}
						else
						{
							direction = 'S';
						}
					}
					break;
				case 'S':
					if (field[current_x][current_y + 1] != '1')
					{
						direction = 'E';
						current_y += 1;
					}
					else
					{
						if (field[current_x + 1][current_y] != '1')
						{
							current_x += 1;
						}
						else
						{
							direction = 'W';
						}
					}
					break;
				case 'W':
					if (field[current_x + 1][current_y] != '1')
					{
						direction = 'S';
						current_x += 1;
					}
					else
					{
						if (field[current_x][current_y - 1] != '1')
						{
							current_y -= 1;
						}
						else
						{
							direction = 'N';
						}
					}
					break;
			}
		}
		
		field[current_x][current_y] = 'X';
		
		if (space_turn == 4)
			break;
	}
	
	//output for the program
	for (i = 0; i < x; ++i)
	{
		for (j = 0; j < y; ++j)
		{
			printf("%c", field[i][j]);
		}
		printf("\n");
	}
	
	if (exit)
		printf ("\nPath found!\n");
	else
		printf ("\nNo path found.\n");
		
	return 0;
}
