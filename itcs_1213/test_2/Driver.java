import java.util.*;
/**
 * The Driver class runs the program and contains main
 * 
 * Lab Section 3
 * 
 * @author Nicholas Wade 
 * @version 1.0 (11 March 2014)
 */
public class Driver
{
    public static void main(String [] args)
    {
        String userInput; //string that the user enters
        Scanner keyboard = new Scanner(System.in);
        char choice; //user's choice to continue
        Converter con;
        
        
        do
        {
            System.out.println("Enter a some words to change");
            userInput = keyboard.nextLine();
            
            con = new Converter(userInput);
            con.convert();
            
            System.out.println(con.toString());
            System.out.println("There were " + con.getCount() + " changes\n");
            
            System.out.println("Do you want to enter anything else? (y or n)");
            choice = keyboard.nextLine().charAt(0);
            
        }
        while(choice == 'y' || choice == 'Y');    
    }
}
