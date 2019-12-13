/**
	@author Nicholas Wade (nwade3)
	@version 1.0 (12-2-2017)
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;


public class Warehouses {
	/**
		Main method
		
		@version 1.0
		@param args array of strings at command line (not used)
		@return none	
	*/
	public static void main (String [] args) throws IOException {
		//file names
		String inventory_file = "Inventory.txt";
		String transaction_file = "Transactions.txt";
		
		//used for file input
		String input_string;

		//scanners to get information from both files
		Scanner inventory_input = new Scanner (new File (inventory_file));
		Scanner transaction_input = new Scanner (new File (transaction_file));

		//holds all inventory locations
		ArrayList <Inventory> inventory_list = new ArrayList <Inventory> ();

		//values for indexing
		int count = 0;
		int most = 0;
		int least = 0;

		//use for initially setting the inventory
		Inventory inventory;

		// create cities and add them to the list
		inventory_list.add (new Inventory ("Atlanta"));
		inventory_list.add (new Inventory ("Baltimore"));
		inventory_list.add (new Inventory ("Chicago"));
		inventory_list.add (new Inventory ("Denver"));
		inventory_list.add (new Inventory ("Ely"));
		inventory_list.add (new Inventory ("Fargo"));

		//get inventory from file, set inventory values
		while (inventory_input.hasNext ()) {
			input_string = new String (inventory_input.nextLine ());
			String [] split_input = input_string.split (", ");

			inventory = inventory_list.get (count);

			inventory.set_item ("102", Integer.parseInt (split_input [0]));
			inventory.set_item ("215", Integer.parseInt (split_input [1]));
			inventory.set_item ("410", Integer.parseInt (split_input [2]));
			inventory.set_item ("525", Integer.parseInt (split_input [3]));
			inventory.set_item ("711", Integer.parseInt (split_input [4]));

			++count;
		}
		
		inventory_input.close ();

		//iterate through each line of the transaction file
		while (transaction_input.hasNext ()) {
			input_string = new String (transaction_input.nextLine ());
			String [] split_input = input_string.split (", ");
			
			//subtract if sale, add if purchase, print what happend
			if (split_input [0].equals ("P")) {
				for (int i = 1; i < 6; ++i) {
					if (inventory_list.get (least).get_item (split_input [1]) > inventory_list.get (i).get_item (split_input [1])) {
						least = i;
					}
				}
				
				System.out.println (inventory_list.get (least).get_name () + ": part " + split_input [1] + " has increased to " + inventory_list.get (least).increase_inventory (split_input [1], Integer.parseInt(split_input [2]))); 
			} else if (split_input [0].equals ("S")) {
				for (int i = 1; i < 6; ++i) {
					if (inventory_list.get (most).get_item (split_input [1]) < inventory_list.get (i).get_item (split_input [1])) {
						most = i;
					}
				}
				
				System.out.println (inventory_list.get (most).get_name () + ": part " + split_input [1] + " has increased to " + inventory_list.get (most).decrease_inventory (split_input [1], Integer.parseInt(split_input [2]))); 
			}
			
			most = 0;
			least = 0;
		}
		
		transaction_input.close ();
		
		File inventory_output = new File (inventory_file);
		PrintWriter inventory_writer = new PrintWriter (inventory_output);
		
		//write values to file
		for (int i = 0; i < 6; ++i) {
			inventory_writer.println(inventory_list.get (i).file_write ());
		}
		
		inventory_writer.close ();
	}
}
