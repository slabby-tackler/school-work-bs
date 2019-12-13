/*
	Author:	Nicholas Wade
	Filename:	Client.java
	Input:	temperature from user to be converted, converted temperature from server
	Output:	sending temperature to server, printing the converted temperature
	Course:	ITCS 3166
	Version:	1.0
	Date:	9-Mar-2016
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
			
			DataOutputStream write = new DataOutputStream(client.getOutputStream());
			DataInputStream read = new DataInputStream(client.getInputStream());
			
			boolean valid = false; //used to keep asking for valid input
			Scanner keyboard = new Scanner(System.in); //accept input from user from use of keyboard
			String user_input = null; //will hold what the user types in
			float value_test; //used to check if a value can be converted into a float
		
			while(!valid) {
				//ask the user for input
				System.out.println("Enter a temperature you want converted.");
				user_input = keyboard.nextLine();
			
				//check the trailing character; if match string has potential to be valid
				switch(user_input.charAt(user_input.length() - 1)) {
					case 'c':
					case 'f':
					case 'F':
					case 'C':
						valid = true;
						break;
					default:
						valid = false;
				}
				
				//an exception thrown here tells if everything in front of the last character can be converted in to a floating point number.
				try {				
					value_test = Float.valueOf(user_input.substring(0, user_input.length() - 1));
				} catch(Exception e) {
					valid = false;
				}
				if(!valid) {
					//tell the user that the input is not valid
					System.out.print("What you entered is not valid. ");
				}
			}
			
			System.out.println("Sending information to server");
			write.writeUTF(user_input); //send the information to the server
			System.out.println("Information sent waiting for response");
			System.out.println("That is " + read.readUTF() + "."); //read and output the final value

			write.close();
			read.close();
			client.close(); //close the client socket
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
