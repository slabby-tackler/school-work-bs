
/**
 * Write a description of class Date here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Date
{
    private int day;
    private int month;
    private int year;
    
    //Default Constructor
    public Date()
    {
        day = 1;
        month = 1;
        year = 2000;
    }
    
    /**
     * Constructor
     * 
     * @param inDay day given
     * @param inMonth month given
     * @param inYear year given
     */
    public Date(int inDay, int inMonth, int inYear)
    {
        day = inDay;
        month = inMonth;
        year = inYear;
    }
    
    /**
     * copy Constructor
     * 
     * @param other Date to be copied
     */
    public Date(Date other)
    {
        day = other.day;
        month = other.month;
        year = other.year;
    }
    
    /**
     * toString Method
     * 
     * @return String Gives date format of day/month/year
     */
    public String toString()
    {
        return day + "/" + month + "/" + year;
    }
    
    /**
     * equals method
     * determines if two dates are the same
     * 
     * @param Date second date to determine equality
     * @return boolean Determines if the two dates are the same date
     */
    public boolean equals(Date other)
    {
        if(day == other.day && month == other.month && year == other.year)
            return true;
        else
            return false;
    }
    
    /**
     * compareTo method
     * compares two dates
     * 
     * @param Date a date to compare to
     * @return int positive will be after, 0 is the same, negative is before
     */
    public int compareTo(Date other)
    {
        if (day > other.day && month > other.month && year > other.year)
            return -1;
        else if (day == other.day && month == other.month && year == other.year)
            return 0;
        else
            return 1;
    }
    
    /**
     * add method
     * adds a number of days to a date
     * 
     * @param numDays number of days to add to a Date
     * @return Date a new Date
     */
    public Date add(int numDays)
    {
         int newDay = 0;
         int newMonth = month;
         int newYear = 0;
         boolean nextCase = true; //used to determine if a case was traversed
                
         //"do-while" to traverse years 
         do
         {
            //to start at any month
             switch(month)
            {
                case 1:
                    if(nextCase)
                        newDay = day + numDays;
                    if(newDay > 31)
                    {
                        newDay -= 31;
                        newMonth++;
                        nextCase = false;
                    }
                    //used for leap years
                    if((year % 4) == 0)
                    {
                        if(newDay < 29)
                            break;
                    }
                    if(newDay < 28)
                        break;
                case 2:
                    if(nextCase)
                        newDay = day + numDays;
                    //used in case of leap year
                    if((year % 4) == 0)
                    {
                        if (newDay > 29)
                        {
                            newDay -= 29;
                            newMonth++;
                            nextCase = false;
                        }
                        if(newDay < 30)
                            break;
                    }
                    if (newDay > 28)
                    {
                            newDay -= 28;
                            newMonth++;
                            nextCase = false;
                    }
                    if (newDay < 30)
                        break;
                case 3:
                    if(nextCase)
                        newDay = day + numDays;
                    if(newDay > 31)
                    {
                        newDay -= 31;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 30)
                        break;
                case 4:
                    if(nextCase)
                        newDay = day + numDays;
                    if (newDay > 30)
                    {
                        newDay -= 30;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 31)
                        break;
                case 5:
                    if(nextCase)
                        newDay = day + numDays;
                    if(newDay > 31)
                    {
                        newDay -= 31;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 30)
                        break;
                case 6:
                    if(nextCase)
                        newDay = day + numDays;
                    if (newDay > 30)
                    {
                        newDay -= 30;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 31)
                        break;
                case 7:
                    if(nextCase)
                        newDay = day + numDays;
                    if(newDay > 31)
                    {
                        newDay -= 31;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 30)
                        break;
                case 8:
                    if(nextCase)
                        newDay = day + numDays;
                    if(newDay > 31)
                    {
                        newDay -= 31;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 30)
                        break;
                case 9:
                    if(nextCase)
                        newDay = day + numDays;
                    if (newDay > 30)
                    {
                        newDay -= 30;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 31)
                        break;
                case 10:
                    if(nextCase)
                        newDay = day + numDays;
                    if(newDay > 31)
                    {
                        newDay -= 31;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 30)
                        break;
                case 11:
                    if(nextCase)
                        newDay = day + numDays;
                    if (newDay > 30)
                    {
                        newDay -= 30;
                        newMonth++;
                        nextCase = false;
                    }
                    if(newDay < 31)
                        break;
                case 12:
                    if(nextCase)
                        newDay = day + numDays;
                    if (newDay > 31)
                    {
                        newDay -= 31;
                        newMonth = month - 11;
                        newYear++;
                        nextCase = false;
                    }
                    break;
            }
         }while(newDay > 31);
         
         if(!nextCase)
            return new Date(newDay, (newMonth), (newYear + year));
         else
            return new Date(newDay, month, year);
    }
    
    /**
     * subtract method
     * subtracts a number of days from a date
     * 
     * @param numDays number of days to subtract from a Date
     * @return Date a new Date
     */
    public Date subtract(int numDays)
    {
         int newDay = 0;
         int newMonth = 0;
         int newYear = 0;
         boolean nextCase = true; //used to determine if a case was traversed
                
         //"do-while" used to traverse years
         do
         {
            //used to start at any month
             switch(month)
            {
                case 1:
                    if(nextCase)
                        newDay = day - numDays;
                    if(newDay < 1)
                    {
                        newDay += 31;
                        newMonth += 12;
                        newYear--;
                        nextCase = false;
                    }
                case 2:
                    if(nextCase)
                        newDay = day - numDays;
                    if(newDay < 1)
                    {
                        newDay += 31;
                        newMonth--;
                        nextCase = false;
                    }
                case 3:
                    if(nextCase)
                        newDay = day - numDays;
                    if(newDay < 1)
                    {
                        //used for leap year
                        if((year % 4) == 0)
                        {
                            newDay += 29;
                            newMonth--;
                            nextCase = false;
                        }
                        else
                        {
                            newDay += 28;
                            newMonth--;
                            nextCase = false;
                        }
                    }
                    if(newDay > 0 && newDay < 30)
                        break;
                case 4:
                    if(nextCase)
                        newDay = day - numDays;
                    if (newDay < 1)
                    {
                        newDay += 31;
                        newMonth--;
                        nextCase = false;
                    }
                    if(newDay < 31 && newDay > 0)
                        break;
                case 5:
                    if(nextCase)
                        newDay = day - numDays;
                    if(newDay < 1)
                    {
                        newDay += 30;
                        newMonth--;
                        nextCase = false;
                    }
                    if(newDay < 32 && newDay > 0)
                        break;
                case 6:
                    if(nextCase)
                        newDay = day - numDays;
                    if (newDay < 1)
                    {
                        newDay += 31;
                        newMonth--;
                        nextCase = false;
                    }
                    if(newDay < 31 && newDay > 0)
                        break;
                case 7:
                    if(nextCase)
                        newDay = day - numDays;
                    if(newDay < 1)
                    {
                        newDay += 30;
                        newMonth--;
                        nextCase = false;
                    }
                    if(newDay < 32 && newDay > 0)
                        break;
                case 8:
                    if(nextCase)
                        newDay = day - numDays;
                    if(newDay < 1)
                    {
                        newDay += 31;
                        newMonth--;
                        nextCase = false;
                    }
                    if(newDay < 32 && newDay > 0)
                        break;
                case 9:
                    if(nextCase)
                        newDay = day - numDays;
                    if (newDay < 1)
                    {
                        newDay += 31;
                        newMonth--;
                        nextCase = false;
                    }
                    if(newDay < 31 && newDay > 0)
                        break;
                case 10:
                    if(nextCase)
                        newDay = day - numDays;
                    if(newDay < 1)
                    {
                        newDay += 30;
                        newMonth--;
                        nextCase = false;
                    }
                    if(newDay < 30 && newDay > 0)
                        break;
                case 11:
                    if(nextCase)
                        newDay = day - numDays;
                    if (newDay < 1)
                    {
                        newDay += 31;
                        newMonth--;
                        nextCase = false;
                    }
                    if(newDay < 31 && newDay > 0)
                        break;
                case 12:
                    if(nextCase)
                        newDay = day - numDays;
                    if (newDay < 1)
                    {
                        newDay += 30;
                        newMonth--;
                        nextCase = false;
                    }
                    break;
            }
         }while(newDay < 1);
         
         if(!nextCase)
            return new Date(newDay, (newMonth - 1), (year + newYear));
         else
            return new Date(newDay, month, year);
    }
    
    /**
     * difference method
     * 
     * this method DOES NOT traverse years and months
     * 
     * @param other a second Date
     */
    public int difference(Date other)
    {
        int diffDay;
        
        diffDay = this.day - other.day;
        //in case of negative amount of days
        if(diffDay < 0)
            diffDay += 32;
        
        return diffDay;
    }
}