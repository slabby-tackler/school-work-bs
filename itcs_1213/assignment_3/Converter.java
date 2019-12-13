/**
 * This class converts the numbers to is alphabetical representation
 * 
 * @author Nicholas Wade 
 * @version 1.0 (25 February 2014)
 */
public class Converter
{
    private String original; //holds the original string
    private String converted; //holds the final converstion
    private StringBuilder worker; //holds the malleable version of the string
    
    // used to create the converter object
    public Converter()
    {
        original = "null";
    }
    
    /**
     * set the original string to the input
     * create the string builder with the original string
     * 
     * @param inString input provided by driver from file
     */
    public void setString(String inString)
    {
        original = inString;
        worker = new StringBuilder(original);
    }
    
    //converts numbers to the textual representaion and builds a string for the converted text
    public void Convert()
    {
        for(int index = 0; index < original.length(); index++)
        {
            if(index == 0)
            {
            if (worker.charAt(index+1) != ' ')
            {}
            else
            {
                 if (worker.charAt(index) == '0')
                 {
                     worker.replace(index, index + 1, "Zero");
                  }
                 else if (worker.charAt(index) == '1')
                 {
                     worker.replace(index, index + 1, "One");
                  }
                 else if (worker.charAt(index) == '2')
                 {
                     worker.replace(index, index + 1, "Two");
                  }
                 else if (worker.charAt(index) == '3')
                 {
                     worker.replace(index, index + 1, "Three");
                  }
                 else if (worker.charAt(index) == '4')
                 {
                     worker.replace(index, index + 1, "Four");
                  }
                 else if (worker.charAt(index) == '5')
                 {
                     worker.replace(index, index + 1, "Five");
                  }
                 else if (worker.charAt(index) == '6')
                 {
                     worker.replace(index, index + 1, "Six");
                  }
                 else if (worker.charAt(index) == '7')
                 {
                     worker.replace(index, index + 1, "Seven");
                  }
                 else if (worker.charAt(index) == '8')
                 {
                     worker.replace(index, index + 1, "Eight");
                  }
                 else if (worker.charAt(index) == '9')
                 {
                     worker.replace(index, index + 1, "Nine");
                 }}}
            if (index > 0 && (worker.charAt(index-1) != ' ' || worker.charAt(index+1) != ' '))
            {}
            else
            {
                if (worker.charAt(index) == '0')
                {
                     worker.replace(index, index + 1, "zero");
                 }
                else if (worker.charAt(index) == '1')
                {
                     worker.replace(index, index + 1, "one");
                 }
                else if (worker.charAt(index) == '2')
                {
                     worker.replace(index, index + 1, "two");
                 }         
                else if (worker.charAt(index) == '3')
                {
                     worker.replace(index, index + 1, "three");
                 } 
                else if (worker.charAt(index) == '4')
                {
                     worker.replace(index, index + 1, "four");
                 }
                else if (worker.charAt(index) == '5')
                {
                     worker.replace(index, index + 1, "five");
                 }
                else if (worker.charAt(index) == '6')
                {
                     worker.replace(index, index + 1, "six");
                 } 
                else if (worker.charAt(index) == '7')
                {
                     worker.replace(index, index + 1, "seven");
                 }
                else if (worker.charAt(index) == '8')
                {
                     worker.replace(index, index + 1, "eight");
                 } 
                else if (worker.charAt(index) == '9')
                {
                     worker.replace(index, index + 1, "nine");
                 }}
            converted = new String(worker);}}
                        
    /**
     * returns the converted string
     * @return converted
     */
    public String getConverted()
    {
        return converted;
     }
   }
