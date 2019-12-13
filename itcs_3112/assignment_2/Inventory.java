import java.util.HashMap;

/**
	@author Nicholas Wade
	@version 1.0 (13-2-2017)
*/
public class Inventory {
	//holds name of city
	private String name;
	
	//holds value for each part
	private HashMap <String, Integer> inventory;
	
	/**
		default constructor method
		
		@param none
		@return none
	*/
	public Inventory () {
		name = "Foo Bar";
		inventory = new HashMap <String, Integer> ();
	}
	
	/**
		constructor method
		
		@param n name of city
		@return none
	*/
	public Inventory (String n) {
		name = n;
		inventory = new HashMap <String, Integer> ();
	}
	
	/**
		sets inventory items
		
		@param item part to be set
		@param quantity new value for specific part
		@retrun none
	*/
	public void set_item (String item, int quantity) {
		inventory.put (item, new Integer (quantity));
	}
	
	/**
		gets the amount for a particular part
		
		@param item part to be retrieved
		@retrun quantity of the part
	*/
	public int get_item (String item) {
		return inventory.get (item).intValue ();
	}
	
	/**
		gives the name
		
		@param none
		@return name name from the object
	*/
	public String get_name () {
		return name;
	}
	
	/**
		increases the amount of an inventory item
		
		@param item part number
		@param change the change in inventory
		@return new_value the new inventory value
	*/
	public int increase_inventory (String item, int change) {
		int current = inventory.get (item).intValue ();
		int new_value = current + change;
		
		inventory.put (item, new Integer (new_value));
		
		return new_value;
	
	}
	
	/**
		decreases the amount of an inventory item
		
		@param item part number
		@param change the change in inventory
		@return new_value the new inventory value
	*/
	public int decrease_inventory (String item, int change) {
		int current = inventory.get (item).intValue ();
		int new_value = current - change;
		
		inventory.put (item, new Integer (new_value));
		
		return new_value;
	}
	
	/**
		formatted string for writing to the inventory file
		
		@param none
		@param none
	*/
	public String file_write () {
		return inventory.get ("102") + ", " + inventory.get ("215") + ", " + inventory.get ("410") + ", " + inventory.get ("525") + ", " + inventory.get ("711");
	}
	
	/**
		used for testing; simple to string method to see values
		
		@param none
		@return none
	*/
	public String toString () {
		return name + "[102:" + inventory.get ("102") + ",215:" + inventory.get ("215") + ",410:" + inventory.get ("410") + ",525:" + inventory.get ("525") + ",711:" + inventory.get ("711") + "]";
	}
}
