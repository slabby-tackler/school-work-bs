/**
 * does a bunch of functions with arrays
 * 
 * @author Nicholas Wade 
 * @version 1.0 (21 February 2014)
 */
public class ArrayFunctions implements ArrayFunctionsInterface
{   
    /**
     * sortMe method sorts the array to ascending order
     * 
     * @param double[] an array doubles of any size
     * @return double[] an array of the same size and type
     */
    public double [ ] sortMe(double [ ] array)
    {
        double temp; //will hold a value
        double [] newArray = new double [array.length]; //creates a new array
        
        //copies the old array into the new
        for(int i = 0; i < newArray.length; i++)
        {
            newArray[i] = array[i];
        }
        
        //loop through the array
        for(int i = 1; i < newArray.length; i++)
        {
            int j = i;
            temp = newArray[i]; //puts array value into temp location
            while ((j > 0) && (newArray[j-1] > temp))
            {
                newArray[j] = newArray[j-1];//changes the array value at j to the lower number
                j--; // subtracts one from j
            }
            newArray[j] = temp; // puts the original array value into the array at point j
        }
         
        return newArray;
    }

    /**
     * getMax method finds the largest value of an array
     * 
     * @param double[] an array of doubles of any size
     * @return double the value that is the largest in an array
     */
    public double getMax(double [ ] array)
    {
        double result = -999999999;
        //result = smallest possible number, so any array could work
        //(the if in the for loop returns true at least once as 
        // long as array[1] != -999999999)
        
        //loop through the array
        for(int i = 0; i < array.length; i++)
        {
            if(result < array[i]) //checks if value is greater than result
            {
                result = array[i]; //changes result to that value
            }
        }
        return result;
    }
    
    /**
     * getMin method finds the smallest value of an array
     * 
     * @param double[] an array of doubles of any size
     * @return double the smallest value in the array
     */
    public double  getMin(double [ ]  array)
    {
        double result = 999999999;
        //result = largest possible number, so any array could work
        //(the if in the for loop returns true at least once as 
        // long as array[1] != 999999999)
        
        //loop through the array
        for(int i = 0; i < array.length; i++)
        {
            if(result > array[i]) //checks if value is greater than result
            {
                result = array[i]; //changes result if it is
            }
        }
        
        return result;
    }
    
    /**
     * whereAmI method finds the position of a specific value in an array
     * 
     * @param double[] an array of doubles of any size
     * @param double a value to search for
     * @return int the index of where the value is
     */
    public int whereAmI(double [ ] array, double  searchValue)
    {
        int position = 0; //holds the index value
     
        //loop through the array
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == searchValue)//checks if the search value is in that position of the array
            {
                position = i; //position is the index if found
            }
        }
     
        return position;
    }
 
    /**
     * sumMeUp method adds all values of the array
     * 
     * @param double[] an array of doubles of any size
     * @return double the sum of all values
     */
    public double sumMeUp(double [ ] array)
    {
        double sum = 0; //will hold the value of the sum
        
        //loop through the array
        for(int i = 0; i < array.length; i++)
        {
            sum += array[i]; //adds the value to the running total
        }
        
        return sum;
    }
 
    /**
     * reverseMe method reverses the array
     * 
     * @param double[] an array of doubles of any size
     * @return double[] the same array but in reverse order
     */
    public double [ ] reverseMe(double [ ] array)
    {
        int opposite = array.length; //sets a value to length of the array
        double[] newArray = new double[opposite]; //creates an array of same
                                                  //length
        //loop through the array
        for(int i = 0; opposite > 0; i ++)
        {
            newArray[i] = array[opposite - 1]; //reverse the order in the new array
            opposite--; //ensures it does not use the same value
        }
        
        return newArray;
    }
    
    /**
     * printMe method prints the array in one line
     * 
     * @param double[] an array of doubles of any size
     */
    public void printMe(double [ ] array)
    {
        //loop through the array
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " "); //prints each value followed by a space
        }
    }
    
    /**
     * doubleMySize method doubles the size of the array and puts the
     * original values back into it
     * 
     * @param double[] an array of doubles of any size
     * @return double[] an array of doubles twice the size of the original
     */
    public double[ ] doubleMySize(double [ ] array)
    {
        //creates an array with double the length of the original
        double [] newArray = new double [array.length * 2];
        
        //loop through the array
        for(int i = 0; i < array.length; i++)
        {
            newArray[i] = array[i]; //inputs old values into new array
        }
        
        return newArray;
    }
}
