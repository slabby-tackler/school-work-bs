/**
 * ITCS 2215 Assignment 2
 * 
 * Author:  Nicholas Wade
 * Version: 1.0
 * Notes:   I was not sure what the find root method was supposed to do, so
 * 			it is not included.  I managed to get the appropriate final weight,
 * 			but had one small error in the connections list that I was unsure of 
 * 			how to fix.  Other than these two things, it should run as expected.
 */

package itcs_2215_assignment_2;

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String args[]) throws IOException
	{
		String file;																//will hold location of file
		Scanner kb = new Scanner(System.in);										//for keyboard input
		Scanner inputFile;															//holds reference to file stream
		HashMap <String, Boolean> visited = new HashMap <String, Boolean>();		//hash that stores if a node has been touched
		ArrayList<Edge> edges = new ArrayList<Edge>();								//holds all the split lines in the file
		int end = 0;																//holds the final output
		
		System.out.println("Enter the name of the file");
		file = kb.nextLine();
		
		inputFile = new Scanner(new File(file));
		
		while(inputFile.hasNextLine())
		{
			String line = inputFile.nextLine();		//gets current line
			String[] split = line.split(",");		//splits up the current line on ','
			String node1 = split[0];
			visited.put(split[0], false);
			boolean first = true;
			
			for(int i = 1; i < split.length; i++)
			{
				if(first)
				{
					first = false;
					continue;
				}
				if((i % 2) == 0)
				{
					edges.add(new Edge(node1, split[i], split[i - 1]));
				}
				else
				{
					continue;
				}
			}
		}
		inputFile.close();
		kb.close();
		
		Collections.sort(edges);
		
		for(Edge e : edges)
		{
			if(visited.get(e.getNode1()))
			{
				continue;
			}
			else
			{
				visited.put(e.getNode1(), true);
				end += e.getWeight();
				System.out.println(e);
			}
		}
		
		System.out.println("total weight of tree: " + end); 																		//prints final result
	}
}

public class Edge implements Comparable
{
	private String node1;
	private String node2;
	private int weight;
	
	public Edge()
	{
		node1 = null;
		node2 = null;
		weight = 0;
	}
	
	public Edge(String n1, String n2, String w)
	{
		node1 = n1;
		node2 = n2;
		weight = Integer.parseInt(w);
	}
	
	public String toString()
	{
		return node1 + ", " + weight + ", " + node2;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public String getNode1()
	{
		return node1;
	}
	
	public String getNode2()
	{
		return node2;
	}

	@Override
	public int compareTo(Object opposite) 
	{
		int compareWeight = ((Edge)opposite).getWeight();
		
		return this.weight - compareWeight;
	}
}

