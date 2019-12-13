/*
	Author:	Nicholas Wade
	Filename:	Server.java
	Input:	String from client
	Output:	String to client
	Course:	ITCS 3166
	Version:	1.0
	Date:	9-Mar-2016
*/

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Server {
	private static ServerSocket server;
	private static Socket client;
	final static int PORT = 1025;
	
	public static void main(String[] args) {
		try {
			server = new ServerSocket(PORT); //starts server
			client = new Socket(); //client socket
			System.out.println("Server started");
			String temperature; //will hold the value that is sent from client
			
			client = server.accept(); //allows client to connect to server
			System.out.println("Client connected");
			DataInputStream read = new DataInputStream(client.getInputStream()); //input stream
			DataOutputStream write = new DataOutputStream(client.getOutputStream());//output stream
			
			temperature = new String(read.readUTF()); //reads information from client
			System.out.println("Reading data from client");
			String converted_temp = null; //holds the value of the converted temperature
			double temp_value = Double.valueOf(temperature.substring(0, temperature.length() - 1)); //converts string value to double, temp_value holds the new double
		
			switch(temperature.charAt(temperature.length() - 1)) {
				case 'f':
				case 'F':
					//convert if temp is fahrenheit
					System.out.println("converting temperature to Celcius");
					converted_temp = convertFar(temp_value);
					break;
				case 'c':
				case 'C':
					//convert if temp is celcius
					System.out.println("converting temperature to Fahrenheit");
					converted_temp = convertCel(temp_value);
					break;
			}
			
			System.out.println("Sending data to client");
			write.writeUTF(converted_temp); //sends the final value to the client
			System.out.println("Data sent to client");
			
			read.close(); //close input stream
			write.close(); //close output stream
			server.close(); //close server socket
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//converts from Celcius to Fahrenheit
	private static String convertCel(double temp) {
		double converted_temp = (temp * 1.8) + 32.0;
		
		return converted_temp + "F";
	}
	
	//converts from Fahrenheit to Celcius
	private static String convertFar(double temp) {
		double converted_temp = (temp - 32.0) / 1.8;
		
		return converted_temp + "C";
	}
}
