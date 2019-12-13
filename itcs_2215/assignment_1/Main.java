import java.util.*;
import java.io.*;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		String file;																//will hold location of file
		Scanner kb = new Scanner(System.in);										//for keyboard input
		Scanner inputFile;															//holds reference to file stream
		HashMap <String, Integer> connections = new HashMap <String, Integer>();	//hash that stores number of in-bound connections
		Queue <String> noInbound = new LinkedList<String>();						//queue that holds items with no in-bound connections
		ArrayList<String[]> lines = new ArrayList<String[]>();						//holds all the split lines in the file
		String start = null;														//start of the directed graph	
		String end = null;															//holds the final output
		
		System.out.println("Enter the name of the file");
		file = kb.nextLine();
		
		inputFile = new Scanner(new File(file));
		
		while(inputFile.hasNextLine())
		{
			String line = inputFile.nextLine();		//gets current line
			String[] split = line.split(",");		//splits up the current line on ','
			lines.add(split); 						//adds lines to iterate through later
			
			for(String s : split)
			{
				//used to locate start of topological graph
				if(connections.containsKey(s))
				{
					int inboundConnection = connections.get(s) + 1;
					connections.put(s, inboundConnection);
					noInbound.remove(s);
				}
				else
				{
					connections.put(s, 0);
					noInbound.add(s);
				}
			}
		}
		inputFile.close();
		
		if(!(noInbound.size() == 0)) //checks for starting point
		{
			while(!(noInbound.size() == 0)) //iterates until all elements have been been set to 0
			{
				start = noInbound.remove(); //pulls item off the top
				connections.put(start, -1); //reduces its connection value
				
				//adds to final output
				if(end == null)
				{
					end = start;
				}
				else
				{
					end += (", " + start); //adds the next in order to the end
				}
				
				//find the proper set of connection
				for(String[] line : lines)
				{
					if(line[0].equals(start)) //finds appropriate line
					{
						for(String key : line)
						{
							//decreases all values on this line by 1
							int value = connections.get(key) - 1;
							connections.put(key, value);
							
							//adds 0 connection items to queue
							if(value == 0)
							{
								noInbound.add(key);
							}
						}
					}
				}
			}
			System.out.println(end); //prints final result
		}
		else
		{
			System.out.println("There is no topological ordering for this graph");
		}
	}
	
}