/*
	Author:   Nicholas Wade
	Filename: Server.java
	Input:    String from client
	Output:   String to client
	Course:   ITCS 3166
	Version:  2.5
	Date:     28-Apr-2016
*/

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;

public class Server {
	private static ServerSocket server;
	private static Socket player_1;
	private static Socket player_2;
	final static int PORT = 1025;
	
	public static void main(String[] args) {
		try {
			server = new ServerSocket(PORT); //starts server
			player_1 = new Socket(); //player 1 socket
			player_2 = new Socket(); //player 2 socket
			
			//boolean type variables
			boolean player_1_stand = false;
			boolean player_2_stand = false;
			boolean winner = false; //holds if a winner is determined
			
			//integer type variables
			int player_choice = 0;
			int player_1_score = 0;
			int player_2_score = 0;
			
			//string type variables
			String end_msg = ""; //message to be printed at end (tells player who won)
			
			System.out.println("Server Started");
			
			//accept player connection
			player_1 = server.accept();
			System.out.println("Player 1 Connected");
			player_2 = server.accept();
			System.out.println("Player 2 Connected");
			
			//player input and output stream
			DataInputStream player_1_read = new DataInputStream(player_1.getInputStream());
			DataOutputStream player_1_write = new DataOutputStream(player_1.getOutputStream());
			DataInputStream player_2_read = new DataInputStream(player_2.getInputStream());
			DataOutputStream player_2_write = new DataOutputStream(player_2.getOutputStream());
			
			//tell player which they are
			player_1_write.writeUTF("You are player 1");
			player_2_write.writeUTF("You are player 2");
			
			//deal initial cards
			player_1_write.writeInt(drawCard());
			player_2_write.writeInt(drawCard());
			player_1_write.writeInt(drawCard());
			player_2_write.writeInt(drawCard());
			
			//inform player of turn
			player_1_write.writeBoolean(true);
			player_2_write.writeBoolean(false);
			
			//tell player there is no winner
			player_1_write.writeBoolean(winner);
			
			//play game
			while(!winner) {
				//player 1 goes if they have not stood
				if(!player_1_stand) {
					//get player's choice
					player_choice = player_1_read.readInt();
					
					//handle player's choice
					if(player_choice == 2) {
						System.out.println("Player 1 chose to stand");
						player_1_stand = true;
					} else {
						System.out.println("Player 1 chose to hit");
						player_1_write.writeInt(drawCard());
					}
				
					//check for winner, set win message
					winner = player_1_read.readBoolean();
					if(winner) end_msg = "Player 2 wins";
				}
				
				//tell player 2 if they are allowed to proceed
				if(player_2_stand) player_2_write.writeBoolean(false); 
				else player_2_write.writeBoolean(true);
				
				//tell player if there is a winner if they have not chosen to stand
				if(!player_2_stand) player_2_write.writeBoolean(winner);
				
				//end game if winner is declared
				if(winner) break;
				
				//player 2 goes if they have chosen to stand
				if(!player_2_stand) {
					//get players choice
					player_choice = player_2_read.readInt();
					
					//handle player's choice
					if(player_choice == 2) {
						System.out.println("Player 2 chose to stand");
						player_2_stand = true;
					} else {
						System.out.println("Player 2 chose to hit");
						player_2_write.writeInt(drawCard());
					}
					
					//check for winner, set win message
					winner = player_2_read.readBoolean();
					if(winner) end_msg = "Player 1 wins";
				}
				
				//tell player 1 if they are allowed to proceed
				if(player_1_stand) player_1_write.writeBoolean(false); 
				else player_1_write.writeBoolean(true);
				
				//tell player if there is a winner if they have not chosen to stand
				if(!player_1_stand) player_1_write.writeBoolean(winner);
				
				//end game if winner is declared
				if(winner) break;
				
				//end game if both players stand
				if(player_1_stand && player_2_stand) break;
			}
			
			//tell both players to display end game details
			player_1_write.writeBoolean(true);
			player_2_write.writeBoolean(true);
			
			//accept player scores
			player_1_score = player_1_read.readInt();
			player_2_score = player_2_read.readInt();
			
			//send opposite player scores
			player_1_write.writeInt(player_2_score);
			player_2_write.writeInt(player_1_score);
			
			//determine winner if both stand
			if(player_1_stand && player_2_stand) {
				if(player_1_score > player_2_score)
					end_msg = "Player 1 wins";
				else if(player_1_score == player_2_score)
					end_msg = "draw";
				else
					end_msg = "Player 2 wins";
			}
			
			//send end game messsage
			player_1_write.writeUTF(end_msg);
			player_2_write.writeUTF(end_msg);
			
			//close input and output streams
			player_1_write.close();
			player_1_read.close();
			player_2_write.close();
			player_2_read.close();
			
			//close server socket
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
		returns a number between 1 and 13
	*/
	private static int drawCard() {
		Random r = new Random();
			
		return r.nextInt(13) + 1;
	}
}
