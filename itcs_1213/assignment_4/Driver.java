
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String [] args)
    {
        System.out.println("Everything in the format of DD/MM/YYYY\n"); //shows the format of Dates
        Date D1 = new Date(25, 2, 2016); //starting date
        System.out.println("Original Date: " + D1);
        System.out.print("Adding 10 days: ");
        Date D2 = D1.add(10); //new date with 10 days added to starting
        System.out.print(D2 + "\n"); //prints new Date
        System.out.print("Subtracting 15 days: "); //new date with 15 days subtracted from starting
        Date D3 = D1.subtract(15);
        System.out.print(D3 + "\n"); //prints new date
        Date D4 = D3.add(25);  //new date that is equal to the second, used to test equals method
        
        //compare two dates
        if(D4.compareTo(D1) > 0)
            System.out.println(D4 + " is after " + D1);
        else
            System.out.println(D4 + " is before " + D1);
            
        //see if two dates are equal
        if(D4.equals(D2))
            System.out.println(D4 + " is the same as " + D2);
        else
            System.out.println(D4 + " and " + D2 + " are different");
            
        //display the difference between two dates
        if(D1.difference(D3) > 1 || D1.difference(D3) == 0)
        {
            System.out.println("The difference between " + D1 + " and " + D3 + " is " +
                D1.difference(D3) + " days.");
        }
        else
        {
            System.out.println("The difference between " + D1 + " and " + D3 + " is " +
                D1.difference(D3) + " day.");
        }
    }
}
