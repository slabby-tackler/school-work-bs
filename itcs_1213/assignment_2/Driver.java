import java.util.*;
/**
 * The driver runs this program. It asks the user for an item price and amount paid.
 * after a few simple calculations and displaying a bit of information, it asks the 
 * user if they want to change anything
 * 
 * @author Nicholas Wade
 * @version 1.0 (24 February 2014)
 */
public class Driver
{
   public static void main(String [] args)
   {
       SaleItem si = new SaleItem();
       Scanner input = new Scanner(System.in);
       double itemPrice;
       double tender;
       double discount;
       int type1 = 1;
       int type2;
       
       //to get the item price from the user       
       System.out.println("What is the price of the item? ");
       itemPrice = input.nextDouble();
       
       //to get how much they are paying
       System.out.println("How much cash are you paying with? ");
       tender = input.nextDouble();
             
       //changes the price and tender for the user
       si.setPrice(itemPrice);
       si.setTender(tender);
       
       //calculate the final price and change due using the item price, discount, and
       //sales tax
       si.calcDiscountPrice();
       si.calcFinalPrice();
       si.calcChange();
       
       //displays the information
       System.out.print("Original Price: " + itemPrice
        + "\nDiscount: " + si.getDiscount() + "\nTotal: " + si.getTotal() +
        "\nChange: " + si.getChange());
            
      
       //continues to run program until the user wants to stop 
       while (type1 == 1)
       {     
           System.out.println("\nDo you want to change the discount and/or item price?");
           System.out.println("1. Yes");
           System.out.println("2. No ");
           type2 = input.nextInt();
           
           
           switch(type2)
           {
               //if the user wnats to change anything
               case 1:
               System.out.print("Item Price: ");
               itemPrice = input.nextDouble();
               System.out.print("Discount: ");
               discount = input.nextDouble();
               System.out.print("Cash Paid: ");
               tender = input.nextDouble();
               
               si.setPrice(itemPrice);
               si.setDiscount(discount);
               si.setTender(tender);
               
               si.calcDiscountPrice();
               si.calcFinalPrice();
               si.calcChange();
           
               System.out.print("Original Price: " + itemPrice
                + "\nDiscount: " + si.getDiscount() + "\nTotal: " + si.getTotal() + 
                "\nChange: " + si.getChange());
               break;
               
               //verifies the user wants to quit
               case 2:
               System.out.print("\nAre you sure you want to quit?\n1. no\n2. yes");
               type1 = input.nextInt();
               break;
               
               //asks the user if they want to quit for entering a wrong
               //value
               default:
               System.out.print("Do you want to quit?\n1. no\n2. yes");
               type1 = input.nextInt();
            }
        }
    }
           
}
