
/**
 * This class creates the object for the item that is being sold.
 * 
 * @author Nicholas Wade 
 * @version 1.0 (24 February 2014)
 */
public class SaleItem
{
   private double priceOfItem;
   private double discountPercent;
   private double taxRate;
   private double subTotal;
   private double total;
   private double cashTender;
   private double change;
   
   public SaleItem()
   {
       discountPercent = .10;
       taxRate = .075;
       priceOfItem = 0.00;
    
   }
    
  /**
   * This method creates an object while taking in 3 parameters
   * 
   * @param inPrice price given by the user
   * @param inTax tax rate given by the user
   * @param inDiscount discount rate given by the user
   */
   public SaleItem(double inPrice, double inTax, double inDiscount)
   {
       discountPercent = inDiscount;
       taxRate = inTax;
       priceOfItem = inPrice;
       
   }
   
   /**
    * to change the price
    */
   void setPrice(double inPrice)
   {
       priceOfItem = inPrice;
    }
   
    /**
    * to change the discount
    */
   void setDiscount(double inDiscount)
   {
       discountPercent = inDiscount;
    }
   
    /**
    * to change the tax rate
    */
   void setTaxRate(double inTax)
   {
       taxRate = inTax;
    }
    
    /**
    * to change the amount the user pays
    */
   void setTender(double inTender)
   {
       cashTender = inTender;
    }
    
   /**
    * this method calculates the subtotal
    */
    double calcDiscountPrice()
   {
       subTotal = priceOfItem + (discountPercent * priceOfItem);
       return subTotal;
    }
    
   /**
    * this method calculates the final price
    */
   public double calcFinalPrice()
   {
       total = subTotal + (subTotal * taxRate);
       return total;
    }
    
   /**
    * This method calculates the the change due to the user
    */
    public double calcChange()
   {
       change = cashTender - total;
       return change;
    }
   
   /**
    * This method returns the final total
    * 
    * @return discountPercent
    */ 
   public double getTotal()
   {
       return total;
    }
   
    /**
    * This method returns the change due back to the user
    * 
    * @return change
    */
   public double getChange()
   {
       return change;
    }
    
   /**
    * This method returns the discount amount
    * 
    * @return discountPercent
    */ 
   public double getDiscount()
   {
       return discountPercent;
    }   
}
