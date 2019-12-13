/**
 * Takes strings from a file, sends them to be converted, and then writes the new string to a file
 * 
 * @author Nicholas Wade 
 * @version 1.0 (24 February 2014)
 */

import java.util.*;
import java.io.*;

/*
 * WARNING: This program works only if each line ends with some sort of punctuation.
 */

public class Driver
{
    public static void main (String [] args) throws IOException
    {
        Scanner inputFile;
        Scanner input;
        String inputString;
        String outputString;
        Converter con;
        String fileName;
        
        input = new Scanner(System.in);
        con = new Converter();
        File outputFile = new File("outSentence.txt");
        PrintWriter outFile = new PrintWriter(outputFile);
        
        System.out.print("Enter the name of the file: ");
        fileName = input.next();
        
        inputFile = new Scanner(new File(fileName));
        
        while(inputFile.hasNext())
        {
            inputString = new String(inputFile.nextLine());
            con.setString(inputString);
            con.Convert();
            outputString = new String(con.getConverted());
            System.out.print(outputString + "\n");
            outFile.println(outputString);
        }
        outFile.close();
        inputFile.close();
    }
            
    
}
