/**
	This is the class for tickets. Used to create and edit information about tickets

	@author Nicholas Wade (nwade3)
	@version 1.0 (23-1-2017)
*/

public class Ticket {

	private String $name;
	private String $ticket_number;
	
	/**
		Default constructor method. Will only be called if something bad happens

		@version 1.0
		@param none
		@return none
		@since 0.1
	*/
	public Ticket () {
		$name = "Foo Bar";
		$ticket_number = "000000";
	}
	
	/**
		Constructor method. Sets name and ticket number to correct values.
		
		@version 1.0
		@param $name ticket holders name
		@param $ticket_number ticket number this individual has
		@return none
		@since 1.0
	*/
	public Ticket (String $name, String $ticket_number) {
		this.$name = $name;
		this.$ticket_number = $ticket_number;
	}
	
	/**
		Function to return the name of the ticket holder
		
		@version 1.0
		@return name of the ticket holder
		@since 1.0
	*/
	public String get_name () {
		return $name;
	}
	
	/**
		Function to return the number of the ticket
		
		@version 1.0
		@return number of the ticket
		@since 1.0
	*/
	public String get_number () {
		return $ticket_number;
	}
}
