/**
	@Author:   Nicholas Wade
	@Filename: justify.c
	@Input:	 File with paragraph, number of characters per line
	@Output:   Contents of file with appropriate number of characters per line
	@Course:   ITCS-3146
	@Version:  1.1
*/

#include <stdlib.h>
#include <stdio.h>
#include <ctype.h> 	//to use isspace();
#include <string.h> //to use strcpy();
#define DEBUG 1

struct WORD_QUEUE {
	char letters[15];
	short string_length;
	struct WORD_QUEUE *next_word;
};

typedef struct WORD_QUEUE WORD;
typedef WORD *WORD_QUEUE_POINTER;

void enqueue (WORD_QUEUE_POINTER *, char *, short); 				//adds word to queue
void dequeue (WORD_QUEUE_POINTER *); 							//removes and prints word from queue
short count_words_per_line (WORD *, short, short);				//determines the number of words that can fit on a line
WORD_QUEUE_POINTER * get_next (WORD_QUEUE_POINTER *);				//gets the address of the next word in the queue
void set_next (WORD_QUEUE_POINTER *, WORD_QUEUE_POINTER *); 		//sets the next address of queue
short count_chars (WORD *, short);								//determines number of characters through queue

int main () {

	//string and character datatypes
	char file_name[50];
	char word[15]; 			//double the number of letters in the average word; if it is greater than this this then I am impressed
	char c;
	
	//numeric datatypes
	int char_per_line = 0;		//holds the number of characters per line (specified by user)
	short first = 1;			//determines when first iteration of loop
	short count = 0;			//keeps track of number of characters in each word
	short line_word_count = 0;	//number of words for a line
	short iterate_word_count = 0;	//counts number of words in a broad iteration; used to know how when to start a new paragraph
	short para_word_count[11];	//holds how words in each paragraph; not expecting more than 10 paragraphs
	short para_count = 1;		//keeps track of how many paragraphs there are; paragraph denoted by two '\n'
	short para_num = 1;			//current paragraph for iteration
	short endl_count = 0;		//number of end line characters to determine when a paragraph ends
	short char_left = 0;		//number of characters left after accounting for words
	double num_spaces = 0.0;		//number of spaces to place between words
	short i, j;				//used in for loops
	
	//other datatypes
	FILE *file_pointer;
	WORD_QUEUE_POINTER word_queue = NULL;
	
	//get name of the file
	printf ("What is the file name\n");
	scanf ("%s", file_name);
	
	//get a number between 40 and 100 inclusive
	while (char_per_line < 40 || char_per_line > 100) {
		printf ("How many characters do you want on each line? (value must be between 40 and 100 inclusive)\n");
		scanf ("%d", &char_per_line);
	}
	
	file_pointer = fopen (file_name, "r");
	
	//iterate through file to get characters
	do{
		c = fgetc (file_pointer);
		
		//determines if character is white space
		if (isspace (c)){
			if (c == '\n'){
				endl_count++;
			}
			
			if (endl_count == 2){
				para_word_count[para_count] = iterate_word_count; //set number of words in paragraph
				iterate_word_count = 0; 						//reset word count
				endl_count = 0; 							//reset new line count
				para_count++; 								//add 1 to number of paragraphs
			}
			
			#if DEBUG
			printf ("%s\n", word);
			#endif
			
			//add word to queue
			enqueue (&word_queue, word, count);
			
			#if DEBUG
			printf ("%s\n", word);
			#endif
			
			for (i = 0; i < 15; ++i)
				word[i] = '\0'; //remove contents for new word to be stored
			
			count = 0; //reset character count
		} else {
			word[count] = c; //puts letter "temporary" storage
			count++;
			endl_count = 0; //reset new line count
		}			
	} while (c != EOF);
	
	fclose(file_pointer);
	
	//iterate until there are no more words
	while (word_queue != NULL){
	
		#if DEBUG
		printf ("Emptying word_queue");
		#endif
		
		#if DEBUG
		printf ("%s\n", word_queue->letters);
		#endif
		
		//iterate through each paragraph
		for (para_num; para_num <= para_count; ++para_num){
		
			#if DEBUG
			printf ("In paragraph loop");
			#endif
			
			//iterate until no words are left in paragraph
			do{
				first = 1;
				line_word_count = count_words_per_line (word_queue, char_per_line, 0);
				char_left = count_chars (word_queue, char_per_line);
				num_spaces = line_word_count / (double) char_left;
				
				//iterate until line is full
				for (j = 0; j < line_word_count; ++j){
					para_word_count[para_num]--;
				
					//if first iteration print word then spaces
					//if not print spaces then word
					if (first){
						dequeue (&word_queue);
						for (i = 0; i < ceil(num_spaces); i++){
							printf (" ");
						}
					} else {
						for (i = 0; i < floor(num_spaces); i++){
							printf (" ");
						}
						dequeue (&word_queue);
					}
				}
				
				//end the line
				printf ("\n");
			} while (para_word_count[para_num] > 0);
			
			//end the paragraph
			printf ("\n\n");
		}
	}
	
	return 0;
}

void enqueue (WORD_QUEUE_POINTER *w_queue, char *word, short length)
{
	WORD_QUEUE_POINTER new_word = malloc (sizeof (WORD));
	
	if (new_word != NULL){
		strcpy(new_word->letters, word);
		new_word->string_length = length;
		new_word->next_word = NULL;
	}
	
	if (w_queue == NULL){
		*w_queue = new_word;
	} else {
		set_next (w_queue, &new_word);
	}
}

void dequeue (WORD_QUEUE_POINTER *word_queue)
{
	WORD_QUEUE_POINTER temp_word = *word_queue;
	*word_queue = (*word_queue)->next_word;
	
	printf("%s", temp_word->letters);
	free (temp_word);
}

short count_words_per_line (WORD *word, short char_limit, short word_count)
{
	if ((word->string_length + 1) > char_limit)
		return word_count;
	else {
		word_count++;
		return count_words_per_line (word->next_word, char_limit - word->string_length, word_count);
	}
}

short count_chars (WORD *word, short char_limit)
{
	if (char_limit < 0)
		return char_limit;
	else {
		char_limit -= (word->string_length + 1);
		return count_chars (word->next_word, char_limit);
	}
}

WORD_QUEUE_POINTER * get_next(WORD_QUEUE_POINTER *curr_word)
{
	return &((*curr_word)->next_word);
}

void set_next(WORD_QUEUE_POINTER *word_queue_item, WORD_QUEUE_POINTER *new_word)
{
	if ((*word_queue_item)->next_word == NULL){
		(*word_queue_item)->next_word = *new_word;
	} else {
		set_next (get_next (word_queue_item), new_word);
	}
}
