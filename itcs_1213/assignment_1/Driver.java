
/**
 * Collects the number of dollars (US) the user wants to converts and gathers what
 * currency the user wants them converted to
 * 
 * @author Nicholas Wade 
 * @version 1.0 (30 January 2014)
 */

import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        CurrencyConverter cc;
        
        double amount; //hold the amount the user wants converter in (USD)
        char type;// type of currency to be converted
        int choice; //holds user's choice
        Scanner input;
        
        input = new Scanner(System.in);
        
        System.out.print("How many US Dollars would you like to convert: ");
        amount = input.nextDouble();
        
        System.out.print("What currency would you like them converted to: Euro (1), \nBritish Pound (2), or Yen (3): ");
        choice = input.nextInt();
        
        if (choice == 1)
            type = 'E';
        else if (choice == 2)
            type = 'P';
        else if (choice == 3)
            type = 'Y';
        else
            type = 'q';
        
        cc = new CurrencyConverter(amount, type);
        
        System.out.println("That is worth " + cc.getConversion() + " in the currency you have chosen");
    }
}
