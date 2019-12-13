
/**
 * This class is used to hold and calculate the values of different types of
 * currency in relation to 1 US dollar (USD).
 * 
 * @author Nicholas Wade 
 * @version 1.0 (30 January 2014)
 */
public class CurrencyConverter
{
    //different currency's and their worth compared to 1 USD
    private final double EURO = .7311;
    private final double BRITISH_POUND = .6064;
    private final double YEN = 102.32;
    private double usDollars; //will hold the amount of USD that the user wants
                              //to convert
    private char whichCurrency; //will hold the currency that user wants
    private double conversion; //holds the converted value
    
    public CurrencyConverter (double amtUSD, char currency)
    {
        usDollars = amtUSD;
        whichCurrency = currency;
        
        if (whichCurrency == 'E' || whichCurrency == 'e')
            conversion = usDollars * EURO;
        else if (whichCurrency == 'P' || whichCurrency == 'p')
            conversion = usDollars * BRITISH_POUND;
        else if(whichCurrency == 'Y' || whichCurrency == 'y')
            conversion = usDollars * YEN;
        else
        {    
            System.out.println("I am unaware of the currency you want. Goodbye");
            conversion = 0;
        }
    }
    
    public double getConversion()
    {
        return conversion;
    }
}
