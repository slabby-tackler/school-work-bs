/*
	Author:   Nicholas Wade
	Filename: Client.java
	Input:    choice of hit or stand by user, card and other player score from server
	Output:   sending descision to server, printing players score, printing if the player one or loss
	Course:   ITCS 3166
	Version:  2.5
	Date:     28-Apr-2016
*/

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class Client {
	private static Socket client;
	final static int PORT = 1025;
	final static String IP = "localhost";
	
	public static void main(String[] args) {
		try {
			client = new Socket(IP, PORT);
			
			System.out.println("connected to server");
			
			//read and write streams
			DataOutputStream write = new DataOutputStream(client.getOutputStream());
			DataInputStream read = new DataInputStream(client.getInputStream());
			
			//prints which player the user is
			System.out.println(read.readUTF());
			
			boolean winner = false; //keeps track if there is a winner
			boolean my_turn = false; //keeps track of players turn
			boolean stand = false; //keeps track when player stands
			int choice = 0; //holds choice of the user
			int score = 0; //holds score of the user
			
			System.out.println("getting cards from server");
			
			//accept 2 cards from the server and add to score
			score += calcCard(read.readInt());
			score += calcCard(read.readInt());
			
			//display initial score
			System.out.println("Score after initial draw: " + score);
			
			//check server for turn
			my_turn = read.readBoolean();
			
			//play game
			while(!winner) {
				if(!stand) {
					//display waiting message when other players turn
					if(!my_turn) System.out.println("Waiting for other player");
				
					//wait until the players turn
					while(!my_turn) my_turn = read.readBoolean();
					
					//tell player if other busted
					winner = read.readBoolean();
					
					//break if bust; user does not get a turn
					if(winner) {
						my_turn = false;	
						break;
					}
					
					//display current score, get choice, and send to server
					System.out.println("Current score: " + score);
					choice = getChoice();
					write.writeInt(choice);
				
					//handle choice
					if(choice == 2) {
						stand = true;
						my_turn = false;
					} else {
						score += calcCard(read.readInt());
					
						//check if the player busted
						if(score > 21) {
							winner = true;
						}
					}
				
					//inform server status of a winner
					write.writeBoolean(winner);
					
					//end turn
					my_turn = false;
				} else break; //player can no longer take a turn when they stand
			}
			
			//end game waiting message
			if(stand) System.out.println("Waiting for other player");
			else System.out.println("Waiting for server");
			
			//wait for other player or server to catch up
			while(!my_turn) my_turn = read.readBoolean();
			
			//send score to server
			write.writeInt(score);
			
			//print final score, other players score, and outcome of deal
			System.out.println("Final Score: " + score);
			System.out.println("Other player's score: " + read.readInt());
			System.out.println(read.readUTF());
			
			//close read and write stream
			write.close();
			read.close();
			
			//close socket
			client.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
		prompts the user to enter choice
		returns validated choice of user
	*/
	private static int getChoice() {
		boolean valid = false; //used to keep asking for valid input
		int choice = 0; //holds users choice
		Scanner keyboard = new Scanner(System.in); //accepts input from user from use of keyboard
		
		//get choice and validate
		while(!valid) {
			printChoices();
			choice = keyboard.nextInt();
			
			valid = (choice == 1 || choice == 2);
			
			//print not valid message
			if(!valid) System.out.println("Selection is not valid");
		}
		
		return choice;
	}
	
	/*
		prints what the user can choose from
	*/
	private static void printChoices() {
		System.out.print("Pick one.\n1. Hit\n2. Stand\n");
	}
	
	/*
		returns the value of the card drawn
	*/
	private static int calcCard(int card) {
		return (card > 10) ? 10 : card;
	}
}
