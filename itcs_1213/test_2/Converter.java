
/**
 * changes the vowels of the string the user gives
 * 
 * @author Nicholas Wade 
 * @version 1.0 (11 March 2014)
 */
public class Converter
{   
    private String usersString;
    private StringBuilder stringToConvert;
    private String converted;
    private int count;
    
    
    /**
     * Creates the converter object
     * 
     * @param the string the user inputs
     */
    public Converter(String inString)
    {
        usersString = new String(inString);
        stringToConvert = new StringBuilder(usersString);
    }
    
    /**
     * changes the vowels of the string the user gives
     */
    public void convert()
    {
        char vowel;
        
        for(int index = 0; index < stringToConvert.length(); index++)
        {
            vowel = stringToConvert.charAt(index);
            
            System.out.println(vowel);
            
            switch(vowel)
            {
                case 'a':
                    stringToConvert.replace(index, index+1, "e");
                    count+=1;
                    break;
                case 'e':
                    stringToConvert.replace(index, index+1, "i");
                    count+=1;
                    break;
                case 'i':
                    stringToConvert.replace(index, index+1, "o");
                    count+=1;
                    break;
                case 'o':
                    stringToConvert.replace(index, index+1, "u");
                    count+=1;
                    break;
                case 'u':
                    stringToConvert.replace(index, index+1, "a");
                    count+=1;
                    break;
                    
                case 'A':
                    stringToConvert.replace(index, index+1, "E");
                    count+=1;
                    break;
                case 'E':
                    stringToConvert.replace(index, index+1, "I");
                    count+=1;
                    break;
                case 'I':
                    stringToConvert.replace(index, index+1, "O");
                    count=+1;
                    break;
                case 'O':
                    stringToConvert.replace(index, index+1, "U");
                    count+=1;
                    break;
                case 'U':
                    stringToConvert.replace(index, index+1, "A");
                    count +=1;
                    break;
                
                default:
                    break;
            }
        }
        converted = new String(stringToConvert); //puts the conversion into an new string
    }
    
    /**
     * gives the final count
     * 
     * @return gives the final count of the changes made
     */
    public int getCount()
    {
        return count;
    }
    
    /**
     * gives the original and converted string back to the user
     * 
     * @return the original string and the new converted one
     */
    public String toString()
    {
        return usersString + "\n" + converted + "\n";
    }
        
}
