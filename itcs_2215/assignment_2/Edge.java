package itcs_2215_assignment_2;

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
