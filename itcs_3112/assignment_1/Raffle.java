/**
	This is the class for the driver. The majority of the code is run from here.

	@author Nicholas Wade (nwade3)
	@version 1.0 (23-1-2017)
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.StringBuffer;

public class Raffle {
	/**
		Main method. Deals with user interactions

		@version 1.0
		@param args array of strings at command line (not used)
		@return none
		@since 0.1
	*/
	public static void main (String [] args) {
		// Get input from the keyboard
		Scanner $kb = new Scanner (System.in);

		//holds winning number
		String $winning_number;
		
		//holds ticket holders name
		String $name;
		
		//holds ticets number
		String $ticket_number;
		
		//used for validation
		boolean $valid = true;
		
		//holds first place winners
		ArrayList <Ticket> $1st_winners = new ArrayList <Ticket> ();
		
		//holds second place winners
		ArrayList <Ticket> $2nd_winners = new ArrayList <Ticket> ();
		
		//holds third place winners
		ArrayList <Ticket> $3rd_winners = new ArrayList <Ticket> ();
		
		//holds users selection
		int $choice = 0;

		//get winning ticket number and validate length
		do {
			System.out.println ("What is the winning raffle number?");
			$winning_number = $kb.nextLine ();

			if ($winning_number.length () != 6) {
				System.out.println ("Ticket number is invalid. Ticket number must be 6 characters long");
				$valid = false;
			} else {
				$valid = true;
			}
		} while (!$valid);

		while ($choice != 2) {
			//print choices for the user
			print_options ();

			//take in the choice of the user
			try {
				$choice = $kb.nextInt ();
			} catch (Exception $e) {
				$choice = 0;
			}
			
			//clear buffer
			$kb.nextLine ();
			
			$valid = true;

			//handle the choice of the user
			switch ($choice) {
				case 1:
					//get the name of the ticket holder
					System.out.println ("What is the ticket holder's name?");
					$name = $kb.nextLine ();

					//get the ticket number and validation on length
					do {
						System.out.println ("What is the ticket number?");
						$ticket_number = $kb.nextLine ();

						if ($ticket_number.length () != 6) {
							System.out.println ("Ticket number is invalid. Ticket number must be 6 characters long");
							$valid = false;
						}
					} while ($ticket_number.length () != 6);

					//create a new ticket
					Ticket $ticket = new Ticket ($name, $ticket_number);
					
					//check if win then add to appropriate linked list
					if (is_winner ($ticket, $winning_number))
						$1st_winners.add ($ticket);
					else if (is_2nd ($ticket, $winning_number))
						$2nd_winners.add ($ticket);
					else if (is_3rd ($ticket, $winning_number))
						$3rd_winners.add ($ticket);

					break;
				case 2:
					continue;
				default:
					System.out.println ("Invalid choice. Please try again.");
			}
		}
		
		System.out.println ("1st place winners:");

		for (int $i = 0; $i < $1st_winners.size (); ++$i) {
			System.out.println ($1st_winners.get ($i).get_name ());
		}

		System.out.print ("\n");
		
		System.out.println ("2nd place winners:");
		
		for (int $i = 0; $i < $2nd_winners.size (); ++$i) {
			System.out.println ($2nd_winners.get ($i).get_name ());
		}

		System.out.print ("\n");
		
		System.out.println ("3rd place winners:");
		
		for (int $i = 0; $i < $3rd_winners.size (); ++$i) {
			System.out.println ($3rd_winners.get ($i).get_name ());
		}
		
		System.out.print ("\n");
	}

	/**
		This method prints the possible choices for the user

		@version 1.0
		@returns none
		@since 0.2
	*/
	private static void print_options () {
		System.out.println ("Choose one:");
		System.out.println ("1. Enter new ticket");
		System.out.println ("2. Quit");
	}

	/**
		This method checks to see if the ticket holder is a winner.

		@version 1.0
		@returns true if the ticket is a winner, false otherwise
		@since 0.3
	*/
	private static boolean is_winner (Ticket $ticket, String $winning_number) {
		return $winning_number.equals ($ticket.get_number ());
	}

	/**
		This method checks to see if the ticket holder is a 2nd place winner.

		@version 1.0
		@returns true if the ticket wins 2nd place, false otherwise
		@since 0.3
	*/
	private static boolean is_2nd (Ticket $ticket, String $winning_number) {
		String $reversed = new StringBuffer ($winning_number).reverse ().toString ();

		return $reversed.equals ($ticket.get_number ());
	}
	
	/**
		This method checks to see if the ticket holder is a 3rd place winner.

		@version 1.0
		@returns true if the ticket wins 3rd place, false otherwise
		@since 0.4
	*/
	private static boolean is_3rd (Ticket $ticket, String $winning_number) {
		String $ticket_number = $ticket.get_number ();
		
		String $winning_consecutives[] = {
			$winning_number.substring (0, 2),
			$winning_number.substring (1, 3),
			$winning_number.substring (2, 4),
			$winning_number.substring (3, 5)
		};
		
		String $ticket_consecutives[] = {
			$ticket_number.substring (0, 2),
			$ticket_number.substring (1, 3),
			$ticket_number.substring (2, 4),
			$ticket_number.substring (3, 5)
		};
		
		boolean $matched = false;
		
		for (int $i = 0; $i < 4; ++$i) {
			for (int $j = 0; $j < 4; ++$j) {
				if ($winning_consecutives[$i].equals ($ticket_consecutives[$j])) {
					$matched = true;
				}
			}
		}
		
		return $matched;
	}
}
